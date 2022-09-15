package com.nchu.primary.day02;

public class Code02_RandomFunction {
    public static void main(String[] args) {
        System.out.println("======测试test01======");
        test01();
        System.out.println("======测试f1======");
        int count = 0;
        for (int i = 0; i < 10000000; i++) {
            if (f1() < 0.6) {
                count++;
            }
        }
        System.out.println((double) count / (double) 10000000); //输出的结果近似于0.6*0.6
        System.out.println("======测试f2======");//[0,x)之间生成的概率为1-（1-x）^2
        int count1 = 0;
        for (int i = 0; i < 10000000; i++) {
            if (f2() < 0.6) {
                count1++;
            }
        }
        System.out.println((double) count1 / (double) 10000000);
        System.out.println(1-Math.pow((1-0.6),2));
        System.out.println("======测试f11======");//[0,x)之间生成的概率为1-（1-x）^2
        int count2 = 0;
        for (int i = 0; i < 10000000; i++) {
            if (f11() < 0.6) {
                count2++;
            }
        }
        System.out.println((double) count2 / (double) 10000000);
        System.out.println(Math.pow(0.6,3));
    }

    /*
    Math.random()方法等概率生成[0,1)之间的随机数,且[0,x)之间生成的概率为x。如test01方法
    */
    public static void test01() {
        int count = 0;
        for (int i = 0; i < 10000000; i++) {
            if (Math.random() < 0.6) {
                count++;
            }
        }
        System.out.println((double) count / (double) 10000000); //输出的结果近似于0.6
    }
    /*
        Math.random()方法等概率生成[0,1)之间的随机数,且[0,x)之间生成的概率为x。
        如何使[0,x)之间生成的概率为x的平方。
     */
    public static double f1()
    {
        return Math.max(Math.random(), Math.random());
    }
    //使[0,x)之间生成的概率为x^3
    public static double f11()
    {
        return Math.max(Math.random(), Math.max(Math.random(),Math.random()));
    }
    /*
       Math.random()方法等概率生成[0,1)之间的随机数,且[0,x)之间生成的概率为x。
       如果Math.min则[0,x)之间生成的概率为1-（1-x）^2。
    */
    public static double f2()
    {
        return Math.min(Math.random(), Math.random());
    }

}
