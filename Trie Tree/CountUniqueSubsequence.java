// trie 
// count unique substring

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
    // count unique substring

    public int countNode(Node root) {

        if(root == null) {
            return 0;
        }
        int count = 0;

        for(int i = 0; i < 26; i += 1) {
            if(root.children[i] != null) {
                count += countNode(root.children[i]);
            }
        }
        return count+1;
    }
}
class Firstclass {
    public static void main(String args[]) {

        Trie t = new Trie();

        String words = "ababa";

        for(int i = 0; i < words.length(); i += 1) {
            String suffix = words.substring(i); // get unique substring
            System.out.println(suffix); // print all unique substring

            t.insert(suffix); // insert only suffix value in Trie
        }
        System.out.println(t.countNode(t.root));
    }
}
