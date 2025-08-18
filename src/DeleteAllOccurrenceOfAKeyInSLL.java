import linkedlist.leetcode.common.DoublyLinkedList;
import linkedlist.leetcode.common.DoublyNode;
import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

public class DeleteAllOccurrenceOfAKeyInSLL {

    /*
     * Problem Description:
     * Given a singly linked list and a key, delete all occurrences of the given key
     * in the linked list.
     * 
     * Input:
     * - The first line contains an integer n, the number of nodes in the linked
     * list.
     * - The second line contains n space-separated integers, representing the
     * elements of the linked list.
     * - The third line contains an integer key, the value to be deleted from the
     * linked list.
     * 
     * Output:
     * - Print the linked list after deleting all occurrences of the given key. If
     * the linked list becomes empty, print "Empty List".
     * 
     * Example:
     * Input:
     * 6
     * 1 2 2 3 4 2
     * 2
     * 
     * Output:
     * 1 3 4
     * 
     * Explanation:
     * All nodes with value 2 are removed from the linked list. The remaining nodes
     * are 1, 3, and 4.
     */

    private static Node deleteAllOccurrence(LinkedList linkedList, int val) {
        while (linkedList.head != null && linkedList.head.data == val) {
            linkedList.head = linkedList.head.next;
        }
        Node temp = linkedList.head;
        Node prev = null;
        while (temp != null) {
            if (temp.data == val) {
                prev.next = temp.next;
            } else {
                prev = temp;
            }
            temp = temp.next;
        }

        return linkedList.head;
    }

    public static void main(String[] args) {

    }
}
