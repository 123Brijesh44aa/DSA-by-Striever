package linkedlist;

import linkedlist.doublyNode.Node;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public int getLength(){
        return this.length;
    }

    void insert(int location, int data){
        if (location < 0){
            System.out.println("Invalid location");
        }
        Node newNode = new Node(data);
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
            Node temp = head;
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

    void delete(int location){
        if (location < 0){
            System.out.println("Invalid Location Parameter");
        }
        if (head == null){
            System.out.println("Can't Delete, List is empty");
        } else if (location == 0){ // delete at the beginning
            // 2 cases: 1. one element in DLL, 2.more than one element in DLL
            if (length == 1){
                head = null;
                tail = null;
                length--;
            } else {
                head = head.next;
                head.prev = null;
                length--;
            }
        } else if (location >= length){ // delete at the end
            // 2 cases: 1. one element in DLL, 2.more than one element in DLL
            if (length == 1){
                head = null;
                tail = null;
                length--;
            } else {
                Node temp = tail.prev;
                temp.next = null;
                tail = temp;
                length--;
            }
        } else { // deleting at the specific location
            Node temp = head;
            for (int i=0; i<location-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
            length--;
        }
    }

    void printReverse(){
        Node temp = tail;
        while (temp != null){
            System.out.print(temp.data+" ,");
            temp = temp.prev;
        }
        System.out.println();
    }

    void printDLL(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+" ,");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(0,10);
        list.insert(1,20);
        list.insert(2,30);
        list.insert(3,40);
        list.insert(0,100);
        list.insert(9,1);
        list.insert(2,111);
        list.printDLL();
        System.out.println("Length of Doubly linked list is : "+list.getLength());
        list.delete(list.getLength());
        list.delete(0);
        list.delete(2);
        System.out.println("After Deletion");
        list.printDLL();
        System.out.println("Length of Doubly linked list is : "+list.getLength());
//        System.out.print("Reverse Printing : ");
//        list.printReverse();
    }
}
