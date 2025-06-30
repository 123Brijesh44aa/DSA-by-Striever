package linkedlist.leetcode.common;

public class LinkedList {
    public Node head;
    public Node tail;
    public int length;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public int getLength(){
        return this.length;
    }

    public void insert(int location, int data){
        if (location < 0){
            System.out.println("Invalid Location Parameter");
        }
        Node newNode = new Node(data);
        if (head == null){
            newNode.next = null;
            head = newNode;
            tail = newNode;
            length++;
        }
        else if (location == 0){
            newNode.next = head;
            head = newNode;
            length++;
        } else if (location >= length){
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
            length++;
        } else {
            Node temp = head;
            for (int i=0; i<location-1; i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }
    }

    public void printList(){
        if (head == null){
            System.out.println("LL is empty");
        } else {
            Node temp = head;
            for (int i=0; i<length; i++){
                System.out.print(temp.data);
                if (i != length-1){
                    System.out.print(" -> ");
                }
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
