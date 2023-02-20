// insertion sort

import java.util.*;

class Firstclass {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // take indexes
        System.out.print("Enter number of indexes: ");
        int n = sc.nextInt();

        // create an array with n index
        int arr[] = new int[n];

        int num = 1;

        // taking input from user
        for(int i = 0; i < n; i += 1) {
            System.out.print("Enter " + num + " index: ");
            arr[i] = sc.nextInt();

            num += 1;
        }

        System.out.print("Unsorted array: \n");

        for(int i = 0; i < n; i += 1) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("\n");

        // sorting the array

        for(int i = 0; i < arr.length; i += 1) {
            int current = arr[i];

            int j = i-1;
            while(j >= 0 && current < arr[j]) {
                arr[j+1] = arr[j];

                j -= 1;
            }
            arr[j+1] = current;
        }

        System.out.print("Sorted array: \n");

        for(int i = 0; i < arr.length; i += 1) {
            System.out.print(arr[i] + " ");
        }
    }
}
