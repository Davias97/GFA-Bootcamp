package greenfoxinheritanceexercise;

public class Student extends Person {
    private String previousOrganization = "The School of Life";
    private int skippedDays = 0;

    public void getGoal() {
        System.out.println("Be a junior software developer.");
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + " from " + previousOrganization + " who skipped " + skippedDays + " days from the course already.");
    }

    public void skipDays(int numberOfDays) {
        this.skippedDays += numberOfDays;
    }

    public Student(String name, int age, String gender, String previousOrganization) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.previousOrganization = previousOrganization;
        this.skippedDays = 0;
    }

    public Student() {

    }
}
