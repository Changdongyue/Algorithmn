package com.nchu.primary.day01;

public class Code04_BubbleSort {
    public static void main(String[] args) {
        int arr[] = {1,5,8,7,6,4,3,9,2};
        printArray(arr);
        bubbleSort(arr);
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
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2 ){
            return ;
        }
        for( int i = 1 ; i < arr.length ; i++ ){
            for(int j = 0 ; j < arr.length - i ; j++){
               if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                }
            }
        }
    }
}
