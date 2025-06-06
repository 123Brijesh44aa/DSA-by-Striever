package stackAndQueue;

public class StackImplArray {
    int size;
    int top = -1;
    private int[] stack = new int[size];

    public StackImplArray(int size) {
        this.size = size;
        this.stack = new int[size];
    }

    public boolean isStackOverflow() { // check if stack is full
        return top >= size - 1;
    }

    public boolean isStackUnderflow() { // check if stack is empty
        return top == -1;
    }

    public void push(int item) {
        if (isStackOverflow()) {
            // stack is overflow
            System.out.println("StackOverflow");
            return;
        }
        top = top + 1;
        stack[top] = item;
    }

    public int top() { // also known as peek() operation
        if (isStackUnderflow()) {
            System.out.println("Stack is empty");
        }
        return stack[top];
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
        }
        top = top - 1;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        StackImplArray stack = new StackImplArray(5);
        stack.push(99);
        stack.push(88);
        stack.push(77);
        stack.push(43);
        stack.push(32);
        // stack.push(800); // stack overflow
        System.out.println(stack.top());
        System.out.println("stack size is : " + stack.size());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("now top element in stack is :" + stack.top());
    }
}
