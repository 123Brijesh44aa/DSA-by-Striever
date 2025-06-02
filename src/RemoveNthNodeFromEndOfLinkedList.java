import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

public class RemoveNthNodeFromEndOfLinkedList {

    private static LinkedList removeNthNodeFromLast(LinkedList linkedList, int n){
        if (linkedList.head == null) {
            return linkedList;
        }
        // if (n < 0) {
            
        // }
        Node temp = linkedList.head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int location = length - n;
        if (location == 0) {
            // 2. cases : 1.only one node present , 2. more than one node
            if (length == 1) {
                linkedList.head = null;
                linkedList.length--;
                return linkedList;
            } else{
                linkedList.head = linkedList.head.next;
                linkedList.length--;
                return linkedList;
            }
        }
        else if (location == length) {
            // 2. cases : 1.only one node present, 2. more than one node
            if (length == 1) {
                linkedList.head = linkedList.head.next;
                linkedList.length--;
                return linkedList;
            } else{
                Node prev = linkedList.head;
                for(int i=0; i<length-2; i++){
                    prev = prev.next;
                }
                prev.next = null;
                linkedList.tail = prev;
                linkedList.length--;
                return linkedList;
            }
        }
        else {
            Node temp2 = linkedList.head;
            while (location > 0) {
                location--;
                temp2 = temp2.next;
            }
            temp2.next = temp2.next.next;
            linkedList.length--;
            return linkedList;
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);
        list.insert(3, 4);
        list.insert(4, 5);
        System.out.println("original list ");
        list.printList();
        list = removeNthNodeFromLast(list, 0);
        list = removeNthNodeFromLast(list, list.getLength());
        list = removeNthNodeFromLast(list, 2);
        System.out.println("list after removing nth node from last");
        list.printList();
    }
}
