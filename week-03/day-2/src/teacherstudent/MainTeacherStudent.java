package teacherstudent;

public class MainTeacherStudent {
    public static void main(String[] args) {

    Student student = new Student();
    Teacher teacher = new Teacher();

    student.question(teacher);
    teacher.teach(student);

    }
}
