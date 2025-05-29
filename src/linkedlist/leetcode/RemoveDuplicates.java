package linkedlist.leetcode;

import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

import java.util.HashSet;

public class RemoveDuplicates {

    private static LinkedList removeDup(LinkedList linkedList) {
        if (linkedList.head == null) {
            return linkedList; // Return if the list is empty
        }

        Node current = linkedList.head;
        Node prev = null;
        HashSet<Integer> set = new HashSet<>();

        while (current != null) {
            if (set.contains(current.data)) {
                // Duplicate found, remove the node
                prev.next = current.next;
                linkedList.length--;
            } else {
                // Add data to the set and move prev pointer
                set.add(current.data);
                prev = current;
            }
            current = current.next; // Move to the next node
        }

        return linkedList;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(0,1);
        list.insert(1,2);
        list.insert(2,1);
        list.insert(3,3);
        list.insert(9,3);
        System.out.println("Original LinkedList : ");
        list.printList();
        list = removeDup(list);
        System.out.println("After removing Duplicates :");
        list.printList();
    }
}
