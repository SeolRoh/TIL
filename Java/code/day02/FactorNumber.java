package com.example;
import java.util.*;

public class FactorNumber {
    public static void main(String[] args){
        int num = 0;
        int cal = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("숫자를 입력하시오");
        num = in.nextInt();


        for(int i = 1; i<=num; i++){
            if( (num / i) * i == num ){
                System.out.println(i + " ");
            }
        }
    }
}
