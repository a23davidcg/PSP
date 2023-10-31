package Exercicio5_Wait;

import java.util.Random;

public class Carteiro implements Runnable {
    private Buzon buzon;

    public Carteiro(Buzon buzon) {
        this.buzon = buzon;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String latestMessage = buzon.read(); !"Finished!".equals(latestMessage);
             latestMessage = buzon.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Reader Thread Interrupted!!!");
            }
        }
    }
}
