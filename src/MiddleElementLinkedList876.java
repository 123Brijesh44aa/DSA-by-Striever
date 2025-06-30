import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

public class MiddleElementLinkedList876 {

    // Approach 1
    private static Node middleNode(LinkedList list){
        Node temp = list.head;
        int size = 0;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        temp = list.head;
        int mid = size/2+1;
        while (mid != 0){
            mid--;
            if (mid == 0){
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    // very optimal approach
    // using slow and fast pointer
    private static Node middleNode_optimal(LinkedList list){
        Node slow = list.head;
        Node fast = list.head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.insert(0,1);
        l.insert(1,2);
        l.insert(2,3);
        l.insert(3,4);
        l.insert(4,5);
        System.out.println("middle node of linked list is : "+middleNode(l).data);
        LinkedList ll = new LinkedList();
        ll.insert(0,1);
        ll.insert(1,2);
        ll.insert(2,3);
        ll.insert(3,4);
        ll.insert(4,5);
        ll.insert(5,6);
        System.out.println("middle node of linked list is : "+middleNode(ll).data);

        System.out.println("\nOPTIMAL APPROACH\n");
        System.out.println("middle node of linked list is : "+middleNode_optimal(l).data);
        System.out.println("middle node of linked list is : "+middleNode_optimal(ll).data);

    }
}
