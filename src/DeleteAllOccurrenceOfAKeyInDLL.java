import linkedlist.leetcode.common.DoublyLinkedList;
import linkedlist.leetcode.common.DoublyNode;

public class DeleteAllOccurrenceOfAKeyInDLL {

    /*
     * Problem Description:
     * Given a doubly linked list and a key, delete all occurrences of the given key
     * in the doubly linked list.
     * 
     * Input:
     * - The first line contains an integer N, the number of nodes in the doubly
     * linked list.
     * - The second line contains N space-separated integers representing the
     * elements of the doubly linked list.
     * - The third line contains an integer K, the key to be deleted from the list.
     * 
     * Output:
     * - Print the modified doubly linked list after deleting all occurrences of the
     * key. If the list becomes empty, print "Empty List".
     * 
     * Example:
     * Input:
     * 6
     * 2 2 10 8 4 2
     * 2
     * 
     * Output:
     * 10 8 4
     * 
     * Explanation:
     * All nodes with value 2 are deleted from the list. The remaining nodes are 10,
     * 8, and 4.
     */

    private static DoublyNode deleteAllOccurrence(DoublyLinkedList doublyLinkedList, int val) {
        DoublyNode temp = doublyLinkedList.head;
        while (temp != null) {
            if (temp.data == val) {
                if (temp == doublyLinkedList.head) {
                    doublyLinkedList.head = temp.next;
                }
                DoublyNode nextNode = temp.next;
                DoublyNode prevNode = temp.prev;
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }
                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }
        return doublyLinkedList.head;
    }

    public static void main(String[] args) {

    }
}
