// Binary Tree (from scratch)

// preorder Traversal(root comes first)
// inorder Traversal(root comes middle)
// postorder Traversal(root comes last)
// lebelorder Traversal(print nodes in lebel)
// count nodes
// sum of nodes
// tree diameter (tree size - root value)

import java.util.*;

class BinaryTree {
    private int count; // get total nodes
    private int idx = -1; //idx means index and index = -1 refers that the root nodes have no child nodes
    Node root;

    class Node {
        int data; //input type of nodes
        Node left; // track left node
        Node right; //track right node

        // create a constructor
        
        Node(int data) {

            this.data = data;
            this.left = left;
            this.right = right;
            count++;
        }
    }
    // build tree
    public Node buildTree(int nodes[]) {
        idx++; //track the indexes

        // check nodes index
        if(nodes[idx] == -1) {
            return null;
        }
        // create a new node
        Node newNode = new Node(nodes[idx]);

        // assign value in left and right node
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }
    // preorder
    public void preorder(Node root) {
        
        if(root == null) {
            return;
        }
        // at first print root then print nodes left to right
        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);

    }
    // inorder
    public void inorder(Node root) {
        
        if(root == null) {
            return;
        }
        // print left nodes then print root and then right node
        inorder(root.left);
        
        System.out.print(root.data + " ");
        
        inorder(root.right);
    }
    // postorder
    public void postorder(Node root) {
        
        if(root == null) {
            return;
        }
        // print nodes left to right and atlast print root
        postorder(root.left);
        postorder(root.right);

        System.out.print(root.data + " ");
    }
    // lebelorder
    public void lebelorder(Node root) {
        
        if(root == null) {
            return;
        }
        // create a LinkedList inbuilt java class
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node currNode = q.remove();

            if(currNode == null) {
                System.out.print("\n");

                if(q.isEmpty()) {
                    break;
                }
                else {
                    q.add(null);
                }
            }
            else {
                System.out.print(currNode.data + " ");

                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }
    // get total nodes
    public int getCount() {
        return count;
    }
    public int sumofNodes(Node root) {

        if(root == null) {
            return 0;
        }
        int leftSum = sumofNodes(root.left);
        int rightSum = sumofNodes(root.right);

        return leftSum + rightSum + root.data;
    }
}
class Firstclass {
    public static void main(String args[]) {

        BinaryTree tree = new BinaryTree();

        int nodes[] = {1 , 2 , 4 , -1 , -1 , 5 , -1 , -1 , 3 , -1 , 6 , -1 , -1};
        
        tree.root = tree.buildTree(nodes);
        System.out.println(tree.root.data); //root value

        tree.preorder(tree.root);
        System.out.print("\n");

        tree.inorder(tree.root);
        System.out.print("\n");

        tree.postorder(tree.root);
        System.out.print("\n");

        tree.lebelorder(tree.root);
        System.out.print("\n");

        System.out.print(tree.getCount());
        System.out.print("\n");

        System.out.print(tree.getCount() - 1); //diameter
        System.out.print("\n");

        System.out.print(tree.sumofNodes(tree.root));
    }
}
