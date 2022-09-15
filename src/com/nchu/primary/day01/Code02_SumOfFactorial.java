package com.nchu.primary.day01;
/*
    求：1!+2!+...n!
 */
public class Code02_SumOfFactorial {
    public static void main(String[] args) {
        System.out.println( f1(5));
        System.out.println( f2(10));
    }
    //方法一
    public static long f1(int n){
        int sum  = 0 ;
        for(int i = 1 ; i <= n ; i++){
            int add = 1;
            for(int j = 1 ;j <= i ; j++ ){
                add = j * add;
            }
            sum += add;
        }
        return sum;
    }
    //方法二
    public static long f2(int n){
        int sum  = 0;
        int add = 1;
        for(int i = 1 ; i <= n ;i++ ){
            add = add * i ;
            sum += add;
        }
        return  sum;
    }
}
