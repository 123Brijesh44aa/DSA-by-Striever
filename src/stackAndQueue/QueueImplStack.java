package stackAndQueue;

import java.util.Stack;

public class QueueImplStack {

    // APPROACH 1

    // private Stack<Integer> stack1 = new Stack<>();
    // private Stack<Integer> stack2 = new Stack<>();

    // void push(Integer item) { // this push operation is too expensive if number
    // of items in Stack is too many
    // while (!stack1.empty()) {
    // stack2.push(stack1.pop());
    // }
    // stack1.push(item);
    // while (!stack2.isEmpty()) {
    // stack1.push(stack2.pop());
    // }
    // }

    // Integer top() {
    // if (stack1.isEmpty()) {
    // System.out.println("Queue is empty");
    // return -1;
    // }
    // return stack1.peek();
    // }

    // Integer pop() {
    // if (stack1.isEmpty()) {
    // System.out.println("Queue is empty");
    // return -1;
    // }
    // return stack1.pop();
    // }

    // APPROACH 2 ( more optimized )

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    void push(Integer item) {
        stack1.push(item);
    }

    Integer pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    Integer top() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }

    public static void main(String[] args) {

    }
}
