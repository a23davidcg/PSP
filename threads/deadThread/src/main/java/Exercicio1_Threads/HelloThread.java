package Exercicio1_Threads;

public class HelloThread extends Thread {

    @Override
    public void run() {
        Thread.currentThread().setName("Welcome Thread");
        System.out.println("Hello " + getName());
    }
}
