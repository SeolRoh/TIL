package com.example;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args){
        int lineNumber=1;
        int count = 0; //각 라인에 출력되는 숫자의 개수
        boolean isNotPrime;

        for ( int i = 2; i <= 107 ; i++){
            isNotPrime = false;
            if (i == 2){
                System.out.println(i);
                continue;
            }

            for(int j = 2; j < i; j++){
                if( (i % j) == 0 ){
                        isNotPrime = true;
                        break;
                }
            }

            if(!isNotPrime){
                System.out.print(i + "\t");
                count++;
            }

            if(lineNumber == count){
                System.out.println();
                lineNumber++;
                count = 0;
            }
        }
    }
}
