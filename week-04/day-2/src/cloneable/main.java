package cloneable;

public class main {
    public static void main(String[] args) {

        Student john = new Student("John", 20, "male", "BME");

        Student johnTheClone = john.clone();

        System.out.println(johnTheClone.name);
    }
}
