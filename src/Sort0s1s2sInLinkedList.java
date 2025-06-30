import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

public class Sort0s1s2sInLinkedList {

    private static LinkedList sort012(LinkedList linkedList){

        if (linkedList.head == null || linkedList.head.next == null) {
            return linkedList;
        }

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;

        Node temp = linkedList.head;

        while(temp != null){
            if (temp.data == 0) {
                zero.next = temp;
                zero = temp;    
            }
            else if (temp.data == 1) {
                one.next = temp;
                one = temp; 
            }
            else {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }

        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        linkedList.head = zeroHead.next;

        return linkedList;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(0, 1);
        list.insert(1, 0);
        list.insert(2, 2);
        list.insert(3, 0);
        list.insert(4, 1);
        list.insert(5, 0);
        list.insert(6, 2);
        System.out.println("original list : ");
        list.printList();
        list = sort012(list);
        System.out.println("sorted list : ");
        list.printList();
    }
}
