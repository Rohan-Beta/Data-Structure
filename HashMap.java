// HashMap (from scratch)
// time complexity for all is O(1)

// Implementation of HashMap in array Using Linked List

// formula:
// lamda = n/N , n = number of nodes in Linked List , N = number of indexes in array

// condition
// lamda <= k , k is a constant value which is given in question

// put()
// get()
// containsKey()
// remove()
// size()
// keySet()

import java.util.*;

class Firstclass {

    static class HashMapH<K , V> { // generics , means type is not defined

        private int k = 2;

        class Node {
            K key;
            V value;

            Node(K key , V value) {
                this.key = key;
                this.value = value;
            }
        }
        private int n; // number of nodes
        private int N; // number of indexes

        private LinkedList<Node> buckets[]; // store all nodes

        @SuppressWarnings("unchecked") // ignore warning

        HashMapH() {
            this.N = 4;
            this.buckets = new LinkedList[4];

            for(int i = 0; i < 4; i += 1) {
                this.buckets[i] = new LinkedList<>();
            }
        }
        // bucket index

        public int hashFunction(K key) { // 0 to N-1

            int bi = key.hashCode();

            return Math.abs(bi) % N; // Math.abs() give mode of any value
        }
        // data index

        public int searchInLL(K key , int bi) {
            LinkedList<Node> ll = buckets[bi];

            for(int i = 0; i < ll.size(); i += 1) {
                if(ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }
        // rehashing
        
        public void rehash() {

            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];

            // create new nodes of linked list
            for(int i = 0; i < N*2; i += 1) {
                buckets[i] = new LinkedList<>();
            }

            // create new buckets of index
            for(int i = 0; i < oldBucket.length; i += 1) {
                LinkedList<Node> ll = oldBucket[i];

                for(int j = 0; j < ll.size(); j += 1) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }
        // put

        public void put(K key , V value) {

            // bi means bucketIndex
            int bi = hashFunction(key); // this function takes key and give us bucketIndex(bi) of that key , it gives array index

            // di means dataIndex
            int di = searchInLL(key , bi); // this function traverse in Linked List and give the index number of that node , it gives Linked List index

            if(di == -1) { // key does not exists
                buckets[bi].add(new Node(key, value));
                n += 1;
            }
            else { // key exists
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            double lamda = (double)n/N;

            if(lamda > k) {
                rehash();
            } 
        }
        // get

        public V get(K key) {
            int bi = hashFunction(key);

            int di = searchInLL(key, bi);

            if(di == -1) { // key does not exists
                return null;
            }
            else { // key exists
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }
        // contains key

        public boolean containsKey(K key) {
            int bi = hashFunction(key);

            int di = searchInLL(key, bi);

            if(di == -1) { 
                return false;
            }
            else {
                return true;
            }
        }
        // remove

        public V remove(K key) {
            int bi = hashFunction(key);

            int di = searchInLL(key, bi);

            if(di == -1) { // key does not exists
                return null;
            }
            else { // key exists
                Node node = buckets[bi].remove(di);
                n -= 1;
                return node.value;
            }
        }
        // is empty

        public boolean isEmpty() {
            return n == 0;
        }
        // key set

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i = 0; i < buckets.length; i += 1) { // bi
                LinkedList<Node> ll = buckets[i];

                for(int j = 0; j < ll.size(); j += 1) { //di
                    Node node = ll.get(j);
                    keys.add(node.key); 
                }
            }
            return keys;
        }
    }

    public static void main(String args[]) {

        HashMapH<String , Integer> map = new HashMapH();

        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 210);

        ArrayList<String> keys = map.keySet();

        for(int i = 0; i < keys.size(); i += 1) {
            System.out.println(keys.get(i) + " : " + map.get(keys.get(i)));
        }
        map.remove("India");
        System.out.println(map.get("India"));

        System.out.println(map.get("US"));

        if(map.containsKey("US")) {
            System.out.println("Present");
        }
        else {
            System.out.println("Not present");
        }
        if(map.isEmpty()) {
            System.out.println("Empty");
        }
        else {
            System.out.println("not empty");
        }
    }
}
