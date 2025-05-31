
package linkedlist.leetcode;

import linkedlist.leetcode.common.DoublyLinkedList;
import linkedlist.leetcode.common.DoublyNode;

public class ReverseDoublyLinkedList {

    private static DoublyNode reverseDoubly(DoublyLinkedList doublyLinkedList){
        if (doublyLinkedList.head == null || doublyLinkedList.head.next == null){
            return doublyLinkedList.head;
        }
        DoublyNode temp = null;
        DoublyNode current = doublyLinkedList.head;
        while (current != null){
            // swap the previous and next pointers
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // Move to the next node in the original list
            current = current.prev;
        }
        // update the head of the list to the new head
        if (temp != null){
            doublyLinkedList.head = temp.prev;
        }
        return doublyLinkedList.head;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(0,10);
        list.insert(1,20);
        list.insert(2,30);
        list.insert(3,40);
        list.insert(4,50);
        System.out.println("original list before reverse : ");
        list.printDLL();
        System.out.println("after reverse : ");
        list.printDLL();
        DoublyNode reversedNode = reverseDoubly(list);
        System.out.println("Head of reversed doubly linked list is : "+reversedNode.data);
    }
}
