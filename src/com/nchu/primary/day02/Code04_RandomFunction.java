package com.nchu.primary.day02;

//已知f1不等概率返回0和1，求f2等概率返回0和1
public class Code04_RandomFunction {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            if (f2() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double) 1000000);
    }

    public static int f1() {
        return Math.random() < 0.8 ? 0 : 1;
    }

    public static int f2() {
        int ans;
        do {
            ans = f1();
        } while (f1() == ans);
        return ans;
    }

}
