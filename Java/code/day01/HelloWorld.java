package com.example;

//import java.Lang.*;
import java.util.*;
import java.lang.System;
//import System from java.Lang;

public class HelloWorld {
    public static void main(String[] args){
        System.out.println("Hello World!");

        Scanner s = new Scanner(System.in);
        System.out.println("국어점수 = ");
        int kor = s.nextInt();

        System.out.println("영어점수 = ");
        int eng = s.nextInt();

        System.out.println("수학점수 = ");
        int mat = s.nextInt();

        float total = kor + eng + mat;
        float avg = (total / 3.0F);

        System.out.println(avg);
    }
}
