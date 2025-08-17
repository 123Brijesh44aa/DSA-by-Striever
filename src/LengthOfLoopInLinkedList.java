import java.util.HashMap;

import linkedlist.leetcode.common.LinkedList;
import linkedlist.leetcode.common.Node;

public class LengthOfLoopInLinkedList {

    // APPROACH 1 : USING HASHMAP
    private static int cycleLength(LinkedList linkedList) {
        Node temp = linkedList.head;
        HashMap<Node, Integer> map = new HashMap<>();
        int timer = 1;
        while (temp != null) {
            if (map.containsKey(temp)) {
                int value = map.get(temp);
                return (timer - value);
            }
            map.put(temp, timer);
            timer++;
            temp = temp.next;
        }
        return 0;
    }

    // APPROACH 2 : SLOW AND FAST POINTER
    private static int cycleLength_slowFast(LinkedList linkedList) {
        Node slow = linkedList.head;
        Node fast = linkedList.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // cycle detected now calculate the length
                return lengthOfCycle(slow, fast);
            }
        }
        return 0;
    }

    private static int lengthOfCycle(Node slow, Node fast) {
        int count = 1;
        fast = fast.next;
        while (slow != fast) {
            count++;
            fast = fast.next;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
