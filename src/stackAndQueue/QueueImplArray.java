package stackAndQueue;

public class QueueImplArray {

    int size;
    int[] queue;
    int currentSize = 0;
    int start = -1;
    int end = -1;

    public QueueImplArray(int size) {
        this.size = size;
        this.queue = new int[size];
    }

    public void enqueue(int item) {
        if (currentSize >= size) {
            System.out.println("Queue overflow");
            return;
        }
        if (currentSize == 0) {
            start = end = 0;
        } else {
            end = (end + 1) % size;
        }
        queue[end] = item;
        currentSize += 1;
    }

    public int pop() {
        if (currentSize == 0) {
            System.out.println("Queue is empty");
        }
        int element = queue[start];
        if (currentSize == 1) {
            start = end = -1;
        } else {
            start = (start + 1) % size;
        }
        currentSize -= 1;
        return element;
    }

    public int top() {
        if (currentSize == 0) {
            System.out.println("queue is empty");
        }
        return queue[start];
    }

    public int size() {
        return currentSize;
    }

    public static void main(String[] args) {
        QueueImplArray queue = new QueueImplArray(5);
        queue.enqueue(9);
        queue.enqueue(99);
        queue.enqueue(43);
        queue.enqueue(32);
        queue.enqueue(30);
        // queue.enqueue(88);
        queue.pop();
        queue.pop();

        queue.enqueue(500);
        queue.enqueue(400);

        queue.pop();
        queue.pop();
        queue.pop();

        System.out.println(queue.top());

        System.out.println("queue's current size is : " + queue.size());
    }
}
