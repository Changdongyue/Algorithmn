package com.nchu.sort;

/*
    选择排序1.0：每轮选择一个最小的数放在前面
 */
public class SelectionSort01 {
    public static void main(String[] args) {
        int arr[] = {8, 5, 3, 7, 4, 9, 2, 1, 6};
        print(arr);
        System.out.println();
        for(int i = 1 ; i < arr.length ;i++){
            int Minindex = i - 1 ;
            for(int j = i ; j < arr.length ;j++){
                Minindex = (arr[j] < arr[Minindex]) ? j :Minindex ;
            }
            swap(arr,Minindex,i-1);
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
