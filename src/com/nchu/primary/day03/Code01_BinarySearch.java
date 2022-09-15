package com.nchu.primary.day03;

import java.util.Arrays;
// 二分查找数组中的某一个数
public class Code01_BinarySearch {
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            int[] ints = lenRandomValueRandom(8, 100);
            Arrays.sort(ints);
            //判断两种方法的结果是否一样
            if (find(ints, 5) != findCommon(ints, 5)) {
                System.out.println("出错了");
            }

        }
        System.out.println("正确");

        // System.out.println(find(arr,4) == findCommon(arr,4));
    }

    //二分查找实现
    public static boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return false;
    }

    //普通实现
    public static boolean findCommon(int arr[], int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    //返回一个任意长度，任意值的数组。
    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }
}
