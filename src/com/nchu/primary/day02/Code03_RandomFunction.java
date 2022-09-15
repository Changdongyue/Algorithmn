package com.nchu.primary.day02;

// 已知f1等概率生成3-7之间的整数，求等概率生成32-79之间的数

public class Code03_RandomFunction {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 100000; i++) {
            int num = f4();
            if(num >=32 && num <=56 ){
                count++;
            }
        }
        System.out.println((double) count/(double) 100000);
//        System.out.println("======================");
//        for (int i = 0; i < 100000; i++) {
//            System.out.println(f4());
//        }
    }

    //f1：等概率返回3-7之间的数
    public static int f1() {
        return (int) (Math.random() * 5) + 3;
    }

    //f2:等概率返回0和1（只能使用f1）
    // 解：f1可以返回3，4，5，6，7五个数，如果产生5让他重新生成，f1的值返回为3，4的的话，则f2返回0；f1的值返回为6，7的话f2返回1。
//    public static int f2() {
//        int num = f1();
//        while (num == 5) {
//            num = f1();
//        }
//        return num < 5 ? 0 : 1;
//    }

    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 5);
        return ans < 5 ? 0 : 1;
    }

    //   f3:等概率生成0-47之间的数，需要6个二进制位，大于47的数让其重新生成。
//    public static int f3() {
//        int num = 0;
//        for (int i = 0; i < 6; i++) {
//            num += f2() << i;
//        }
//        while (num > 47) {
//            num = 0;
//            for (int i = 0; i < 6; i++) {
//                num += f2() << i;
//            }
//        }
//        return num;
//    }
    public static int f3() {
        int ans = 0;
        do {
            ans = (f2() << 5) + (f2() << 4) + (f2() << 3) + (f2() << 2) + (f2() << 1) + f2();
        } while (ans > 47);
        return ans;
    }

    // f4:等概率生成32-79之间的数

    public static int f4() {
        return f3() + 32;
    }
}
