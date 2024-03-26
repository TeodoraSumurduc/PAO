package Task3;

import java.util.HashMap;
import java.util.Map;

public class Student implements Cloneable {
    private String fullName;
    private Map<String, Double> courseInformation;

    public Student(String fullName, Map<String, Double> courseInformation) {
        this.fullName = fullName;
        this.courseInformation = courseInformation;
    }

    @Override
    public Object clone() {
        try {
            Student cloned = (Student) super.clone();
            cloned.courseInformation = new HashMap<>(this.courseInformation);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nume student: ").append(fullName).append("\n");
        sb.append("Numele cursurilor si nota:\n");
        for (Map.Entry<String, Double> entry : courseInformation.entrySet()) {
            sb.append("- ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    public void addCourseInformation(String courseName, double grade) {
        courseInformation.put(courseName, grade);
    }

    public Map<String, Double> getCourseInformation() {
        return courseInformation;
    }

    public String getFullName() {
        return fullName;
    }
}

