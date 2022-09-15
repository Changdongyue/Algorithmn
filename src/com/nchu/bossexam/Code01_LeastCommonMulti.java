package com.nchu.bossexam;

import java.util.Scanner;

/**
 * 计算两个数的最小公倍数
 */
public class Code01_LeastCommonMulti {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            System.out.println((num1* num2) / gcd(num1, num2));
        }

    }

    public static int gcd(int num1, int num2) {
//        if (num1 < num2) {
//            int temp = num1;
//            num1 = num2;
//            num2 = temp;
//        }
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
