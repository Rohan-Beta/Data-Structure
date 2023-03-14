// Subarray sum
// sum equal to k
// time complexity is O(1)

import java.util.*;

class Firstclass {
    
    public static void main(String args[]) {

        int arr[] = {10 , 2 , -2 , -20 , 10};
        int k = -10;

        HashMap<Integer , Integer> map = new HashMap<>(); // <sum , frequency>

        map.put(0, 1); // create empty Subarray

        int sum = 0;
        int ans = 0;

        for(int i = 0; i < arr.length; i += 1) {
            sum += arr[i];

            if(map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            }
            if(map.containsKey(sum)) {
                map.put(sum , map.get(sum) + 1);
            }
            else {
                map.put(sum, 1);
            }
        }
        System.out.println(ans);
    }
}
