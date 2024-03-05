package lab1.task1;

import lab1.task2.Course;
import lab1.task2.Student;
import lab1.task2.StudentAllocator;
import lab1.task4.DummyCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create a list of a students
        Student[] studs = StudentAllocator.createStudents(11);

        //create a new course
        Course a= new Course("math",5,studs);

        //print aa random student
        System.out.println(a.chooseStudentRandomly());

        ////print all pasing students from the list
        Student[] passingStudents = a.showAllPassingStudents();
        for(Student s:passingStudents)
            System.out.println(s);


        //see if a student is passing
        System.out.println(a.isStudentPassing(6));

        //the calculate function
        new DummyCalculator().calculate(args);
    }
}


