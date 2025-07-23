package lesson6.task2;

public class Main {
    public static void main(String[] args) {
        PhoneBook.add("Black", "+37521");
        PhoneBook.add("White", "+37521");
        PhoneBook.add("Black", "+37522");
        PhoneBook.getNumberByLastName("Black");
        PhoneBook.getNumberByLastName("White");
    }
}
