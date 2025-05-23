package linkedlist;


class Node {
    int data;
    Node next;

    public Node(){
        this.next = null;
    }

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

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
        if (tail == null){
            head = tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    void insertAt(int location, int data){
        Node newNode = new Node(data);
        if (location < 1){
            try {
                throw new Exception("can not insert, please enter a valid location");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (location > length+1){
            throw new IndexOutOfBoundsException();
        }
        if (location == 1){
            insertAtBeginning(data);
            return;
        }
        if (location == length){
            insertAtEnd(data);
            return;
        }
        Node prev = null;
        Node current = head;
        for (int i=1; i<location; i++){
            prev = current;
            current = current.next;
        }
        prev.next = newNode;
        newNode.next = current;

        length++;
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
        int location = 1;
        int data = 99;
        list.insertAt(location,data);
//        list.insertAt(9,111);
        list.printLL();
        System.out.println("Linked list  length is : "+list.getLength());

    }
}
