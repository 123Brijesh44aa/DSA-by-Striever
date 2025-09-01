import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

public class MergeTwoSortedLinkedList21 {

    // You are given the heads of two sorted linked lists list1 and list2.

    // Merge the two lists into one sorted list. The list should be made by splicing
    // together the nodes of the first two lists.

    // Return the head of the merged linked list.

    // Example 1:

    // Input: list1 = [1,2,4], list2 = [1,3,4]
    // Output: [1,1,2,3,4,4]
    // Example 2:

    // Input: list1 = [], list2 = []
    // Output: []
    // Example 3:

    // Input: list1 = [], list2 = [0]
    // Output: [0]

    private static Node mergeList(LinkedList list1, LinkedList list2) {
        Node t1 = list1.head;
        Node t2 = list2.head;
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }

        if (t1 != null) {
            temp.next = t1;
        } else {
            temp.next = t2;
        }

        return dummy.next;

    }

    public static void main(String[] args) {

    }
}
