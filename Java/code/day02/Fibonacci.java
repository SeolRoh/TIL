package com.example;

public class Fibonacci {
    public static void main(String[] args) {
        int previousNumber = 1;
        int nextNumber = 1;
        int currentNumber = 0;
        int cnt = 0;
        System.out.println(previousNumber);
        System.out.println(nextNumber);

        while (currentNumber < 1000){
            currentNumber = previousNumber + nextNumber;
            System.out.println(currentNumber);
            previousNumber = nextNumber;
            nextNumber = currentNumber;
            ++cnt ;
        }
        System.out.println(cnt);
    }
}
