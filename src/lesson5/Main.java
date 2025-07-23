package lesson5;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"4", "4", "2", "f"},
                {"2", "s", "w", "1"},
                {"2", "s", "w", "1"},
                {"2", "s", "w", "1"}
        };

        /*
        3. В методе main() вызвать полученный метод, обработать возможные
        исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.
        */
        try {
            countArrayElements(arr);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        // 4. Напишите код для генерации и поимки ArrayIndexOutOfBoundsException (надеюсь не ужасно)
        try {
            arr[10][0] = "oops";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    /*
    1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    */
    public static void countArrayElements(String[][] arr) {
        if (arr.length != 4) {
            throw new MyArraySizeException("Массив должен иметь размер 4x4");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != 4) {
                    throw new MyArraySizeException("Массив должен иметь размер 4x4");
                }
            }
        }

        /*
        2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
        Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
        должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
         */
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В ячейке [%d][%d] лежит не число%nСумма до ошибки: %d", i, j, sum));
                }
            }
        }
        System.out.println(sum);
    }
}
