package Exercicio5_Wait;

import java.util.Random;

public class MessageWriter {
    private Buzon buzon;

    public MessageWriter(Buzon buzon) {
        this.buzon = buzon ;
    }

    public void run() {
        String messages[] = {
                "The threads can communicate with each other through wait(), notify()" +
                        "and notifyAll()methods in Java.',' These are final methods defined in the Object class" +
                        " and can be called only from within a synchronized context.',' The wait () method causes" +
                        "the current thread to wait until another thread invokes the notify() or notifyAll ()" +
                        "methods for that object.',' The notifyAll () method wakes up all threads that arewaiting on that object 's monitor.',' A thread waits on an object' s monitor by calling " +
                        "one of the wait () method." };

        Random random = new Random();
        for (int i = 0; i < messages.length; i++) {
            buzon.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Writer Thread Interrupted!!!");
            }
        }
        buzon.write("Finished!");
 }


    }