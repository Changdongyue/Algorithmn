package com.nchu.sort;

/*
    选择排序2.0：每轮选择一个最小的数放在前面同时选择一个最大的数放在后面
 */
public class SelectionSort02 {
    public static void main(String[] args) {
        int arr[] = {8, 5, 3, 7, 4, 9, 2, 1, 6};
        print(arr);
        System.out.println();
        for(int i = 1 ; i <= (arr.length / 2) ;i++){
            int minIndex = i - 1 ;
            int maxIndex = arr.length - i ;
            for(; minIndex < maxIndex ;minIndex++,maxIndex--){
                minIndex = (arr[maxIndex] < arr[minIndex]) ? maxIndex :minIndex ;
                maxIndex = (arr[maxIndex] < arr[minIndex]) ? minIndex :maxIndex ;
            }
            swap(arr,minIndex,i-1);
            swap(arr,maxIndex,arr.length - i);
        }
        print(arr);
    }
        //交换数组元素i,j的位置
        public static void swap ( int arr[], int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        public static void print ( int arr[]){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
    }

}
