package counter;


public class Counter {

    int counter = 0;

    public Counter() {

    }

    public Counter(int number) {

        this.counter = number;

    }

    public void add(int number) {
        counter += number;
    }

    public void add() {
        counter += 1;
    }

    public void reset() {
        counter = 0;
    }

    public int get() {
        return counter;
    }
}
