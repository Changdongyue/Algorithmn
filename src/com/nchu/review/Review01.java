package com.nchu.review;

import java.util.Arrays;
import java.util.Scanner;

public class Review01 {
    public static void main(String[] args) {

        for (int i = 0; i < 100000; i++) {
            int[] ints = lenRandomValueRandom(8, 100);
            Arrays.sort(ints);
            if (!isSorted(ints)) {
                System.out.println("isSorted method error！");
            }
        }
        System.out.println("isSorted method correct!");
        System.out.println("========================");
        int arr[] = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(preSum(arr, 1, 3));
        System.out.println("========================");
        System.out.println(printBinary(8));
        System.out.println("========================");
        String s = Integer.toHexString(10);
        System.out.println(s);
        String s1 = s.toUpperCase();
        int i = Integer.parseInt(s1, 16);
        System.out.println(i);
        System.out.println("========================");
        System.out.println(trimString("abc def"));
        System.out.println("========================");
        System.out.println(sumOfFactorial(2));
        System.out.println("========================");
        int[] arr1 = new int[]{1, 5, 9, 7, 2, 3, 5, 8};
        int[] arr2 = new int[]{1, 5, 9, 7, 2, 3, 5, 8};
        int[] arr3 = new int[]{1, 5, 9, 7, 2, 3, 5, 8};
        System.out.println(Arrays.toString(arr1));
        selectSort(arr1);
        System.out.println(Arrays.toString(arr1));
        bubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));
        insertSort(arr3);
        System.out.println(Arrays.toString(arr3));
        System.out.println("========================");
        Scanner scanner = new Scanner(System.in);
        int i1 = scanner.nextInt();
        int i2 = scanner.nextInt();
        System.out.println("i1和i2的最小公倍数为" + (i1 * i2) / gcd(i1, i2));
    }

    //判断数组是否有序
    public static boolean isSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
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

    //已知f1（）非等概率返回0和1，求f2()让其等概率返回0和1
    public static int f1() {
        return Math.random() < 0.8 ? 0 : 1;
    }

    public static int f2() {
        int res;
        do {
            res = f1();
        } while (res == f1());
        return res;
    }

    // 已知f3等概率生成3-7之间的整数，求f6等概率生成32-79之间的数
    public static int f3() {
        return (int) (Math.random() * 5) + 3;
    }

    //等概率生成0-1之间的数
    public static int f4() {
        int res;
        do {
            res = f3();
        } while (res == 5);
        return res < 5 ? 0 : 1;
    }

    //等概率生成0-47之间的数 需要六个二进制位表示
    public static int f5() {
        int res;
        do {
            res = (f4() << 5) + (f4() << 4) + (f4() << 3) + (f4() << 2) + f4();
        } while (res > 47);
        return res;
    }

    //f5 + 32 即可生成32-79之间的数
    public static int f6() {
        return f5() + 32;
    }

    /*
    preSum(int arr[],int L ,int R):求数组下标L到R之间的和
 */
    public static int preSum(int arr[], int L, int R) {
        int[] temp = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            temp[i] = sum;
        }
        if (L == 0) {
            return temp[R];
        } else {
            return temp[R] - temp[L - 1];
        }
    }

    //打印一个数的二进制数
    public static StringBuilder printBinary(int num) {
        StringBuilder s = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            s.append((((1 << i) & num) == 0 ? 0 : 1));
        }
        return s;
    }

    // 求n!
    public static int factorial(int num) {

        if (num == 1) {
            return 1;
        } else {
            return factorial(num - 1) * num;
        }

    }

    //   求：1!+2!+...n!
    public static int sumOfFactorial(int num) {
        int sum = 0;
        int add = 1;
        for (int i = 1; i <= num; i++) {
            add *= i;
            sum += add;

        }
        return sum;
    }

    //去掉字符串里面的空格
    public static String trimString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder temp = new StringBuilder();
        for (char c : chars) {
            if (c != ' ') {
                temp.append(c);
            }
        }
        return temp.toString();
    }

    //选择排序
    public static void selectSort(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        int minIndex;
        for (int i = 1; i < ints.length; i++) {
            minIndex = i - 1;
            for (int j = i; j < ints.length; j++) {
                minIndex = ints[j] < ints[minIndex] ? j : minIndex;
            }
            swapElems(ints, minIndex, i - 1);
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i + 1; j++) {
                if (arr[j - 1] > arr[j]) {
                    swapElems(arr, j - 1, j);
                }
            }
        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            while (i >= 1 && arr[i - 1] > arr[i]) {
                swapElems(arr, i - 1, i);
                i--;
            }
        }
    }

    //交换数组i和j位置的元素
    public static void swapElems(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //求两个数的最小公倍数
    //先求两个数的最大公因数
    public static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
            return gcd(num1, num2);
        }
    }

}
