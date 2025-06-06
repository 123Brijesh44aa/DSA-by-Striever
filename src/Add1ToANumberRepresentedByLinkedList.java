import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

public class Add1ToANumberRepresentedByLinkedList {

    private static void reverseLinkedList(LinkedList linkedList){
        Node next = null;
        Node prev = null;
        Node temp = linkedList.head;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp; 
            temp = next;
        }
        linkedList.head = prev;
    }


    private static LinkedList add_1_to_a_number_represented_by_linkedList(LinkedList linkedList){
        reverseLinkedList(linkedList);
        Node temp = linkedList.head;
        int carry = 1;
        while (temp != null) {
            temp.data = temp.data + carry;
            if (temp.data < 10) {
                carry = 0;
                break;
            } else { //temp.data == 10
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }
        if (carry == 1) {
            Node newNode = new Node(1);
            reverseLinkedList(linkedList);
            newNode.next = linkedList.head;
            linkedList.head = newNode;
            return linkedList;
        }
        reverseLinkedList(linkedList);
        return linkedList;
    }


    // Better approach using Recursion (Backtracking)
    private static int helper(Node temp) {
        if (temp == null) {
            return 1;
        }
        int carry = helper(temp.next);
        temp.data = temp.data + carry;
        if (temp.data < 10) {
            return 0;
        }
        temp.data = 0;
        return 1;
    }

    private static LinkedList add_1_to_a_num_represented_by_ll_backtracking(LinkedList linkedList) {
        int carry = helper(linkedList.head);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = linkedList.head;
            linkedList.head = newNode;
        }
        return linkedList;
    }
    


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(0, 1);
        list.insert(1, 5);
        list.insert(2, 9);
        System.out.println("original list is : ");
        list.printList();
        list = add_1_to_a_number_represented_by_linkedList(list);
        System.out.println("Linked list after adding 1 :");
        list.printList();

        System.out.println();

        LinkedList list2 = new LinkedList();
        list2.insert(0, 9);
        list2.insert(1, 9);
        list2.insert(2, 9);
        list2.insert(3, 9);
        System.out.println("original list2");
        list2.printList();
        System.out.println("list2 after adding 1");
        list2 = add_1_to_a_number_represented_by_linkedList(list2);
        list2.printList();

        // using backtracking
        LinkedList linkedList = new LinkedList();
        linkedList.insert(0, 1);
        linkedList.insert(1, 5);
        linkedList.insert(2, 9);
        System.out.println("linked list affter adding 1");
        linkedList = add_1_to_a_num_represented_by_ll_backtracking(linkedList);
        linkedList.printList();
    }
}
