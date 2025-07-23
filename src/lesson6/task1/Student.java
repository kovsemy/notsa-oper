package lesson6.task1;

/**
 Задание 1
 Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
 Создайте коллекцию, содержащую объекты класса Student. Следует написать метод, который удаляет студентов со средним баллом < 3,
 а также отдельный метод, который переводит студента на следующий курс, если средний балл >= 3.
 Напишите метод printStudents(Set<Student> students, int course), который получает список студентов и номер курса.
 Метод печатает на консоль имена тех студентов, которые обучаются на данном курсе.
 */
public class Student {
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
