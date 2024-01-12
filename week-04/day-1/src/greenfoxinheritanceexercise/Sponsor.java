package greenfoxinheritanceexercise;

public class Sponsor extends Person {
    private String company = "Google";
    private int hiredStudents = 0;

    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + " who represents " + company + " and hired " + hiredStudents + " students so far.");
    }

    public void hire() {
        this.hiredStudents += 1;
    }

    public void getGoal() {
        System.out.println("Hire brilliant junior software developers.");
    }

    public Sponsor(String name, int age, String gender, String company) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.company = company;
        this.hiredStudents = 0;
    }

     public Sponsor() {

     }
}
