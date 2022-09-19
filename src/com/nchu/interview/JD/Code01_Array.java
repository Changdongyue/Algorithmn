package com.nchu.interview.JD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
        构造一个长度为a+b的数组，其中恰好有a个1，b个2，且任意相邻两数的乘积都是偶数，
        如果不存在返回null，否则返回任意一个解即可

 */
public class Code01_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println(makeArray(num1, num2));
    }

    public static List makeArray(int num1, int num2) {
        ArrayList<Integer> ints = new ArrayList<>();
        //如果没有2一定返回null
        if (num2 == 0 && num1 > 1) {
            return null;
        }
        //1的数量比2的数量多2时返回null
        if (num1 > num2 + 1) {
            return null;
        }
        while (num1 != 0 && num2 != 0) {
            ints.add(1);
            ints.add(2);
            num1--;
            num2--;
        }
        if (num1 == 0) {
            for (int i = 0; i < num2; i++) {
                ints.add(2);
            }
        } else {
            ints.add(1);
        }
        return ints;
    }
}
