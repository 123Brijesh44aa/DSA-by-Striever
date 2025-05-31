package linkedlist.leetcode;

import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

public class ReverseSinglyLinkedList {

    private static Node reverseSLL(LinkedList linkedList){
        Node prev = null;
        Node next = null;
        Node current = linkedList.head;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        linkedList.head = prev;
        return linkedList.head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(0,10);
        list.insert(1,20);
        list.insert(2,30);
        list.insert(3,40);
        list.insert(4,50);
        System.out.println("original list : ");
        list.printList();
        System.out.println("Reversed list :");
        Node reversedHead = reverseSLL(list);
        list.printList();
    }
}
