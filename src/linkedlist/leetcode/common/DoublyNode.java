package linkedlist.leetcode.common;

public class DoublyNode {
    public int data;
    public DoublyNode next;
    public DoublyNode prev;

    public DoublyNode(){}

    public DoublyNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
