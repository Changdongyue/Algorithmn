package com.nchu.primary.day05;

import sun.text.resources.cldr.ti.FormatData_ti;

import java.util.HashMap;
import java.util.HashSet;

/*
    num1 % num2 == num1 & (num2-1) 注意：num2必须是2的n次方
    变成0 --> &0
    变成1 --> |1
 */
public class Code01_BitMaps {

    public static class BitMap {
        private long[] bits;

        public BitMap(int max) {
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            bits[num >> 6] |= 1L << (num & 63);
        }

        public void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            return ((bits[num >> 6] & 1L << (num & 63)) == 0) ? false : true;
        }
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(10000);
        HashSet set = new HashSet<>();
        int testCounts = 100000;
        int random;
        int num;
        for (int i = 0; i < testCounts; i++) {
            random = (int) Math.random();
            num = (int) Math.random() * (10001);
            if (random < 0.3) {
                bitMap.add(num);
                set.add(num);
            } else if (random < 0.6) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("出错了");
                    break;
                }
            }
        }
        for (int i = 0; i <= 10000; i++) {
            if (bitMap.contains(i) != set.contains(i)) {
                System.out.println("Oops");
                break;
            }
        }
        System.out.println("测试结束！！！");
        int i = Integer.MIN_VALUE;
        System.out.println(-i);
        System.out.println(-1 / i);
    }
}
