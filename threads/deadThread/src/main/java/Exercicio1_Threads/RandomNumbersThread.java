package Exercicio1_Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbersThread extends Thread{

    public RandomNumbersThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        System.out.println("Hello " + getName());

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
        System.out.println("Terminated " + getName());

    }
}
