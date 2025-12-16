Below are **easy explanations** and **complete Java programs** for **all Exception Handling questions**.
Each question is **independent**, **well-structured**, and suitable for **lab submission & viva**.

---

# **Java Exception Handling Lab Exercises**

---

## **Question 1: Basic Exception Handling**

### Concept

* `ArithmeticException` → divide by zero
* `InputMismatchException` → invalid input

### Program

```java
import java.util.Scanner;
import java.util.InputMismatchException;

public class Q1_Division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            int result = a / b;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integers");

        } finally {
            sc.close();
        }
    }
}
```

---

## **Question 2: Custom Exception Class**

### Concept

Create a user-defined exception using `extends Exception`.

### Program

```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Q2_AgeValidation {
    static void checkAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Invalid age: " + age);
        }
        System.out.println("Valid age entered: " + age);
    }

    public static void main(String[] args) {
        try {
            checkAge(200);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

---

## **Question 3: Multiple Catch Blocks**

### Concept

Handle **different exceptions separately**.

### Program

```java
import java.util.Scanner;
import java.util.InputMismatchException;

public class Q3_ArrayAccess {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter index: ");
            int index = sc.nextInt();
            System.out.println("Value: " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of range");

        } catch (InputMismatchException e) {
            System.out.println("Error: Enter integer only");

        } finally {
            sc.close();
        }
    }
}
```

---

## **Question 4: Finally Block Demonstration**

### Concept

`finally` **always executes**, whether exception occurs or not.

### Program

```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Q4_Finally {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("test.txt");
            System.out.println("File opened");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        } finally {
            try {
                if (fis != null) {
                    fis.close();
                    System.out.println("File closed");
                }
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }
}
```

---

## **Question 5: Exception Propagation**

### Concept

Exception moves **methodC → methodB → methodA** until handled.

### Program

```java
public class Q5_Propagation {

    static void methodC() {
        int a = 10 / 0;
    }

    static void methodB() {
        methodC();
    }

    static void methodA() {
        try {
            methodB();
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in methodA");
        }
    }

    public static void main(String[] args) {
        methodA();
    }
}
```

---

## **Question 6: Try-with-Resources**

### Concept

Resources are **closed automatically**.

### Program

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q6_CopyFile {
    public static void main(String[] args) {
        try (
            FileInputStream fis = new FileInputStream("input.txt");
            FileOutputStream fos = new FileOutputStream("output.txt");
        ) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully");

        } catch (IOException e) {
            System.out.println("IO Error occurred");
        }
    }
}
```

---

## **Question 7: Throw and Throws**

### Concept

* `throw` → actually throws exception
* `throws` → declares exception

### Program

```java
class WeakPasswordException extends Exception {
    public WeakPasswordException(String msg) {
        super(msg);
    }
}

public class Q7_Password {

    static void validatePassword(String password) throws WeakPasswordException {
        if (password.length() < 8) {
            throw new WeakPasswordException("Password too short");
        }
        System.out.println("Strong password");
    }

    public static void main(String[] args) {
        try {
            validatePassword("abc123");
        } catch (WeakPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

---

## **Question 8: Nested Try-Catch**

### Concept

Exception handled in **inner block first**, then outer.

### Program

```java
public class Q8_NestedTry {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("10");

            try {
                int result = num / 0;
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException handled");
            }

        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled");
        }

        System.out.println("Program continues");
    }
}
```

---

## **Question 9: Exception Chaining**

### Concept

One exception **causes another**.

### Program

```java
class DataProcessingException extends Exception {
    public DataProcessingException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

public class Q9_Chaining {
    public static void main(String[] args) {
        try {
            throw new java.io.FileNotFoundException("File missing");

        } catch (java.io.FileNotFoundException e) {
            DataProcessingException ex =
                new DataProcessingException("Processing failed", e);

            System.out.println(ex.getMessage());
            System.out.println("Cause: " + ex.getCause());
        }
    }
}
```

---

## **Question 10: Banking Application (Comprehensive)**

### Custom Exceptions

```java
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) {
        super(msg);
    }
}

class AccountLockedException extends Exception {
    public AccountLockedException(String msg) {
        super(msg);
    }
}
```

### BankAccount Class

```java
class BankAccount {
    double balance = 1000;
    boolean locked = false;

    void deposit(double amount)
            throws InvalidAmountException, AccountLockedException {
        if (locked) throw new AccountLockedException("Account locked");
        if (amount <= 0) throw new InvalidAmountException("Invalid deposit");
        balance += amount;
    }

    void withdraw(double amount)
            throws InvalidAmountException, InsufficientFundsException, AccountLockedException {
        if (locked) throw new AccountLockedException("Account locked");
        if (amount <= 0) throw new InvalidAmountException("Invalid withdrawal");
        if (amount > balance) throw new InsufficientFundsException("Insufficient balance");
        balance -= amount;
    }
}
```

### Main Program

```java
import java.util.Scanner;

public class Q10_BankApp {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        Scanner sc = new Scanner(System.in);

        try {
            acc.withdraw(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
```

---

## ✅ **You now have**

* Simple explanations
* Fully working programs
* Lab-ready answers
* Viva-friendly logic

If you want:

* **Short exam answers**
* **Viva questions**
* **PDF / DOC submission**
* **Output samples**

tell me what you want next.
