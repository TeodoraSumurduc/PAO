package Task6.serialization.serializer;

import Task6.domain.Student;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;

public class RawDataStudentSerializer implements StudentSerializer {
    @Override
    public void serialize(OutputStream outputStream, Student student) {
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream))) {
            writer.print(student.getFullName());
            writer.print(",");

            Map<String, Double> courseInformation = student.getCourseInformation();
            for (Map.Entry<String, Double> entry : courseInformation.entrySet()) {
                writer.print(entry.getKey());
                writer.print(":");
                writer.print(entry.getValue());
                writer.print(",");
            }

            writer.println();
            writer.flush();
        }
    }
}