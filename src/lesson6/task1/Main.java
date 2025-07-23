package lesson6.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alex", "10A", 1, 4));
        students.add(new Student("Jack", "20A", 2, 2));
        students.add(new Student("John", "20B", 2, 1));
        students.add(new Student("Victor", "30A", 3, 5));

        System.out.println("initial list: " + students);
        removeStudentsWithGradeLessThree(students);
        promoteStudentsWithGradeAtLeastThree(students);
        printStudentsByCourse(students, 4);
    }

    public static void removeStudentsWithGradeLessThree(List<Student> students) {
        students.removeIf(student -> student.getGrade() < 3);
        System.out.println("list after remove: " + students);
    }

    public static void promoteStudentsWithGradeAtLeastThree(List<Student> students) {
        students.stream()
                .filter(student -> student.getGrade() >= 3)
                .forEach(student -> student.setCourse(student.getCourse() + 1));
    }

    public static void printStudentsByCourse(List<Student> students, int course) {
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }
}
