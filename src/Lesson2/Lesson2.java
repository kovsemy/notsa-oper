package Lesson2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        printThreeWords(); // 1
        checkSumSign(); // 2
        printColor(); // 3
        compareNumbers(); // 4
        isSumInRange(14,6); // 5
        printIsPositive(0); // 6
        isNegative(0); // 7
        repeatPrintString("привет подписочники:_)", 3); // 8
        isLeapYear(2000); // 9
        printFlipArray(); // 10
        fillEmptyArray(); // 11
        multiplyArrayValues(); // 12
        drawArray(); // 13
        getNewArray(5, 10); // 14
    }

    /**
    1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple
     */
    static void printThreeWords() {
        System.out.println("Orange" + "\n" + "Banana" + "\n" + "Apple");
    }

    /**
    2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми
    значениями, которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0,
    то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
     */
    static void checkSumSign() {
        int a = 0;
        int b = 1;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    /**
    3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
    Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах
    от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
     */
    static void printColor() {
        int value = 0;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    /**
    4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми
    значениями, которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”,
    в противном случае “a < b”;
     */
    static void compareNumbers() {
        int a = 0;
        int b = 1;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    /**
    5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
    от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     */
    static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
           return true;
        }
        return false;
    }

    /**
    6. Напишите метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом.
    */
    static void printIsPositive(int a) {
        if (a >= 0) {
            System.out.println(a + " положительное число");
        } else {
            System.out.println(a + " отрицательное число");
        }
    }

    /**
    7. Напишите метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    Замечание: ноль считаем положительным числом.
     */
    static boolean isNegative(int a) {
        return a < 0;
    }

    /**
    8. Напишите метод, которому в качестве аргументов передается строка и число,
    метод должен отпечатать в консоль указанную строку, указанное количество раз.
     */
    static void repeatPrintString(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    /**
    9. Напишите метод, который определяет, является ли год високосным,
    и возвращает boolean (високосный - true, не високосный - false).
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
    10. Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0.
     */
    static void printFlipArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
    11. Задать пустой целочисленный массив длиной 100.
    С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100.
     */
    static void fillEmptyArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
    12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2.
     */
    static void multiplyArrayValues() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
    13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
    Определить элементы одной из диагоналей можно по следующему принципу:
    индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
     */
    static void drawArray() {
        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j == i || j + i == arr.length - 1) {
                    arr[i][j] = 1;
                    System.out.print("1 ");
                } else {
                    arr[i][j] = 0;
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    /**
    14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий
    одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
     */
    static int[] getNewArray(int len, int initialValue) {
        int[] newArray = new int[len];
        Arrays.fill(newArray, initialValue);
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }
}