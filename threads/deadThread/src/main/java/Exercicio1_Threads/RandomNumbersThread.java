package Exercicio1_Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbersThread extends Thread{

    @Override
    public void run() {

        Thread.currentThread().setName("RandomThread Start: ");

        Random numerosAleatorios = new Random();

        for( int i = 0; i < 5; i ++){
            int numeros = numerosAleatorios.nextInt(10, 500);
            System.out.println(numeros);
            try {
                this.sleep(numeros);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //System.out.println(getName() + "Terminated ");
    }
}
