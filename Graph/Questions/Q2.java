// A String made of an even number of characters ("<" and/or ">") is 
// called symmetric if all characters in its first half are "<" and 
// all characters in its second half are ">". Example of symmetric 
// string are - "" (empty string), "<>" , "<<>>" , "<<<>>>" , etc.

// Write a function: int solution(String S) that, given a string S made 
// of N characters ("<",">"and /or"?")", return the length of the longest 
// symmetric substring that can be obtained after replacing question 
// marks with "<"or">" characters.

// Input: S = "<<?"
// Output: 2

// Input: S = "<><??>>" Output: 4

// time complexity is O(n)

import java.util.*;

class Firstclass {

    public static int solution(String s) {

        int n = s.length();

        int left[] = new int[n-1];
        int right[] = new int[n-1];

        left[0] = s.charAt(0) != '>' ? 1 : 0 ; // for first index

        for(int i = 1; i < n-1; i += 1) {

            if(s.charAt(i) != '>') {
                left[i] = left[i-1] + 1; // if found continuous less than in left side then add them
            }
            else {
                left[i] = 0;
            }
        }
        right[n-2] = s.charAt(n-1) != '<' ? 1 : 0; // for second last index

        for(int i = n-3; i >= 0; i -= 1) {

            if(s.charAt(i+1) != '<') {
                right[i] = right[i+1] + 1; // if found continuous greater than in right side then add them
            }
            else {
                right[i] = 0;
            }
        }
        int ans = 0;

        for(int i = 0; i < s.length()-1; i += 1) {
            int len = 2 * Math.min(left[i] , right[i]);

            if(len > ans) {
                ans = len;
            }
        }
        return ans;
    }
    public static void main(String args[]) {

        String s = "<><??>>";

        System.out.print(solution(s));
    }
}
