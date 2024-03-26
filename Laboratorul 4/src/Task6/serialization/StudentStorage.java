package Task6.serialization;

import Task6.domain.Student;
import Task6.serialization.deserializer.StudentDeserializer;
import Task6.serialization.serializer.StudentSerializer;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class StudentStorage {
    private final StudentSerializer serializer;
    private final StudentDeserializer deserializer;

    public StudentStorage(StudentSerializer serializer, StudentDeserializer deserializer) {
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    public List<Student> readAllStudents(InputStream inputStream) {
        List<Student> students = new ArrayList<>();
        try {
            Student student;
            while ((student = deserializer.deserializer(inputStream)) != null) {
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Tratam exceptia sau o afisam
        }
        return students;
    }

    public void writeAllStudents(OutputStream outputStream, List<Student> students) {
        try {
            // Folosim serializer-ul pentru a scrie fiecare student in fluxul de iesire
            for (Student student : students) {
                serializer.serialize(outputStream, student);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Tratam exceptia sau o afisam
        }

    }
}