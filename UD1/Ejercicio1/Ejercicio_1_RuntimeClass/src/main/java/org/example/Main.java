package org.example;

public class Main {
    public static void main(String[] args) {
        //create a program to obtain the number of available processors for the java virtual machine
        int n = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors: " + n);

        //launch google Chrome browser
        try {
            Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        //launch youtube on the google Chrome browser
        try {
            Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe https://www.youtube.com/");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        //launch notepad
        try {
            Runtime.getRuntime().exec("notepad");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}