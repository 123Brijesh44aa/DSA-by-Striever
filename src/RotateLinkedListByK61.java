import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

public class RotateLinkedListByK61 {

    private static LinkedList rotateByK(LinkedList linkedList, int k) {
        if (linkedList.head == null || linkedList.head.next == null) {
            return linkedList;
        }
        Node temp = linkedList.head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        Node tail = temp;

        k = k % length;

        if (k == 0) {
            return linkedList;
        }

        temp = linkedList.head;

        int steps = length - k;

        for (int i = 0; i < steps - 1; i++) {
            temp = temp.next;
        }

        Node next = temp.next;
        temp.next = null;
        tail.next = linkedList.head;
        linkedList.head = next;

        return linkedList;

    }

    public static void main(String[] args) {

    }
}
