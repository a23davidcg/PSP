package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");

        Thread th1 = new Thread(new newThread1());
        Thread th2 = new Thread(new newThread1());
        th1.start();
        th2.start();
        System.out.println("main Thread finished");

        //trabajar de forma anonima

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("im another thread");
            }
        };
        new Thread(r1).start();//Sempre usar o .start non o run porque da problemas

        Runnable r2 = new Runnable() {
            Runnable r2 = () ->
                System.out.println("hello lambda");
            };
            new Thread(r2).start();



    }

}