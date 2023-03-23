// Trie tree
// word break

// insert
// search

class Trie {

    class Node {
        Node children[];
        boolean eow; // eow = end of word

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
            int idx = word.charAt(i) - 'a'; // gives index value of word

            if(curr.children[idx] == null) { // if child is empty
                curr.children[idx] = new Node(); // add new node
            }
            if(i == word.length()-1) {
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx]; // update root
        }
    }
    // search

    public boolean search(String key) {

        Node curr = root;

        for(int i = 0; i < key.length(); i += 1) {
            int idx = key.charAt(i) - 'a';

            if(curr.children[idx] == null) {
                return false;
            }
            if(i == key.length()-1 && curr.children[idx].eow == false) {
                return false;
            }
            curr = curr.children[idx]; // update root
        }
        return true;
    }
    // word break

    public boolean wordBreak(String key){

        if(key.length() == 0) {
            return true;
        }
        for(int i = 1; i <= key.length(); i += 1) {
            
            String firstcPart = key.substring(0 , i);
            String secondPart = key.substring(i);

            if(search(firstcPart) && wordBreak(secondPart)) {
                return true;
            }
        }
        return false;
    }
}
class Firstclass {
    public static void main(String args[]) {

        Trie t = new Trie();

        String word[] = {"i" , "like" , "sam" , "samsung" , "mobile"};
        String key = "ilikesamsung";

        for(int i = 0; i < word.length; i += 1) {
            t.insert(word[i]);
        }
        System.out.println(t.wordBreak(key));
    }
}
