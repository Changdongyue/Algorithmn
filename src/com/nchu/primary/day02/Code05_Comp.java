package com.nchu.primary.day02;
//对数器
public class Code05_Comp {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,56,5};
        System.out.println(isSorted(arr));
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
    //判断数组是否排序
    public static boolean isSorted(int arr[]){
        int max = arr[0];
        for (int i = 1 ; i < arr.length ;i++){
            if(max > arr[i]){
                return false;
            }
            max = Math.max(max,arr[i]);
        }
        return true;
    }

}
