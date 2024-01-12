package counter;

public class MainCounter {
    public static void main(String[] args) {

        Counter number1 = new Counter();
        number1.add(200);
        number1.reset();
        System.out.println(number1.counter);


    }
}
