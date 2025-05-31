import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

public class AddTwoNumbersInLinkedList {

    private static LinkedList addTwoNumbers(LinkedList list1, LinkedList list2){
        int carry = 0;
        Node temp1 = list1.head;
        Node temp2 = list2.head;
        LinkedList sumList = new LinkedList();
        while (temp1 != null || temp2 != null || carry > 0){
            int num1 = (temp1 != null) ? temp1.data : 0;
            int num2 = (temp2 != null) ? temp2.data : 0;

            int sum = num1+num2+carry;
            int remainder = sum%10;
            carry = sum/10;

            sumList.insert(sumList.getLength(),remainder);

            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }
        return sumList;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        LinkedList ll = new LinkedList();
        l.insert(0,2);
        l.insert(1,4);
        l.insert(2,6);
        ll.insert(0,3);
        ll.insert(1,8);
        ll.insert(2,7);
        LinkedList sum = addTwoNumbers(l,ll);
        sum.printList();

        // test case 2
        LinkedList lll = new LinkedList();
        LinkedList llll = new LinkedList();
        lll.insert(0,17);
        lll.insert(1,20);
        lll.insert(2,25);
        lll.insert(3,15);
        llll.insert(0,17);
        llll.insert(1,290);
        llll.insert(2,32);
        llll.insert(3,16);
        sum = addTwoNumbers(lll,llll);
        sum.printList();

        // test case 2
        LinkedList a = new LinkedList();
        LinkedList b = new LinkedList();
        a.insert(0,17);
        a.insert(1,20);
        b.insert(0,17);
        b.insert(1,290);
        sum = addTwoNumbers(a,b);
        sum.printList();

        // test case 3
        LinkedList c = new LinkedList();
        LinkedList d = new LinkedList();
        c.insert(0,3);
        c.insert(1, 5);
        d.insert(0,4);
        d.insert(1,5);
        d.insert(2,9);
        d.insert(3,9);
        sum = addTwoNumbers(c,d);
        sum.printList();
    }
}
