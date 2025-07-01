public class Lesson3 {
    public static void main(String[] args) {
        Product p = new Product("Moloko", "20.03.25", "yashkino", "Belarus", 2.30, false);
        p.getInfo();

        // 2. Создать массив из 5 товаров.
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
        parkInner.getAttractionInfo();
    }
}

/**
1. Создать класс "Товар" с полями: название, дата производства, производитель,
страна происхождения, цена, состояние бронирования покупателем.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.
 */
class Product {
    private String name;
    private String date;
    private String manufacturer;
    private String country;
    private double price;
    private boolean booking;

    public Product(String name, String date, String manufacturer, String country, double price, boolean booking) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.booking = booking;
    }

    public void getInfo() {
        System.out.println(name + "\n" + date + "\n" + manufacturer + "\n" + country + "\n" + price + "\n" + booking);
    }
}

/**
3. Создать класс Park с внутренним классом, с помощью объектов которого
можно хранить информацию об аттракционах, времени их работы и стоимости.
 */
class Park {
    class ParkInner {
        private String attraction;
        private String openingHours;
        private double price;

        public ParkInner(String attraction, String openingHours, double price) {
            this.attraction = attraction;
            this.openingHours = openingHours;
            this.price = price;
        }

        public void getAttractionInfo() {
            System.out.println("Аттракцион: " + attraction);
            System.out.println("Время работы: " + openingHours);
            System.out.println("Цена: " + price + "$");
        }
    }
}