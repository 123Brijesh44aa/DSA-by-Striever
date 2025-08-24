import linkedlist.leetcode.common.DoublyLinkedList;
import linkedlist.leetcode.common.DoublyNode;

public class RemoveDuplicatesFromSortedDLL {

    // Problem Description:
    // Given a sorted doubly linked list, remove all duplicate nodes such that each
    // element appears only once.
    //
    // Input:
    // - A sorted doubly linked list where duplicate values may appear
    // consecutively.
    //
    // Output:
    // - The same doubly linked list with all duplicates removed, preserving the
    // original order.
    //
    // Example:
    // Input: 1 <-> 2 <-> 2 <-> 3 <-> 4 <-> 4 <-> 5
    // Output: 1 <-> 2 <-> 3 <-> 4 <-> 5
    //
    // Explanation:
    // The input list contains duplicate values (2 and 4). After removing
    // duplicates, only unique values remain in the list.

    private static DoublyLinkedList removeDups(DoublyLinkedList list) {
        DoublyNode current = list.head;
        if (current == null || current.next == null) {
            return list;
        }
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                DoublyNode nodeToBeDeleted = current.next;
                current.next = nodeToBeDeleted.next;
                if (nodeToBeDeleted.next != null) {
                    nodeToBeDeleted.next.prev = current;
                }
            } else {
                current = current.next;
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
