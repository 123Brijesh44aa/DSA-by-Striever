package linkedlist;

import linkedlist.doublyNode.Node;

public class CircularDoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public int getLength(){
        return this.length;
    }

    public CircularDoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    void insert(int location , int data){
        if (location < 0){
            System.out.println("Invalid Location Parameter");
        }
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
            length++;
        } else if (location == 0){ // insert at the beginning
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
            length++;
        } else if (location >= length){ // insert at the end
            tail.next = newNode;
            head.prev = newNode;
            newNode.prev = tail;
            newNode.next = head;
            tail = newNode;
            length++;
        } else {  // insert at a specific location
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
            System.out.println("Can't Delete, No element in CDLL");
        } else if (location == 0){ // delete at the beginning
            // 2 cases: 1. one element in CDLL, 2. more than one element in CDLL
            if (length == 1){
                head.prev = null;
                head.next = null;
                head = tail = null;
                length--;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
                length--;
            }
        } else if (location >= length){ // delete at the end
            // 2 cases: 1. one element in CDLL, 2. more than one element in CDLL
            if (length == 1){
                head.prev = null;
                head.next = null;
                head = tail = null;
                length--;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
                length--;
            }
        } else { // deleting at a specific location
            Node temp = head;
            for (int i=0; i<location-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
            length--;
        }
    }

    // delete entire CDLL
    void deleteCDLL(){
        Node temp = head;
        for (int i=0; i<length; i++){
            temp.prev = null;
            temp = temp.next;
        }
        head = null;
        tail = null;
        length = 0;
        System.out.println("The CDLL has been deleted!");
    }

    // traversal - CDLL
    void printCDLL(){
        if (head != null){
            Node temp = head;
            for (int i=0; i<length; i++){
                System.out.print(temp.data);
                if (i != length-1){
                    System.out.print(" -> ");
                }
                temp = temp.next;
            }
        } else {
            System.out.println("The CDLL does not exit");
        }
        System.out.println();
    }

    // traverse reverse - CDLL
    void printReverse(){
        if (head != null){
            Node temp = tail;
            for (int i=0; i<length; i++){
                System.out.print(temp.data);
                if (i != length-1){
                    System.out.print(" -> ");
                }
                temp = temp.prev;
            }
            System.out.println();
        } else {
            System.out.println("The CDLL does not exist!");
        }
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insert(0,10);
        list.insert(3,30);
        list.insert(1,20);
        list.insert(list.getLength()-1,40);

        list.printCDLL();
        System.out.print("Reverse printing : "); list.printReverse();
        System.out.println("The length of CDLL is :"+list.getLength());
        System.out.println();

        list.delete(0);
        list.delete(list.getLength());

//        list.deleteCDLL();

        System.out.println("After Deletion :");
        list.printCDLL();
        System.out.println("The length of CDLL is :"+list.getLength());
    }
}
