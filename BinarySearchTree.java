// Binary Search Tree

// time complexity for all is O(n)
// build tree
// inorder
// search key
// delete key
// inorder successor
// print range

import java.util.*;

class BinarySearchTree {

    Node root;
    int size;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            size++;
        }
    } 
    // whenever root value is smaller than key value we search node in left subtree of the tree
    // whenever root value is greater than key value we search node in right subtree of the tree

    // build tree
    public Node buildTree(Node root , int key) {

        if(root == null) {
            root = new Node(key);
            return root;
        }
        if(root.data > key) {
            root.left = buildTree(root.left, key);
        }
        else { // root.data < key
            root.right = buildTree(root.right, key);
        }
        return root;
    }

    // inorder
    public void inorder(Node root) {

        if(root == null) {
            return;
        }
        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    // search key
    public boolean searchKey(Node root , int key) {

        if(root == null) {
            return false;
        }
        if(root.data > key) {
            return searchKey(root.left, key);
        }
        else if(root.data == key) {
            return true;
        }
        else {
            return searchKey(root.right, key);
        }
    }

    // delete key
    public Node deleteKey(Node root , int key) {

        if(root == null) {
            return null;
        }
        if(root.data > key){
            root.left = deleteKey(root.left, key);
        }
        else if(root.data < key) {
            root.right = deleteKey(root.right, key);
            size--;
        }
        else { // root.data == key

            // case 1:
            // no child

            if(root.left == null && root.right == null) {
                return null;
            }

            // case 2:
            // one child

            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            // case 3:
            // two child

            Node is = inorderSuccessor(root.right);
            root.data = is.data;
            root.right = deleteKey(root.right, is.data);
        }
        return root;
    }
  
    // helps to find the left most node in right subtree
    // inorder successor
    public Node inorderSuccessor(Node root) {

        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    public int getSize() {
        return size;
    }
    
    // print range
    public void printRange(Node root , int x , int y) {

        if(root == null) {
            return;
        }
        if(root.data >= x && root.data <= y) {
            printRange(root.left, x, y);

            System.out.print(root.data + " ");

            printRange(root.right, x, y);
        }
        else if(root.data >= y) {
            printRange(root.left, x, y);
        }
        else { // root.data <= x
            printRange(root.right, x, y);
        }
    }
}
class Firstclass {
    public static void main(String args[]) {

        BinarySearchTree tree = new BinarySearchTree();

        int nodes[] = {8 , 5 , 3 , 1 , 4 , 6 , 10 , 12 , 14};

        tree.root = null;

        for(int i = 0; i < nodes.length; i += 1) {
            tree.root = tree.buildTree(tree.root, nodes[i]);
        }
        tree.inorder(tree.root);

        System.out.print("\n");

        if(tree.searchKey(tree.root, 1)) {
            System.out.print("Found");
        }
        else {
            System.out.print("Not Found");
        }

        System.out.print("\n");

        tree.deleteKey(tree.root, 4);
        tree.inorder(tree.root);

        System.out.print("\n");

        tree.printRange(tree.root, 6, 10);
    }
}
