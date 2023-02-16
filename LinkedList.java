// Linked List (from scratch)

// add head
// add tail
// add element in middle
// delete head
// delete tail
// delete element from middle
// reverse the list
// search element in list
// print the list
// get the list size

import java.util.*;

class LinkList {

    Node head; //head of the node
    private int size; //size of list

    class Node {
        int data; //input type from user
        Node next; //track each node

        // create a constructor
        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }
    // add head
    public void addHead(int data) {
        Node newNode = new Node(data); //create a new node

        // check if head is null or not
        
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    // add tail
    public void addTail(int data) {
        Node newNode = new Node(data);

        // check if head is null or not

        if(head == null) {
            head = newNode;
            return;
        }
        // get the current node from list
        Node currNode = head;

        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    // add middle
    public void addMiddle(int idx , int data) { // idx is indicate the index number

        // check the index value

        if(idx > size || idx < 0) {
            System.out.print("Invalid Index");
            return;
        }
        Node newNode = new Node(data);

        // check if head is null or not

        if(head == null || idx == 0) {
            
            newNode.next = head;
            head = newNode;
            return;
        }
        Node currNode = head;

        // traverse in list

        for(int i = 1; i < size; i += 1) {
            // if index value found in list
            if(i == idx) {

                Node nextNode = currNode.next;
                currNode.next = newNode;
                newNode.next = nextNode;

                break;
            }
            currNode = currNode.next;
        }
    }
    // delete head
    public void deleteHead() {

        // check if head is null or not
        if(head == null) {
            return;
        }
        // if we delete node from head size will be reduce
        size--;

        // after delete head will be head next value
        head = head.next;
    }
    // delete tail
    public void deleteTail() {

        // check if head is null or not
        if(head == null) {
            return;
        }
        // if we delete node from tail size will be reduce
        size--;

        // check if head next value is also null or not
        if(head.next == null) {
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;

        while(lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }
    // delete middle
    public void deleteMiddle(int idx) {

        // check if head is null or not
        if(head == null) {
            return;
        }
        // if we delete node from middle size will be reduce
        size--;

        Node currNode = head;

        // traverse in list and also check the current node
        for(int i = 1; currNode.next != null && i < idx-1; i += 1){
            currNode = currNode.next;
        }
        // check the index is valid or not
        if(currNode == null || currNode.next == null){
            return;
        }

        Node nextNode = currNode.next.next;
        currNode.next = nextNode;
    }
    // reverse list
    public void reverseList() {

        // check if head is null or not
        if(head == null || head.next == null) {
            return;
        }
        // prevNode is previous node
        Node prevNode = head;
        Node currNode = head.next;

        while(currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            // update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }
    // search element
    public void search(int idx) {

        Node currNode = head;
        int i = 1; // track the index
        // at first we assume that the index is not present, so flag is false
        boolean flag = false; //helps us to find out whether the element is present inside the list or not

        while(currNode != null) {

            // if element is found
            if(currNode.data == idx) {
                
                flag = true;
                break;
            }
            i++; //update
            currNode = currNode.next;
        }
        if(flag) {
            System.out.print(idx + " found at index " + i + "\n");
        }
        else {
            System.out.print(idx + " not found\n");
        }
    }
    // print list
    public void printList() {

        // check if head is null ot not 
        if(head == null) {
            System.out.print("Empty List");
            return;
        }
        Node currNode = head;

        while(currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.print("\n");
    }
    // get size
    public int getSize() {
        return size;
    }
}
class Firstclass {
    public static void main(String args[]) {
        
        LinkList list = new LinkList();

        list.addHead(1);
        list.addHead(0);
        list.printList();

        list.addTail(2);
        list.addTail(3);
        list.printList();

        list.addMiddle(2, 10);
        list.printList();

        System.out.println(list.getSize());

        list.search(3);

        list.deleteHead();
        list.printList();

        list.deleteTail();
        list.printList();

        list.reverseList();
        list.printList();

        list.deleteMiddle(2);
        list.printList();

        System.out.println(list.getSize());
    }
}
