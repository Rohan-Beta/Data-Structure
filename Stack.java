// stack
// it follows lifo(Last In Fast Out)

// push
// pop
// peek
// reverse
// print stack

class Stack {
    Node head;
    int size;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // push

    public void push(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    // pop

    public void pop() {
        if(head == null) {
            return;
        }
        int top = head.data;
        head = head.next;

        System.out.print(top + "\n");
    }
    // peek

    public void peek() {
        if(head == null) {
            return;
        }
        int top = head.data;

        System.out.print(top + "\n");
    }
    // print stack

    public void print() {
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
    // reverse

    public void reverse() {
        if(head == null || head.next == null) {
            return;
        }
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
}
class Firstclass {
    public static void main(String args[]) {
        Stack s = new Stack();

        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        s.push(0);
        s.print();

        s.pop();
        s.print();

        s.peek();
        s.print();

        s.reverse();
        s.print();
    }
}
