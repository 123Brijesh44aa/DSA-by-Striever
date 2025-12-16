Below are **simple, clear explanations** with **complete working Java examples** for **all questions**.
Each program is **independent** and can be run separately.

---

## **Lab 1: Basic Multithreading Concepts**

---

## **Question 1: Thread Creation (Odd & Even Numbers)**

### Idea

Create two threads:

* One prints **odd numbers**
* One prints **even numbers**

They run **at the same time**, so output order may mix.

### Code

```java
class OddThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("Odd: " + i);
        }
    }
}

class EvenThread extends Thread {
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Even: " + i);
        }
    }
}

public class Q1_OddEven {
    public static void main(String[] args) {
        new OddThread().start();
        new EvenThread().start();
    }
}
```

---

## **Question 2: Thread vs Runnable**

### (A) Extending Thread

```java
class CountThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++)
            System.out.println(i);
    }
}
```

### (B) Implementing Runnable

```java
class CountRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++)
            System.out.println(i);
    }
}

public class Q2_ThreadVsRunnable {
    public static void main(String[] args) {
        new CountThread().start();
        new Thread(new CountRunnable()).start();
    }
}
```

### Comparison

| Thread                      | Runnable                 |
| --------------------------- | ------------------------ |
| Cannot extend another class | Can extend another class |
| Less flexible               | More flexible            |
| Not recommended             | Recommended              |

---

## **Question 3: Thread Lifecycle**

### States shown:

* NEW
* RUNNABLE
* TIMED_WAITING
* TERMINATED

### Code

```java
class LifeThread extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
    }
}

public class Q3_Lifecycle {
    public static void main(String[] args) throws Exception {
        LifeThread t = new LifeThread();

        System.out.println("State after creation: " + t.getState());
        t.start();
        System.out.println("State after start: " + t.getState());

        Thread.sleep(500);
        System.out.println("State during sleep: " + t.getState());

        t.join();
        System.out.println("State after completion: " + t.getState());
    }
}
```

---

## **Question 4: Thread Naming & Priority**

```java
class MyThread extends Thread {
    public MyThread(String name, int priority) {
        setName(name);
        setPriority(priority);
    }

    public void run() {
        System.out.println(getName() + " Priority: " + getPriority());
        for (int i = 1; i <= 5; i++)
            System.out.println(getName() + " Count: " + i);
    }
}

public class Q4_Priority {
    public static void main(String[] args) {
        new MyThread("Low", Thread.MIN_PRIORITY).start();
        new MyThread("Normal", Thread.NORM_PRIORITY).start();
        new MyThread("High", Thread.MAX_PRIORITY).start();
    }
}
```

---

## **Question 5: Daemon Threads**

```java
class UserThread extends Thread {
    public void run() {
        for (int i = 1; i <= 20; i++)
            System.out.println("User: " + i);
    }
}

class DaemonThread extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++)
            System.out.println("Daemon: " + i);
    }
}

public class Q5_Daemon {
    public static void main(String[] args) {
        DaemonThread d = new DaemonThread();
        d.setDaemon(true);

        d.start();
        new UserThread().start();
    }
}
```

👉 JVM stops after **user thread ends**, daemon stops automatically.

---

## **Question 6: Thread Sleep (Clock)**

```java
class ClockThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Tick " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}

public class Q6_Clock {
    public static void main(String[] args) {
        new ClockThread().start();
    }
}
```

---

## **Question 7: join() Method**

```java
class T extends Thread {
    int start, end;

    T(int s, int e) {
        start = s; end = e;
    }

    public void run() {
        for (int i = start; i <= end; i++)
            System.out.println(i);
    }
}

public class Q7_Join {
    public static void main(String[] args) throws Exception {
        T t1 = new T(1, 5);
        T t2 = new T(6, 10);
        T t3 = new T(11, 15);

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
    }
}
```

---

## **Question 8: Synchronization (Race Condition)**

### Without Synchronization

```java
class Counter {
    int count = 0;
    void increment() {
        count++;
    }
}
```

### With Synchronization

```java
class Counter {
    int count = 0;
    synchronized void increment() {
        count++;
    }
}
```

### Main

```java
public class Q8_Counter {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Count: " + c.count);
    }
}
```

---

## **Question 9: Synchronized Method vs Block**

```java
class Printer {
    synchronized void printMethod(String msg) {
        System.out.println(msg);
    }

    void printBlock(String msg) {
        synchronized (this) {
            System.out.println(msg);
        }
    }
}
```

### Difference

* **Method** → locks entire method
* **Block** → locks only specific part (better performance)

---

## **Question 10: Static Synchronization**

```java
class SyncDemo {
    synchronized void instanceMethod() {
        System.out.println("Instance lock");
    }

    static synchronized void staticMethod() {
        System.out.println("Class lock");
    }
}
```

* Instance method → **object-level lock**
* Static method → **class-level lock**

---

## **Question 11: Producer–Consumer (wait & notify)**

```java
class Buffer {
    int data;
    boolean empty = true;

    synchronized void produce(int value) throws Exception {
        while (!empty) wait();
        data = value;
        empty = false;
        System.out.println("Produced: " + value);
        notify();
    }

    synchronized void consume() throws Exception {
        while (empty) wait();
        System.out.println("Consumed: " + data);
        empty = true;
        notify();
    }
}

public class Q11_PC {
    public static void main(String[] args) {
        Buffer b = new Buffer();

        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) b.produce(i);
            } catch (Exception e) {}
        }).start();

        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) b.consume();
            } catch (Exception e) {}
        }).start();
    }
}
```

---

## **Question 12: Thread Interruption**

```java
class InfiniteThread extends Thread {
    public void run() {
        while (!isInterrupted()) {
            System.out.println("Running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
                break;
            }
        }
    }
}

public class Q12_Interrupt {
    public static void main(String[] args) throws Exception {
        InfiniteThread t = new InfiniteThread();
        t.start();

        Thread.sleep(3000);
        t.interrupt();
    }
}
```

---

## **Question 13: CountDownLatch**

```java
import java.util.concurrent.CountDownLatch;

public class Q13_Latch {
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(4);

        for (int i = 1; i <= 4; i++) {
            new Thread(() -> {
                System.out.println("Runner ready");
                latch.countDown();
            }).start();
        }

        latch.await();
        System.out.println("Race started!");
    }
}
```

---

## **Question 14: Semaphore**

```java
import java.util.concurrent.Semaphore;

class Pool {
    Semaphore sem = new Semaphore(3);

    void use() throws Exception {
        sem.acquire();
        System.out.println(Thread.currentThread().getName() + " using connection");
        Thread.sleep(1000);
        sem.release();
    }
}

public class Q14_Semaphore {
    public static void main(String[] args) {
        Pool p = new Pool();

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try { p.use(); } catch (Exception e) {}
            }).start();
        }
    }
}
```

---

## **Question 15: ReentrantLock**

```java
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

class Counter {
    int count = 0;
    ReentrantLock lock = new ReentrantLock();

    void increment() {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                count++;
                lock.unlock();
            }
        } catch (Exception e) {}
    }
}

public class Q15_ReentrantLock {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Count: " + c.count);
    }
}
```

---

If you want:

* **output screenshots**
* **viva answers**
* **short exam notes**
* **PDF or Word format**

tell me what you need next.
