package Exercicio5_Wait;

public class MainExercicio5 {
    public static void main(String[] args) {
        //Shared message object between Reader and Writer threads.
        Buzon message = new Buzon();

        Thread writer = new Thread(String.valueOf(new MessageWriter(message)));


        Thread reader = new Thread(new Carteiro(message));

       writer.start();
       reader.start();
    }
}

