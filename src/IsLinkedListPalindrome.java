import java.util.Stack;

import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

public class IsLinkedListPalindrome {

    // brute force approach
    // using stack data structure to preserve the linked list elements
    private static boolean isPalindrome(LinkedList linkedList) {
        Node temp = linkedList.head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = linkedList.head;
        while (temp != null) {
            if (temp.data != stack.pop()) {
                return false;
            } else {
                temp = temp.next;
            }
        }
        return true;
    }

    // optimal approach
    // 3 steps process
    // 1 step : find the middle node of the linked list : using two pointer ( slow
    // and fast )
    // 2 step : reverse the second half of the linked list
    // 3 step : compare first half with second half

    private static Node middleNode(LinkedList linkedList) {
        // find the middle node of the linked list
        if (linkedList.head == null || linkedList.head.next == null) {
            return linkedList.head;
        }

        // find middle
        Node slow = linkedList.head;
        Node fast = linkedList.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node reverse(Node middleNode){
        // reverse a linked list
        if (middleNode == null || middleNode.next == null) {
            return middleNode;
        }
        Node next = null;
        Node prev = null;
        Node temp = middleNode;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    private static boolean compareLL(Node head1, Node head2){
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    private static boolean isPalindrome_optimal(LinkedList linkedList) {
        if (linkedList.head == null || linkedList.head.next == null) {
            return true;
        }
        Node temp = linkedList.head;
        Node mid = middleNode(linkedList);
        Node reversedHead = reverse(mid);
        return compareLL(temp, reversedHead);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);
        list.insert(3, 2);
        list.insert(4, 1);
        System.out.println("Original list : ");
        list.printList();
        System.out.println("list is Palindrome : " + isPalindrome(list));
        System.out.println("List is palindrome ( using optimal approach ) : "+isPalindrome_optimal(list));
        System.out.println();

        list = new LinkedList();
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 1);
        list.insert(3, 1);
        System.out.println("Original list is : ");
        list.printList();
        System.out.println("list is palindrome :" + isPalindrome(list));
        System.out.println("list is palindrome ( using optimal approach ) : "+isPalindrome_optimal(list));
    }
}