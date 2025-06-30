package stackAndQueue;

class QueueNode {
    public int data;
    public QueueNode next;

    public QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueImplLinkedList {
    private int length;
    private QueueNode head;
    private QueueNode tail;

    public QueueImplLinkedList() {
        this.length = 0;
        head = null;
        tail = null;
    }

    // push() / enqueue() => adding node at the end
    void push(int data) {
        QueueNode newNode = new QueueNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // pop() / dequeue() => deleting node at beginning and returning it
    int pop() {
        if (head == null) {
            System.out.println("queue is empty");
            return -1;
        }
        int elementToBeDeleted = head.data;
        if (length == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        length--;
        return elementToBeDeleted;
    }

    // top() => access beginning element/node without removing it
    int top() {
        if (head == null) {
            System.out.println("queue is empty");
            return -1;
        } else {
            return head.data;
        }
    }

    int size() {
        return length;
    }

    public static void main(String[] args) {
        QueueImplLinkedList queue = new QueueImplLinkedList();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);
        queue.push(50);
        System.out.println("front element is : " + queue.top());
        System.out.println("queue size : " + queue.size());
        System.out.println("after 2 pop");
        queue.pop();
        queue.pop();
        System.out.println("front element : " + queue.top());
        System.out.println("queue size : " + queue.size());
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();

        System.out.println();

        System.out.println("front element : " + queue.top());
        System.out.println("queue size : " + queue.size());

    }
}
