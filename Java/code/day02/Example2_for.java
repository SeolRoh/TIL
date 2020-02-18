package com.example;

public class Example2_for {
    public static void main(String[] args){
        int a = 1;
        int b = 2;
        int c = a++ + b++ ;
        System.out.println(a + ", " + a++ +
                ", " + ++b +
                ", " + c);
        //a, a, b, c
        for(int i=0;i<10; i++){
            a++;
            System.out.println(a + "=" +i);
        }
        String name =" seol";
                System.out.println(name instanceof String);
                System.out.println(name instanceof Object);
    }
}
