package lesson6.task2;

import java.util.*;

/**
 Задание 2
 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
 Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 */
public class PhoneBook {
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
