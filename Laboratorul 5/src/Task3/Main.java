package Task3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/*
 *
 *  ¨¨¨¨¨¨¨¨¨¨*
 *  ¨¨¨¨¨¨¨¨¨**
 *  ¨¨¨¨¨¨¨¨¨*o*
 *  ¨¨¨¨¨¨¨¨*☺*o*
 *  ¨¨¨¨¨¨¨***o***
 *  ¨¨¨¨¨¨**o**☺*o*
 *  ¨¨¨¨¨**☺**o**o**
 *  ¨¨¨¨**o**☺***☺*o*                 ECHIPA OOP vă urează un Crăciun fericit,
 *  ¨¨¨*****☺*o**o****                      și un AN NOU fără restanțe!
 *  ¨¨**☺**o*****o**☺**
 *  ¨void*o*void*o*void*o*
 *  ****o***☺**o***o***☺*
 *  ¨¨¨¨¨____!_!____
 *  ¨¨¨¨¨\_________/¨¨
 *
 */


// TODO: Discuss with the teaching assistant why it was necessary to use a bounded type: < T extends Comparable<T>>
class Node<T extends Comparable<T>> {

    private T value;
    Node<T> right;
    Node<T> left;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

// TODO: Discuss with the teaching assistant why it was necessary to use a bounded type: < T extends Comparable<T>>
interface Tree<T extends Comparable<T>> {

    void addValue(T value);

    void addAll(List<T> values);

    HashSet<T> getValues(T inf, T sup);

    int size();

    boolean isEmpty();


}

//TODO: Add your implementation
class TreeImpl<T extends Comparable<T>> implements Tree<T> {
    Node<T> root;
    int size;
    private Node<T> addNode(Node<T> current, T value) {
        if (current == null) {
            //am gasit un loc liber si am creat un element nou
            return new Node<>(value);
        }

        if (value.compareTo(current.getValue()) < 0) {
            ///adaugam in subarborele stand
            current.left = addNode(current.left, value);
        } else if (value.compareTo(current.getValue()) > 0) {
            ///adaugam in subarborele drept
            current.right = addNode(current.right, value);
        }

        return current;
    }
    private void getValuesRecursive(Node<T> current, T inf, T sup, HashSet<T> resultSet) {
        if (current != null) {
            if (current.getValue().compareTo(inf) >= 0 && current.getValue().compareTo(sup) <= 0) {
                resultSet.add(current.getValue());
            }
            if (current.getValue().compareTo(inf) > 0) {
                getValuesRecursive(current.left, inf, sup, resultSet);
            }
            if (current.getValue().compareTo(sup) < 0) {
                getValuesRecursive(current.right, inf, sup, resultSet);
            }
        }
    }
    @Override
    public void addValue(T value) {
        root = addNode(root, value);
        size++;
    }

    @Override
    public void addAll(List<T> values) {
        for(T v: values)
            addValue(v);
    }

    @Override
    public HashSet<T> getValues(T inf, T sup) {
        HashSet<T> res = new HashSet<>();
        getValuesRecursive(root, inf, sup,res);
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}

class Student implements Comparable<Student> {
    private final Float grade;

    public Student(Float grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student student) {
        return this.grade.compareTo(student.grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                '}';
    }
}

public class Main {

    private static Integer testNr = 0;

    public static void main(String[] args) {

        final Tree<Student> tree = new TreeImpl<>();
        final List<Student> studentList = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            studentList.add(createGenericStudent((float) i));
        }

        printTestNr(); // 1
        System.out.println(tree.isEmpty());
        System.out.println(tree.size());
        System.out.println();

        printTestNr(); // 2
        for (int i = 0; i < 5; i++) {
            tree.addValue(createGenericStudent((float) i));
        }
        System.out.println(tree.size());
        System.out.println();

        printTestNr(); // 3
        tree.addAll(studentList);
        System.out.println(tree.isEmpty());
        System.out.println(tree.size());
        System.out.println();

        printTestNr(); // 4
        final Student studentThatPassedExam = new Student(5.0f);
        final Student studentThatWorkedHardToPassTheExam = new Student(10.0f);
        final HashSet<Student> values = tree.getValues(studentThatPassedExam, studentThatWorkedHardToPassTheExam);
        System.out.println(values.size());
        values.stream().sorted().forEach(System.out::println);
    }

    private static void printTestNr() {
        System.out.println("TEST " + ++testNr + " result:");
    }

    private static Student createGenericStudent(final Float grade) {
        return new Student(grade);
    }
}