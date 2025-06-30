import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

public class OddEvenLinkedList {

    private static LinkedList oddIndexFirstEvenIndexAfter(LinkedList linkedList){
        if (linkedList.head == null || linkedList.head.next == null) {
            return linkedList;
        }
        Node odd = linkedList.head;
        Node even = linkedList.head.next;
        Node evenHead = linkedList.head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return linkedList;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(0, 2);
        linkedList.insert(1, 3);
        linkedList.insert(2, 1);
        linkedList.insert(3, 4);
        linkedList.insert(4, 5);
        linkedList.insert(5, 6);
        System.out.println("Original Linked list is : ");
        linkedList.printList();
        linkedList = oddIndexFirstEvenIndexAfter(linkedList);
        System.out.println("After performing odd even operation : ");
        linkedList.printList();
    }
}
