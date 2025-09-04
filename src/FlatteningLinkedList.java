
public class FlatteningLinkedList {

    // problem description :
    // Given a linked list containing n head nodes where every node in the linked
    // list contains two pointers:

    // next points to the next node in the list.
    // child pointer to a sub-linked list where the current node is the head. Each
    // of the sub-linked lists nodes and the head

    // nodes are sorted in ascending order based on their data .We need to flatten
    // the linked list so that all the nodes appear in a single level while
    // maintaining the sorted order.

    // Example :

    // 5 -> 10 -> 19 -> 28
    // | | | |
    // 7 20 22 35
    // | | |
    // 8 50 40
    // | |
    // 30 45

    // Ouput :
    // 5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 30 -> 35 -> 40 -> 45 -> 50

    // BRUTE FORCE APPROACH :
    // step 1. first store all the elements of linked list into array
    // step 2. sort the array
    // step 3. convert sorted array into linked list
    // step 4. return the head of newly created linked list

    // OPTIMAL APPROACH :
    // take 2 linked list -> they will be act like (merge 2 sorted linked list
    // problem)
    // merge these 2 linked list in sorted order (vertical linked list)
    // and then use this merge function on n linked list using recursion to merge
    // all the linked list into one with sorted order

    static class Node {
        int data;
        Node next;
        Node child;

        Node(int x) {
            data = x;
            next = null;
            child = null;
        }
    }

    private static Node merge2List(Node list1, Node list2) {
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
        }

        if (list1 != null) {
            res.child = list1;
        } else {
            res.child = list2;
        }

        res.next = null;

        return dummyNode.child;
    }

    private static Node flattenList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mergedHead = flattenList(head.next);
        return merge2List(head, mergedHead);
    }

    public static void main(String[] args) {

    }
}