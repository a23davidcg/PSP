package Exercicio2_Threads;

import java.util.Random;

public class RandomNumberGuesser extends Thread {
    private HiddenNumber hiddenNumber;

    public RandomNumberGuesser(HiddenNumber hiddenNumber){
        this.hiddenNumber = hiddenNumber;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true){
            int numero = random.nextInt(0, 101);
            int resultado = this.hiddenNumber.numberGuess(numero);

            if (resultado != 0) {
                break;
            }
        }
    }
}

