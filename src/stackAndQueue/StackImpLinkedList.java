package stackAndQueue;

class StackNode {
    public int data;
    public StackNode next;

    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackImpLinkedList {
    private int length;
    StackNode head;
    StackNode tail;

    public StackImpLinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    // push operation OR inserting at beginning
    void push(int data) {
        StackNode newNode = new StackNode(data);
        if (head == null) { // no element
            head = tail = newNode;
        } else { // one or more than one elements
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // pop operation OR deleting at the beginning
    void pop() {
        if (head == null) {
            System.out.println("Stack is empty");
            return;
        }
        if (length == 1) {
            head = tail = null;
            length--;
        } else {
            head = head.next;
            length--;
        }
    }

    // top() -> access top item OR beginning node
    int top() {
        if (head == null) {
            return -1;
        } else {
            return head.data;
        }
    }

    int size() {
        return length;
    }

    public static void main(String[] args) {
        StackImpLinkedList stack = new StackImpLinkedList();
        stack.push(99);
        stack.push(43);
        stack.push(44);
        stack.push(22);
        System.out.println("Stack length is : " + stack.size());
        System.out.println("top elementn : " + stack.top());

        stack.pop();
        stack.pop();

        System.out.println("after 2 pop operation");
        System.out.println("stack length is :" + stack.size());
        System.out.println("top elementn : " + stack.top());

        stack.pop();
        stack.pop();
        // stack.pop();

        System.out.println("size :" + stack.size());

    }
}
