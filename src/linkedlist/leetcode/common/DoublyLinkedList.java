package linkedlist.leetcode.common;


public class DoublyLinkedList {
    public DoublyNode head;
    public DoublyNode tail;
    public int length;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public int getLength(){
        return this.length;
    }

    public void insert(int location, int data){
        if (location < 0){
            System.out.println("Invalid location");
        }
        DoublyNode newNode = new DoublyNode(data);
        if (head == null){
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
            length++;
        } else if (location == 0){ // insert at the beginning
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
            length++;
        } else if (location >= length){ // insert at the beginning
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = null;
            tail = newNode;
            length++;
        } else { // insert at the specific location
            DoublyNode temp = head;
            for (int i=0; i<location-1; i++){
                temp = temp.next;
            }
            newNode.prev = temp;
            newNode.next = temp.next;
            temp.next = newNode;
            newNode.next.prev = newNode;
            length++;
        }
    }

    public void printDLL(){
        DoublyNode temp = head;
        while (temp != null){
            System.out.print(temp.data+" ,");
            temp = temp.next;
        }
        System.out.println();
    }
}
