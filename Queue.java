// queue
// it follows fifo(First In First Out)

// enqueue
// dequeue
// print

class Queueq {
    Node head;
    int size;

    class Node {
        int data;
        Node next;

        Node(int data ) {
            this.data = data;
            this.next =  null;
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
    // dequeue

    public void dequeue() {
        if(head == null) {
            return;
        }
        size--;

        head = head.next;
    }
    // print queue
    
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
    // getsize
    
    public int getSize() {
        return size;
    }
}
class Firstclass {
    public static void main(String args[]) {
        Queueq q = new Queueq();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.print();

        q.dequeue();
        q.print();

        System.out.println(q.getSize());
    }
}
