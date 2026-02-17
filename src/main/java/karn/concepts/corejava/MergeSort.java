package karn.concepts.corejava;

public class MergeSort {

    //given an array of integers, sort the array using merge sort algorithm
    static void main() {
        int[] arr = {38, 27, 43, 3, 9, 82, 1};
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) >>> 1;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int m = mid - left + 1;
        int n = right - mid;
        int[] temp1 = new int[m];
        int[] temp2 = new int[n];
        for (int i = 0; i < m; i++) {
            temp1[i] = arr[left + i];
        }
        for (int i = 0; i < n; i++) {
            temp2[i] = arr[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = left;
        //copy to original array
        while (i < m && j < n) {
            if (temp1[i] < temp2[j]) {
                arr[k++] = temp1[i];
                i++;
            } else {
                arr[k++] = temp2[j];
                j++;
            }
        }
        while (i < m) {
            arr[k++] = temp1[i++];
        }
        while (j < n) {
            arr[k++] = temp2[j++];
        }
    }
}
