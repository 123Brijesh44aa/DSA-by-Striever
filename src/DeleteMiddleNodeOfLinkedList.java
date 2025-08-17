import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

public class DeleteMiddleNodeOfLinkedList {

    // BRUTE FORCE
    // find the length of linked list
    // traverse till floor(length/2)
    // floor(3.3) = 3
    // floor(2.1) = 2
    // floor(5) = 5
    // floor(-2.5) = -3

    private static Node deleteMiddleNode_bf(LinkedList linkedList) {
        if (linkedList.head == null || linkedList.head.next == null) {
            linkedList.head = null;
            return linkedList.head;
        }
        int length = 0;
        Node temp = linkedList.head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        temp = linkedList.head;
        int steps = (int) Math.floor(length / 2);
        while (temp != null) {
            steps--;
            if (steps == 0) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return linkedList.head;
    }

    // USING SLOW AND FAST POINTER
    private static Node deleteMiddleNode(LinkedList linkedList) {
        if (linkedList.head == null || linkedList.head.next == null) {
            // empty list or single node list
            linkedList.head = null;
            return linkedList.head;
        }
        Node slow = linkedList.head;
        Node fast = linkedList.head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return linkedList.head;
    }

    public static void main(String[] args) {

    }
}
