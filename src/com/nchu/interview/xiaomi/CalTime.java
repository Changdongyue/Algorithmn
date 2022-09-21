package com.nchu.interview.xiaomi;

import java.util.HashSet;
import java.util.Scanner;
/*
        给定n组输入，代表每一款应用的开始时间和结束时间，问一共使用了多长时间？
        输入：
        1 3
        1 6
        4 7
        输出：6
 */
public class CalTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        String s = null;
        while (true) {
            if ((s = scanner.nextLine()).equals("")) {
                System.out.println(set.size());
                break;
            } else {
                String[] s1 = s.split(" ");
                int[] ints = new int[2];
                for (int i = 0; i < 2; i++) {
                    ints[i] = Integer.valueOf(s1[i]);
                }
                for (int i = ints[0] + 1; i <= ints[1]; i++) {
                    set.add(i);
                }
            }
        }

    }
}
