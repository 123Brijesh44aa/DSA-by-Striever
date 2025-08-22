import java.util.ArrayList;

import linkedlist.leetcode.common.DoublyLinkedList;
import linkedlist.leetcode.common.DoublyNode;

public class FindAllPairsWithGivenSumInDll {

    // Problem Description:
    // Given a sorted doubly linked list and a target sum, find all pairs of nodes
    // in the list whose sum is equal to the given target.
    //
    // Input:
    // - A sorted doubly linked list of integers.
    // - An integer target sum.
    //
    // Output:
    // - Print all pairs of nodes (as values) whose sum equals the target sum.
    // - Each pair should be printed only once. If no such pair exists, print "No
    // pair found".
    //
    // Example:
    // Input: List = 1 <-> 2 <-> 3 <-> 4 <-> 5, Target = 5
    // Output:
    // (1, 4)
    // (2, 3)
    //
    // Explanation:
    // The pairs (1, 4) and (2, 3) sum up to 5.

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static ArrayList<Pair> allPairs(DoublyLinkedList doublyLinkedList, int sum) {
        DoublyNode temp = doublyLinkedList.head;
        ArrayList<Pair> pairs = new ArrayList<>();
        while (temp != null) {
            DoublyNode temp2 = temp.next;
            while (temp2 != null) {
                if ((temp.data + temp2.data) == sum) {
                    Pair pair = new Pair(temp.data, temp2.data);
                    pairs.add(pair);
                }
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        return pairs;
    }

    // Using Two Pointer Approach
    private static ArrayList<Pair> allPairs2(DoublyLinkedList doublyLinkedList, int sum) {
        DoublyNode left = doublyLinkedList.head;
        DoublyNode right = doublyLinkedList.tail;
        ArrayList<Pair> pairs = new ArrayList<>();
        if (left == null || right == null || left == right) {
            return pairs;
        }
        while (left != null && right != null && left.data < right.data) {
            if (left.data + right.data > sum) {
                right = right.prev;
            } else if (left.data + right.data < sum) {
                left = left.next;
            } else {
                Pair pair = new Pair(left.data, right.data);
                pairs.add(pair);
                left = left.next;
                right = right.prev;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);
        list.insert(3, 4);
        list.insert(4, 9);
        int sum = 5;
        ArrayList<Pair> arrayList = allPairs2(list, sum);
        for (Pair pair : arrayList) {
            System.out.println(pair.first + "," + pair.second);
        }
    }
}
