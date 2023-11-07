package Exercicio5_Wait;

public class Buzon {
    String message;
    boolean empty = true;

    //Method used by reader
    public synchronized String read() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "Interrupted.");
            }
        }

        empty = true;//Reader reads the message and marks empty as true.

        notifyAll();
        return message;//Reader reads the message.
    }

    //Method used by writer
    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "Interrupted.");
            }
        }
        this.message = message;//Writer writes the message.
        empty = false;//Now make empty as false.

        notifyAll();
    }
}

