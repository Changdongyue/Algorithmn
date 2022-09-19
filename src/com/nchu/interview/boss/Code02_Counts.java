package com.nchu.interview.boss;

import java.util.Scanner;

/**
 * 键盘输入一个整数，计算每位的乘积，直到结果为个位数，输出用的次数。
 * 例如：
 * input：385
 * 第一次：3*8*5=120 第二次：1*2*0=0
 * output：2
 */
public class Code02_Counts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int counts = CountNumber(num);
        System.out.println(counts);
    }

    private static int CountNumber(int num) {
        int count = 0;
        int sum = 0;
        while (true) {
            sum = multi(num);
            count++;
            if (sum <= 9) {
                return count;
            }
            num = sum;
        }
    }

    /**
     * 返回参数num每位的乘积
     * 例如：456 返回4*5*6=120
     *
     * @param num
     * @return
     */
    public static int multi(int num) {
        int length = (int) Math.floor(Math.log10(num)) + 1;
        int mul = 1;
        int subNum = 0;
        for (int i = 0; i < length; i++) {
            subNum = num % 10;
            mul *= subNum;
            num = num / 10;
        }
        return mul;
    }

}
