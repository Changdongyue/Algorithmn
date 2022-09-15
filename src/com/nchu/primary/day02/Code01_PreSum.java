package com.nchu.primary.day02;

/*
    preSum(int arr[],int L ,int R):求数组下标L到R之间的和
 */
public class Code01_PreSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 4, 24};
        System.out.println(preSum(arr, 1, 5));
    }

    public static int preSum(int arr[], int L, int R) {
        int[] arrSum = new int[arr.length];
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];
            arrSum[i] = temp;
        }
        return (L == 0) ? arrSum[R] : arrSum[R] - arrSum[L - 1];
    }
}
