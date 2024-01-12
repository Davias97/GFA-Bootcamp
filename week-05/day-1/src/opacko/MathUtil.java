package opacko;

public class MathUtil {

    // x ** y
    public double power(int x, int y) {
        double result = 1;
        for (int i = 0; i < Math.abs(y); i++) {
            result *= x;

        }
        if (y < 0) {
            result = 1 / result;
        }
        return result;
    }

    public double powerJava(int x, int y){
        return Math.pow(x, y);
    }

}