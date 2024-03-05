package lab1.task2;

import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Course {
    private String name;
    private double minimumGrade;
    private Student[] students;

    public Course(String name, double minimumGrade, Student[] students)
    {
        this.students=students;
        this.minimumGrade=minimumGrade;
        this.name=name;
    }

    public Student chooseStudentRandomly(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(students.length);
        return students[randomIndex];
    }

    public Student[] showAllPassingStudents(){
        int cnt = 0;
        for(int i=0;i<students.length;i++)
        {
            if(students[i].getGrade()>=minimumGrade)
                cnt++;
        }
        Student[] goodStudents = new Student[cnt];

        int k = 0;
        for(int i=0;i<students.length;i++)
        {
            if(students[i].getGrade()>=minimumGrade)
            {
                goodStudents[k] = students[i];
                k++;
            }
        }

        return goodStudents;
    }

    public boolean isStudentPassing(int index) {
        if (index >= 0 && index < students.length) {
            return students[index].getGrade() >= minimumGrade;
        }
        return false;
    }

    public boolean isStudentPassing(Student student) {
        for (Student s : students) {
            if (s.equals(student)) {
                return s.getGrade() >= minimumGrade;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinimumGrade() {
        return minimumGrade;
    }

    public void setMinimumGrade(double minimumGrade) {
        this.minimumGrade = minimumGrade;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", minimumGrade=" + minimumGrade +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
