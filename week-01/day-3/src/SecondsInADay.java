public class SecondsInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        // Write a program that prints the remaining seconds (as an integer) from a
        // day if the current time is represented by the variables above
        int totalSeconds = 86400;
        int totalCurrentSeconds = 52482;
        System.out.println(totalSeconds-totalCurrentSeconds);
    }
}