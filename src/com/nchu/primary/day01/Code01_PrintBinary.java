package com.nchu.primary.day01;

public class Code01_PrintBinary {
    /**
     * 打印一个数的二进制数
     */
    public static void print(int num){
        for(int i = 31 ; i >= 0  ; i-- ){

            System.out.print(((1 << i ) & num) == 0 ? 0 : 1);

        }
        System.out.println();
    }
    public static void main(String[] args) {
        print(112);
    }
}
