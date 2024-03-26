package Task6.serialization.deserializer;

import Task6.domain.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RawDataStudentDeserializer implements StudentDeserializer{
    @Override
    public Student deserializer(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            if (line != null) {
                String[] tokens = line.split(",");
                String fullName = tokens[0];
                Student student = new Student(fullName);

                for (int i = 1; i < tokens.length; i++) {
                    String[] courseInfo = tokens[i].split(":");
                    String courseName = courseInfo[0];
                    double grade = Double.parseDouble(courseInfo[1]);
                    student.addCourseInformation(courseName, grade);
                }

                return student;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}