package greenfoxinheritanceexercise;

public class Mentor extends Person {
    private String level = "intermediate";

    public void getGoal() {
        System.out.println("Educate brilliant junior software developers.");
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + " level mentor.");
    }

    public Mentor(String name, int age, String gender, String level) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.level = level;
    }

    public Mentor() {

    }
}
