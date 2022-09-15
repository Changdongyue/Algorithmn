package com.nchu.primary.day03;

//使用二分查找，大于等于num的最左位置
public class Code02_BinarySearchLeastXBiggerNum {
    public static void main(String[] args) {
        int maxLen = 8;
        int maxValue = 100;
        int testCount = 100000;
        for (int i = 0; i < testCount; i++) {
            int[] ints = lenRandomValueRandom(maxLen, maxValue);
            if(LeastIndexBiggerNum(ints,5) != commonMethod(ints,5)){
                System.out.println("出错了");
            }
        }
        System.out.println("两个方法结果一样");
        int arr[] = new int[]{1,2,3,4,5,7,8,9};
        System.out.println(LeastIndexBiggerNum(arr,5));
        System.out.println(commonMethod(arr,5));
    }
    //使用二分查找，大于等于num的最左位置
    public static int LeastIndexBiggerNum(int arr[], int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }
    //使用普通方法查找，大于等于num的最左位置
    public static int commonMethod(int arr[],int num){
        for(int i = 0 ; i < arr.length ;i++){
            if(arr[i]>=num){
                return i;
            }
        }
        return -1;
    }
    //返回一个任意长度，任意值的有序的数组。
    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen)+1;
        int arr[] = new int[len];
        arr[0] = (int) (Math.random() * maxValue);
        for (int i = 1; i < len; i++) {
            do{
                arr[i] = (int) (Math.random() * maxValue);
            }while(arr[i-1] > arr[i]);

        }
        return arr;
    }
}