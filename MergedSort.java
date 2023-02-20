// merged sort

import java.util.*;

class Firstclass {
    public static void conquer(int arr[] , int sidx , int mididx , int eidx) {

        int merged[] = new int[eidx - sidx + 1];

        int idx1 = sidx;
        int idx2 = mididx+1;
        int x = 0;

        while(idx1 <= mididx && idx2 <= eidx) {
            if(arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            }
            else {
                merged[x++] = arr[idx2++];
            }
        }
        while(idx1 <= mididx) {
            merged[x++] = arr[idx1++];
        }
        while(idx2 <= eidx) {
            merged[x++] = arr[idx2++];
        }

        for(int i = 0 , j = sidx; i < merged.length; i++ , j++) {
            arr[j] = merged[i];
        }
    }
    public static void divide(int arr[] , int sidx , int eidx) {
        
        if(sidx >= eidx) {
            return;
        }
        int mididx = sidx + (eidx - sidx) / 2;

        divide(arr, sidx, mididx);
        divide(arr, mididx+1, eidx);
        conquer(arr, sidx, mididx, eidx);
    }
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number number of indexes: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        int num = 1;

        for(int i = 0; i < n; i += 1) {
            System.out.print("Enter " + num + " index: ");
            arr[i] = sc.nextInt();

            num += 1;
        }

        System.out.println("Unsorted array: \n");
        
        for(int i = 0; i < arr.length; i += 1) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");

        System.out.print("Sorted Array: \n");

        int n1 = arr.length;

        divide(arr, 0, n1-1);

        for(int i = 0; i < arr.length; i += 1) {
            System.out.print(arr[i] + " ");
        }
    }
}
