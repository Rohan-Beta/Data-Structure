// HashMap (dictionary in python)

// put/insert
// search/contains
// get value from key
// Iteration
// delete/remove

import java.util.*;

class Firstclass {
    public static void main(String args[]) {

        // create
        HashMap<String , Integer> map = new HashMap<>();

        // put/insert
        // map.put(key, value)

        map.put("china", 100);
        map.put("Russia", 120);
        map.put("India", 140);

        // System.out.print(map + "\n");

        map.put("china", 160); // update
        System.out.print(map + "\n");

        // search/contains

        if(map.containsKey("china")) {
            System.out.print("Found\n");
        }
        else {
            System.out.print("not found\n");
        }
        if(map.containsValue(200)) {
            System.out.print("found\n");
        }
        else {
            System.out.print("not found\n");
        }

        System.out.println(map.get("Russia"));
        System.out.println(map.get("America"));

        // iteration example in HashMap

        // int arr[] = {1 , 2 , 4 , 3};

        // for(int val : arr) {
        //     System.out.print(val + " ");
        // }
        // System.out.print("\n");

        // Iteration
        for(Map.Entry<String , Integer> m : map.entrySet()) {
            System.out.print(m.getKey() + " : " + m.getValue() + "\n");
        }
        // delete/remove

        map.remove("china");
        System.out.print(map + "\n");
    }
}
