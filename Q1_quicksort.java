/**
 * This is Problem 1 of the project. This class inplements quicksort for entered
 * array.
 * It can be called by the method call_quicksort() inside the coder_runner
 * class.
 */
public class Q1_quicksort {
    // this fucntion checks the input and runs quick sort if no error detected
    public void my_quicksort(int[] arr) {
        if (arr == null) {
            System.out.println("Null array");
        } else if (arr.length == 0) {
            System.out.print("Empty array");
        } else {
            quicksort_helper(arr, 0, arr.length - 1);
            print(arr);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pNum = arr[low]; // first element of each subarray is defined as pivot
        int i = low;
        /*
         * Move j to the right unless the element at j has a value greater than the
         * pivot.
         * In this case, element at j will then swap with the element at i++.
         */
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] > pNum) {
                i++;
                swap(i, j, arr);
            }
        }

        // swap the pivot with the element at i to finish the partition of the subarray
        swap(i, low, arr);
        return low;
    }

    // function for splitting the array and calling parition for sub arrays
    private void quicksort_helper(int[] arr, int low, int high) {
        if (low < high) {
            int loc = partition(arr, low, high);
            quicksort_helper(arr, low, loc - 1);
            quicksort_helper(arr, loc + 1, high);
        }
    }

    // function for swapping two elements inside an array
    private void swap(int a, int b, int arr[]) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // function for printing an array out
    private void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
