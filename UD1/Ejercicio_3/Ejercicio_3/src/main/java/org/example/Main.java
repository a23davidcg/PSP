package org.example;

public class Main {
    public static void main(String[] args) {
        //Create a program using directory() method from ProcessBuilder to show the default directory of execution of a process

        ProcessBuilder processBuilder = new ProcessBuilder();
        System.out.println("El directorio por defecto es: " + processBuilder.directory());


    }
}