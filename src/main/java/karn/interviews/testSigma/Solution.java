package karn.interviews.testSigma;


import java.util.concurrent.CompletableFuture;

public class Solution {
    // 1 1 1 0 1 0 1 0 0 0
    public int swap(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int swapCount = 0;
        while (left < right) {
            while (left < right && arr[left] == 1) {
                left++;
            }
            while (right > left && arr[right] == 0) {
                right--;
            }
            if (left < right) {
                swapCount++;
            }
            left++;
            right--;
        }
        return swapCount;
    }

    /*public void joinCompletables(){

        CompletableFuture<Integer> task1 = new CompletableFuture<>();
        CompletableFuture<Integer> task2 = new CompletableFuture<>();

       CompletableFuture.allOf(task1, task2).join();

    }*/

    // 1   2 -1 -4 -2
    // -8 -3  4  2  1
    // 3   8  10  1  3

    // space -> 3x5x3

    // mn[0]
    // 1  3   2  -2  -4
    // -8 -11 -7  -5  -4
    // 3  11  21  22  25

    //mn[1]
    // 1  2  -1  -4  -2
    // -7 -1  3   -2  -1
    // -4  7  14  -1  2

    //mn[2] - [m][n-2][2] - [m-2][n][2] + [m-2][n-2][2]
    //m*n * (m*n) => O(m2*n2)

    //mn[2]
    // 1   3  2  -2  -4
    // -7  -7
    // -4  [m-1]n[0]+m[n-1][1]-original[m-1][n-1] + [m-1][n-1][2] +original[m][n]
}
