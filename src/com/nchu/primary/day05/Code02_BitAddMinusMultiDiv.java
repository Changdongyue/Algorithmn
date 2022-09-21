package com.nchu.primary.day05;
// 测试链接：https://leetcode.com/problems/divide-two-integers
public class Code02_BitAddMinusMultiDiv {
    /*
         位操作实现加法运算 两个数异或相当于无进位加法
         进位：(num1 & num2) << 1
         num1 + num2 = (num1 ^ num2) + (num1 & num2) << 1
         进位信息为0时，得到num1 + num2
     */
    public static int add(int num1, int num2) {
        int sum = num1;
        while (num2 != 0) {
            sum = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = sum;
        }
        return sum;
    }

    //求相反数 -b = ~b +1
    public static int negNum(int num) {
        return add(~num, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    //一个数 & 1结果不是1就是0 可以判断该数的奇偶性
    // >> 带符号右移 >>> 不带符号右移
    public static int multi(int a, int b) {
        int sum = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                sum = add(sum, a);
            }
            a <<= 1;
            b >>>= 1; //一定是不带符号右移，否则b为负数的话，b永远不可能为0
        }
        return sum;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }


    public static int div(int a, int b) {
        int x = a;
        int y = b;
        //先将a，b转化成正数进行处理
        a = isNeg(a) ? negNum(a) : a;
        b = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i=minus(i,1)) {
            if ((a >> i) >= b) {
                res |= 1 << i;
                a = minus(a, b << i);
            }
        }
        return isNeg(x) ^ isNeg(y) ? negNum(res) : res;
    }

    public static int divid(int num1,int num2) {
        //Integer.MIN_VALUE 没有相反数 所以需要特殊处理
        if (num1 == Integer.MIN_VALUE && num2 == Integer.MIN_VALUE){
            return 1;
        }else if(num2 == Integer.MIN_VALUE){
            return 0;
        }else if(num1 == Integer.MIN_VALUE){
            if(num2 == negNum(1)){
                return Integer.MAX_VALUE;
            }else{
                int c = div(add(num1, 1), num2);
                return add(c, div(minus(num1,multi(c,num2)),num2));
            }
        }else {
           return  div(num1,num2);
        }
    }


    public static void main(String[] args) {
        System.out.println("10+3:"+add(10,3));
        System.out.println("10-3:"+minus(10,3));
        System.out.println("10*3:"+multi(10,3));
        System.out.println("7/-3:"+divid(7,-3));
    }
}
