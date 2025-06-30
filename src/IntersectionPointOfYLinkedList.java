import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

import java.util.HashMap;
import java.util.Map;

public class IntersectionPointOfYLinkedList {

    // Approach 1
    // Using HashMap
    private static Node interSectionPointOfYLinkedList(LinkedList list1, LinkedList list2){
        Map<Node, Integer> map = new HashMap<>();
        Node temp = list1.head;
        while (temp != null){
            map.put(temp, 1);
            temp = temp.next;
        }

        temp = list2.head;
        while (temp != null){
            if (map.containsKey(temp)){
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    // Approach 2
    // Slow pointer , fast pointer
    private static Node intersectionPointOfYLinkedList_2(LinkedList list1, LinkedList list2){
        int length1 = 0;
        int length2 = 0;
        Node temp = list1.head;
        while (temp != null){
            length1++;
            temp = temp.next;
        }
        temp = list2.head;
        while (temp != null){
            length2++;
            temp = temp.next;
        }

        if (length1 < length2){
            int d = length2 - length1;
            return collisionPoint(list1,list2,d);
        } else {
            int d = length1 - length2;
            return collisionPoint(list2,list1, d);
        }
    }

    private static Node collisionPoint(LinkedList small, LinkedList big, int d) {
        Node temp1 = small.head;
        Node temp2 = big.head;
        while (d != 0){
            d--;
            temp2 = temp2.next;
        }
        while (temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }

    // Approach 3
    // 2 pointers approach
    private static Node intersectionPointOfYLinkedList_3(LinkedList list1, LinkedList list2){
        if (list1.head == null || list2.head == null){
            return null;
        }
       Node t1 = list1.head;
       Node t2 = list2.head;
       while (t1 != t2){
           t1 = t1.next;
           t2 = t2.next;
           if (t1 == t2){
               return t1;
           }
           if (t1 == null) {
               t1 = list2.head;
           }
           if (t2 == null){
               t2 = list1.head;
           }
       }
       return t1;
    }

    public static void main(String[] args) {

    }
}
