package karn.platforms.leetcode.potd.date20260225;

//https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/?envType=daily-question&envId=2026-02-25
public class Solution {
    //Self note: mapping using streams takes time. Own merge sort with custom logic
    public int[] sortByBits(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private int bitCount(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    private void mergeSort(int[] arr, int i, int j) {
        if (i < j) {
            int mid = (i + j) >>> 1;
            mergeSort(arr, i, mid);
            mergeSort(arr, mid + 1, j);
            merge(arr, i, mid, j);
        }
    }

    private void merge(int[] arr, int i, int m, int j) {
        int p = m - i + 1;
        int q = j - m;
        int[] one = new int[p];
        int[] two = new int[q];
        int left = 0;
        while (left < p) {
            one[left] = arr[i + left];
            left++;
        }
        left = 0;
        while (left < q) {
            two[left] = arr[m + 1 + left];
            left++;
        }
        int s = 0;
        int t = 0;
        int l = i;
        while (s < p && t < q) {
            int abc = bitCount(one[s]);
            int bbc = bitCount(two[t]);
            if (abc == bbc) {
                if (one[s] < two[t]) {
                    arr[l++] = one[s++];
                } else {
                    arr[l++] = two[t++];
                }
            } else {
                if (abc < bbc) {
                    arr[l++] = one[s++];
                } else {
                    arr[l++] = two[t++];
                }
            }
        }
        while (s < p) {
            arr[l++] = one[s++];
        }
        while (t < q) {
            arr[l++] = two[t++];
        }
    }
}