package Paxina7;

public class LaunchSeveralInfoThreads {
    public static void main(String[] args) {
        // main thread
        Thread.currentThread().setName("Main");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());

        //Creacion de dous grupos un para os threads pares e outro para os impares
        ThreadGroup even = new ThreadGroup("Even threads");
        ThreadGroup odd = new ThreadGroup("Odd threads");
        Thread localThread = null;
        for (int i=0; i<10; i++) {//Vaise creando threads par ou impar e vainos metendo no grupo que lle corresponde
            localThread = new Thread((i%2==0)?even:odd, new InfoThread(),"Thread"+i); //Ponselle nome ata o thread 9
            localThread.setPriority(i+1); //As prioridades comezan en 1, en función desto vanse execuar antes ou despis
            localThread.start();//Daselle inicio as prioridades
        }
        try {//Esperase a que todos rematen para poñer fin ao principal e decir ao pai
            localThread.join(); // --> Will wait until last thread ends
            // like a waitFor() for processes
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            System.err.println("The main thread was interrupted while waiting for "
                    + localThread.toString() + "to finish");
        }
        System.out.println("Main thread ending");
    }
}
