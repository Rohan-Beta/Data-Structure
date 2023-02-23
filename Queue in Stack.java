// queue in stack

// enqueue
// pop
// peek
// print
// size

class QueueStack {
    Node head;
    int size;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }
    // enqueue

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;

        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    // pop

    public void pop() {
        if(head == null) {
            return;
        }
        size--;

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
    // print

    public void print() {
        if(head == null) {
            System.out.print("Empty queue");
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
        QueueStack qs = new QueueStack();

        qs.enqueue(1);
        qs.enqueue(2);
        qs.enqueue(3);
        qs.enqueue(4);
        qs.print();

        System.out.println(qs.getSize());

        qs.pop();
        qs.print();

        qs.peek();
        qs.print();

        System.out.println(qs.getSize());
    }
}
