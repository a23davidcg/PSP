package Exercicio5_Wait;

public class MainExercicio5 {
    public static void main(String[] args) {
        //Shared message object between Reader and Writer threads.


        Buzon buzon = new Buzon();

        Thread writer = new Thread(new Escritor(buzon));

        Thread reader = new Thread(new Carteiro(buzon));

//        for (int i = 0; i <20; i++){
//            Thread comprador = new Thread(new Comprador(vendedor));
//            comprador.start();
//        }

       writer.start();
       reader.start();
    }
}

