package com.nchu.myself;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

//求num范围内有几个素数或质数（1不是素数）
public class PrimeNumber {
    public static void main(String[] args) {

        System.out.println(primeNumber(200));
        System.out.println(primeNumber(200).size());
    }

    public static ArrayList primeNumber(int num) {
        ArrayList<Integer> ints = new ArrayList<Integer>();
        if (num == 1) {
            return null;
        }
        if (num == 2) {
            ints.add(2);
            return ints;
        }

        boolean flag;
        ints.add(2);
        for (int i = 3; i <= num; i++) {
            flag = true;
            for (int j = 2; j <= (i / 2) + 1; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ints.add(i);
            }
        }
        return ints;
    }
}
