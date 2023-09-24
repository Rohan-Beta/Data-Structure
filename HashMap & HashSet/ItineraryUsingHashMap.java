// find Itinerary(means find the journey)

// create HashMap
// create Reverse HashMap to compare between two HashMap and find the starting point

import java.util.*;

class Firstclass {

    public static String start(HashMap<String , String> tick) {

        HashMap<String , String> revMap = new HashMap<>(); // create reverse HashMap

        for(String keys : tick.keySet()) {
            revMap.put(tick.get(keys), keys); // here value will be key and key will be value
        }
        for(String keys : tick.keySet()) { // traverse in HashMap
            if(!revMap.containsKey(keys)) {
                return keys;
            }
        }
        return null;
    }
    public static void main(String args[]) {

        HashMap<String , String> ticket = new HashMap<>();

        ticket.put("chennai", "bengaluru");
        ticket.put("mumbai", "delhi");
        ticket.put("goa", "chennai");
        ticket.put("delhi", "goa");

        String start = start(ticket);

        while(ticket.containsKey(start)) {
            System.out.println(start);
            start = ticket.get(start);
        }
        System.out.println(start);
    }
}
