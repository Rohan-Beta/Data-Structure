// quick sort

import java.util.*;

class Firstclass {
    public static int partition(int arr[] , int sidx , int eidx) {

        int pivot = arr[eidx];
        int i = sidx-1;

        for(int j = sidx; j < eidx; j += 1) {
            if(arr[j] < pivot) {
                i += 1;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // pivot index
        i += 1;

        int temp = arr[i];
        arr[i] = arr[eidx];
        arr[eidx] = temp;

        return i;
    }
    public static void quickSort(int arr[] , int sidx , int eidx) {

        if(sidx >= eidx) {
            return;
        }
        int pivot = partition(arr, sidx, eidx);

        quickSort(arr, sidx, pivot-1);
        quickSort(arr, pivot+1, eidx);
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

        quickSort(arr, 0, n1-1);

        for(int i = 0; i < arr.length; i += 1) {
            System.out.print(arr[i] + " ");
        }
    }
}
