package lesson3;

/**
 1. Создать класс "Товар" с полями: название, дата производства, производитель,
 страна происхождения, цена, состояние бронирования покупателем.
 Конструктор класса должен заполнять эти поля при создании объекта.
 Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.
 */
public class Product {
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

    public void printInfoAboutProduct() {
        System.out.printf("Название товара: %s%n" +
                "Дата производства: %s%n" +
                "Производитель: %s%n" +
                "Страна происхождения: %s%n" +
                "Цена: %.1f%n" +
                "Состояние бронирования покупателем: %b%n", name, date, manufacturer, country, price, booking);
    }
}
