package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplQueue {
    Queue<Integer> queue = new LinkedList<>();

    void push(Integer item) {
        int size = queue.size();
        queue.add(item);
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }

    Integer pop() {
        return queue.remove();
    }

    Integer top() {
        return queue.peek();
    }

    int length() {
        return queue.size();
    }

    public static void main(String[] args) {

    }
}
