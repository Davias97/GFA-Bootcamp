package greenfoxinheritanceexercise;

public class Person {

    protected String name = "Jane Doe";
    protected int age = 30;
    protected String gender = "female";

    public void getGoal() {
        System.out.println("My goal is: Live for the moment!");
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + ".");
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Person() {

    }
}
