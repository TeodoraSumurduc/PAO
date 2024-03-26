package Task3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> originalCourseInfo = new HashMap<>();
        originalCourseInfo.put("Matematica", 9.5);
        originalCourseInfo.put("Fizica", 8.7);
        //am facut un student nou cu cursurile si notele definite mai sus
        Student originalStudent = new Student("Popescu Ion", originalCourseInfo);
        //am clonat studentul
        Student clonedStudent = (Student) originalStudent.clone();
        //in clona am adaugat un curs nou
        clonedStudent.addCourseInformation("Chimie", 7.8);

        System.out.println("Informații despre studentul original:");
        System.out.println(originalStudent);

        System.out.println("Informații despre studentul clonat:");
        System.out.println(clonedStudent);
    }
}
