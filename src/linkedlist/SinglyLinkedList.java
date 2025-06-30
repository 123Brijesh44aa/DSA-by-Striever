package linkedlist;


import linkedlist.singlyNode.Node;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int length;         // if length = 0 ->, there is no element in the linked list

    // getter to access head,tail and length


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public SinglyLinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    // Inserting Node at beginning, end, and middle
    void insertAtBeginning(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }
    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
        }else {
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    void insertAt(int location, int data){
        Node newNode = new Node(data);
        if (location < 0){
            try {
                throw new IndexOutOfBoundsException("Cannot insert, please enter a valid location between 1 and " + (length));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        else if (location == 0){
            insertAtBeginning(data);
        }
        else if (location >= length){
            insertAtEnd(data);
        }
        else {
            Node current = head;
            for (int i = 0; i < location - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            length++;
        }
    }

    // Deleting Node at the beginning, end, and middle
    void deleteAtBeginning(){
        if (head == null){
            System.out.println("Can't delete node, Linked list is empty");
        }else {
            head = head.next;
            length--;
            if (length == 0){
                tail = null;
            }
        }

    }
    void deleteAtEnd(){
        if (head == null){ // case:empty list
            System.out.println("Can't delete node, Linked list is empty");
        }
        else if (head == tail){ // case:single node list
            head = null;
            tail = null;
            length--;
        }
        else { // case: multi-node list
            Node prev = head;
            for (int i=0; i<length-2; i++){ // find the second last node
                prev = prev.next;
            }
            prev.next = null; // Remove the last node
            tail = prev; // update tail reference
            length--;
        }
    }
    void deleteAt(int location){
        if (location < 0){
            try {
                throw new IndexOutOfBoundsException("Cannot insert, please enter a valid location between 1 and " + (length));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else if (location == 0){
            deleteAtBeginning();
        }
        else if (location >= length){
            deleteAtEnd();
        }
        else {
            Node prev = head;
            for (int i = 0; i < location - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
            length--;
        }
    }

    // Delete Entire Singly Linked list
    void deleteEntireLL(){
        head = null;
        tail = null;
        length = 0;
    }

    void printLL(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+", ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtBeginning(30);
        list.insertAtBeginning(40);
        list.insertAtBeginning(50);
        list.insertAtEnd(100);
        list.insertAtEnd(200);
        int location = 0;
        int data = 99;
        list.insertAt(location,data);
        list.insertAt(8,111);
        list.insertAt(9,444);
        list.printLL();
        System.out.println("Linked list  length is : "+list.getLength());
        System.out.println("\nAfter Deletion\n");
        list.deleteAtBeginning();
        list.deleteAtEnd();
        list.deleteAt(4);
        list.printLL();
        list.deleteEntireLL();
        System.out.println("Linked list  length is : "+list.getLength());
        list.printLL();




    }
}
