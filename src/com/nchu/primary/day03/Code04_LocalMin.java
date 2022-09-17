package com.nchu.primary.day03;

//找到一个局部最小即可:也可以用二分法即使无序
/*
    给定一个无序，但相邻位置不等的数组，求出一个局部最小
    若：arr[0] < arr[1] 则 0 位置局部最小
    若：arr[N-1] < arr[N-2] 则 N-1 位置局部最小 N为数组长度
    若： arr[i-1]>arr[i]<arr[i+1] 则i位置局部最小
 */
public class Code04_LocalMin {
    public static void main(String[] args) {
        int arr[] = new int[]{3,2,4,6,1};
        System.out.println(localMin(arr));
    }
    //返回一个任意长度，任意值的数组 且相邻位置数组元素的值不相等
    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int arr[] = new int[len];
        arr[0] = (int) (Math.random() * maxValue);
        for (int i = 1; i < len; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue);
            } while (arr[i] == arr[i - 1]);
        }
        return arr;
    }

    public static int localMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int L = 0;
        int R = arr.length - 1;

        while (L < R-1) {
            int mid = (L+R) /2;
            if(arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1]){
                return mid;
            }else{
                if(arr[mid-1]< arr[mid]){
                    R = mid -1;
                }else{
                    L = mid +1;
                }
            }
        }
        return arr[L] < arr[R] ? L : R;
    }

}
