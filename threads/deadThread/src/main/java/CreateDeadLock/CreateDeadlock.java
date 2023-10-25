package CreateDeadLock;

public class CreateDeadlock {
    public static void main(String[] args) {
        final String resource1 = "Resource 1";
        final String resource2 = "Resource 2";
        // Thread 1 tries to lock Resource 1 and then Resource 2
        Thread t1 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1: I have locked Resource 1");
                    try { Thread.sleep(50);} catch (Exception e) {}
                    synchronized (resource2) {
                        System.out.println("Thread 1: I have locked Resource 2"); }
                }
            }
        };
// Thread 2 tries to lock Resource 2 then Resource 1
        Thread t2 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2: I have locked Resource 2 ");
                    try { Thread.sleep(50);} catch (Exception e) {}
                    synchronized (resource1) {
                        System.out.println("Thread 2: I have locked Resource 2");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}