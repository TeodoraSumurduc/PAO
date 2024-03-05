package lab1.task2;

public class Student {
    private String name;
    private double grade;

    public Student(String name, double grade){
        this.name=name;
        this.grade=grade;
    }
    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Grade: " + grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
