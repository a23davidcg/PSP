package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //implements a program to take two numbers from comand line

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();


        //show all even numbers brtween a and b both inclusive

        for (int i = a; i <= b; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }

        }


    }
}