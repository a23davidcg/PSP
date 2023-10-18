package Counter;

public class Counter {
    private int count = 0;

    synchronized public int getCount() {
        return count;
    }

    synchronized public int increase() {
        this.count++;
        return count;

    }
}
