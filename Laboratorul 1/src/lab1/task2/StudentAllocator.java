package lab1.task2;

public class StudentAllocator {
    public StudentAllocator() {
    }

    @Override
    public String toString() {
        return "StudentAllocator{}";
    }

    public static Student[] createStudents(int nrStudents){
        Student[] students = new Student[nrStudents];

        for (int i = 0; i < nrStudents; i++) {
            students[i] = new Student("Student " + (i + 1), (i+1)%11); // Example data: student name "Student 1", grade 7.5
        }

        return students;
    }
}
