import java.util.*;
import java.util.stream.Collectors;

public class Lesson6 {
    public static void main(String[] args) {
        // Task 1
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alex", "10A", 1, 4));
        students.add(new Student("Jack", "20A", 2, 2));
        students.add(new Student("John", "20B", 2, 1));
        students.add(new Student("Victor", "30A", 3, 5));

        System.out.println("initial list: " + students);
        removeStudentsWithGradeLessThree(students);
        promoteStudentsWithGradeAtLeastThree(students);
        printStudents(students, 4);

        // Task 2
        PhoneBook.add("Black", "+37521");
        PhoneBook.add("White", "+37521");
        PhoneBook.add("Black", "+37522");
        PhoneBook.getNumberByLastName("Black");
        PhoneBook.getNumberByLastName("White");
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

    public static void printStudents(List<Student> students, int course) {
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }
}

/**
Задание 1
Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
Создайте коллекцию, содержащую объекты класса Student. Следует написать метод, который удаляет студентов со средним баллом < 3,
а также отдельный метод, который переводит студента на следующий курс, если средний балл >= 3.
Напишите метод printStudents(Set<Student> students, int course), который получает список студентов и номер курса.
Метод печатает на консоль имена тех студентов, которые обучаются на данном курсе.
*/
class Student {
    private String name;
    private String group;
    private int course;
    private int grade;

    public Student(String name, String group, int course, int grade) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public int getGrade() {
        return this.grade;
    }

    public int getCourse() {
        return this.course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("%s (Group: %s, Course: %d, Grade: %d)", name, group, course, grade);
    }
}

/**
Задание 2
Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
*/
class PhoneBook {
    private static Map<String, List<String>> phoneBookMap = new HashMap<>();
    private static Set<String> uniquePhoneNumbers = new HashSet<>();

    public static void add(String lastName, String phoneNumber) {
        if (uniquePhoneNumbers.contains(phoneNumber)) {
            System.out.printf("%s уже есть в базе:)%n", phoneNumber);
        } else {
            phoneBookMap.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
            uniquePhoneNumbers.add(phoneNumber);
            System.out.printf("%s добавлен для %s%n", phoneNumber, lastName);
        }
    }

    public static void getNumberByLastName(String lastName) {
        if (phoneBookMap.containsKey(lastName)) {
            System.out.printf("У %s номера: %s%n", lastName, phoneBookMap.get(lastName));
        } else {
            System.out.printf("Фамилии (%s) нет в справочнике:(%n", lastName);
        }
    }
}