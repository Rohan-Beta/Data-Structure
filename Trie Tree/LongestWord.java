// trie 
// longest word with all prefix

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
    // longest word

    public String ans = "";

    public void longestWord(Node root , StringBuilder temp) {

        if(root == null) {
            return;
        }

        // traverse in Trie
        for(int i = 0; i < 26; i += 1) {

            if(root.children[i] != null && root.children[i].eow == true) {
                temp.append((char)(i +'a')); // update

                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);

                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}
class Firstclass {
    public static void main(String args[]) {

        Trie t = new Trie();

        String words[] = {"a" , "banana" , "app" , "appl" , "ap" , "apply" , "apple"};

        for(int i = 0; i < words.length; i += 1) {
            t.insert(words[i]);
        }
        StringBuilder temp = new StringBuilder();

        t.longestWord(t.root, temp);
        System.out.println(t.ans);
    }
}
