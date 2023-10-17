package Exercicio1_Threads;

public class GoodByeThread extends Thread{
    @Override
    public void run() {
        Thread.currentThread().setName("Bye Thread");
        System.out.println("See you soon " + getName());
    }
}
