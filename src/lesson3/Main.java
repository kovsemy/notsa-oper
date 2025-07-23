package lesson3;

public class Main {
    public static void main(String[] args) {

        /*
        2. Создать массив из 5 товаров.
        */
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product(
                "Samsung S25 Ultra",
                "01.02.2025",
                "Samsung Corp.",
                "Korea",
                5599,
                true
        );
        productsArray[1] = new Product(
                "iPhone 16 Pro Max",
                "15.09.2025",
                "Apple Inc.",
                "USA",
                6999,
                true
        );
        productsArray[2] = new Product(
                "Xiaomi Mi 15",
                "23.03.2025",
                "Xiaomi Corp.",
                "China",
                3499,
                false
        );
        productsArray[3] = new Product(
                "Sony Xperia Z12",
                "10.05.2025",
                "Sony Corporation",
                "Japan",
                4899,
                true
        );
        productsArray[4] = new Product(
                "Huawei P70 Pro",
                "01.04.2025",
                "Huawei Technologies",
                "China",
                5299,
                false
        );

        Park park = new Park();
        Park.ParkInner parkInner = park.new ParkInner("Ferris wheel", "10-22", 5.99);
        parkInner.printAttractionInfo();
    }
}
