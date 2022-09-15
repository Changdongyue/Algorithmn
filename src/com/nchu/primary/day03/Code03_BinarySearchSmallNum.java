package com.nchu.primary.day03;

//使用二分查找，小于等于num的最右位置
public class Code03_BinarySearchSmallNum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,9,45,78,102};
        System.out.println(binarySearch(arr,90));

    }

    public static int binarySearch(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int res = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] <= num) {
                res = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return res;
    }
}
