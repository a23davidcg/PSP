package org.example;

public class ThreadChild extends Thread{


    final private String name;

    public ThreadChild(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("hello, i am " + this.name);
    }
}
