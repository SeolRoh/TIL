package com.example;
import  java.util.*;

public class Example3_swith_case {
    public static void main(String[] args){
        //사용자로 부터 국어(kor), 영어(eng), 수학(mat)입력 받고
        // 총점과 평균을 입력하고
        //평균에 따라서,
        //90 A 80 B 70 C 60 D
        int kor =0; int eng =0; int mat =0;
        int total =0; int avg =0;

        Scanner in = new Scanner(System.in);
        System.out.println("국어점수입력: ");
        kor = in.nextInt();

        System.out.println("영어점수 입력: ");
        eng = in.nextInt();

        System.out.println("수학점수 입력: ");
        mat= in.nextInt();

        total = kor + eng + mat;
        avg = total / 3 ;

        switch (avg/10){
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
                System.out.println("F");
                break;
        }
    }
}
