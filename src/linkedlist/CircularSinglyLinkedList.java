package linkedlist;

import linkedlist.singlyNode.Node;

public class CircularSinglyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public int getLength() {
        return length;
    }

    CircularSinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    void insert(int location, int data){
        Node newNode = new Node(data);
        if (location < 0){
            System.out.println("can't insert, Invalid location");
        }
        else if(head == null && tail == null){
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            length++;
        } else if (location == 0) {
            newNode.next = head;
            head = newNode;
            tail.next = head;
            length++;
        } else if (location >= length){
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
            length++;
        } else {
            Node current = head;
            for (int i=0; i<location-1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            length++;
        }
    }

    void delete(int location){
        if (head == null){
            System.out.println("can't delete, no element in CSLL");
        } else if (location < 0 || location >= length){
            System.out.println("Invalid location parameter");
        } else if (location == 0) {
            // if we're deleting from the beginning, we can have 2 cases:
            // (1). there is only one element, (2). more than one element.
            if (head == tail) {
                head = tail = null;
                length = 0;
            } else {
                head = head.next;
                tail.next = head;
                length--;
            }
        } else if (location == length-1){
            Node current = head;
            for (int i=0; i<length-2; i++){
                current = current.next;
            }
            // if we're deleting from the end, here also we can have 2 cases:
            // (1). there is only one element, (2). more than one element.
            if (current == head){
                tail = null;
                head.next = null;
                head = null;
                length--;
            }
            else {
                current.next = head;
                tail = current;
                length--;
            }
        } else {
            Node current = head;
            for (int i=0; i<location-1; i++){
                current = current.next;
            }
            current.next = current.next.next;
            length--;
        }
    }

    void deleteEntireCSLL(){
        if (head == null){
            System.out.println("CSLL is empty");
        }
        else {
            head = null;
            tail.next = null;
            tail = null;
            length = 0;
        }
    }

    void printCSLL(){
        if (head == null || length == 0){
            System.out.println("CSLL does not have any element");
        } else {
            Node temp = head;
            for (int i = 0; i < length; i++) {
                System.out.print(temp.data);
                if (i != length - 1) System.out.print(" -> ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.insert(0,10);
        list.insert(0,20);
        list.insert(list.getLength(),30);
        list.insert(1,40);
        list.insert(4,50);
        list.insert(3,60);
        list.printCSLL();
        System.out.println("Length of CSLL is : "+list.getLength());
        list.delete(1);
        list.delete(list.getLength());
        list.delete(0);
        list.delete(list.getLength()-1);
        list.insert(4,44);
        list.insert(2,22);
        list.delete(list.getLength()-1);
        list.printCSLL();
        System.out.println("Length of CSLL after deleting element is : "+list.getLength());
        list.deleteEntireCSLL();
        list.printCSLL();
        System.out.println(list.getLength());
    }
}