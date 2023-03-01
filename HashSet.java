// HashSet
//time complexity for all is O(1)

// insert/add
// size
// search/contains
//delete/remove
// Iterator

// HashSet does not print duplicates
// HashSet are unorder

import java.util.*;

class Firstclass {
    public static void main(String args[]) {

        // create HashSet
        HashSet<Integer> set = new HashSet<>();

        // add elements
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // take a duplicate
        set.add(4);

        System.out.print(set +"\n");

        System.out.print(set.size() +"\n"); //get size

        // search/contains

        if(set.contains(1)) {
            System.out.print("Found\n");
        }
        else {
            System.out.print("not found\n");
        }

        // delete/remove
        set.remove(1);

        if(!set.contains(1)) {
            System.out.print("removed\n");
        }
        else {
            System.out.print("not removed\n");
        }
        System.out.print(set + "\n");

        // Iterator
        Iterator it = set.iterator();

        // System.out.print(it.next() +"\n"); // it first denote null value
        // System.out.print(it.next() +"\n");

        // it.hasNext() will print true if next idex is not null else print false
        // System.out.print(it.hasNext() + "\n");

        // loop
        while(it.hasNext() == true) {
            System.out.print(it.next() + "\n");
        }
    }
}
