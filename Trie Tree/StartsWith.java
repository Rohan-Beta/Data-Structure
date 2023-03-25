// trie 
// starts with

import java.util.*;

class Trie {
    
    class Node {
        Node children[];
        boolean eow;

        Node() {
            children = new Node[26];

            for(int i = 0; i < 26; i += 1) {
                children[i] = null;
            }
            eow = false;
        }
    }
    Node root = new Node();

    // insert

    public void insert(String word) {

        Node curr = root;

        for(int i = 0; i < word.length(); i += 1) {
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            if(i == word.length()-1) {
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }
    //  starts with

    public boolean startsWith(String key) {

        Node curr = root;

        for(int i = 0; i < key.length(); i += 1) {
            int idx = key.charAt(i) - 'a'; // gives index value

            if(curr.children[idx] == null) { // children node not exist
                return false;
            }
            curr = curr.children[idx]; // update root
        }
        return true;
    }
}
class Firstclass {
    public static void main(String args[]) {

        Trie t = new Trie();

        String words[] = {"apple" , "app" , "mango" , "man" , "woman"};

        for(int i = 0; i < words.length; i += 1) {
            t.insert(words[i]);
        }
        System.out.println(t.startsWith("app"));
        System.out.println(t.startsWith("moon"));
    }
}
