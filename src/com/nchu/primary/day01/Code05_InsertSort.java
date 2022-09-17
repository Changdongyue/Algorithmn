package com.nchu.primary.day01;

public class Code05_InsertSort {
    public static void main(String[] args) {
        int arr[] = {1,5,8,7,6,4,3,9,2};
        printArray(arr);
        insertSort(arr);
        printArray(arr);
    }
    public static void printArray(int[] arr){
        for (int i = 0 ; i < arr.length ;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void swap(int arr[] ,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void insertSort(int arr[]){
        if(arr == null || arr.length < 2 ){
            return ;
        }
        for(int i = 1 ; i < arr.length ; i++){
            while( i >=1  && arr[i-1] > arr[i]){
                swap(arr,i-1,i);
                i--;
            }
        }
    }

}
