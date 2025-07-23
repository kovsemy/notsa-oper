package lesson3;

/**
 3. Создать класс Park с внутренним классом, с помощью объектов которого
 можно хранить информацию об аттракционах, времени их работы и стоимости.
 */
public class Park {
    class ParkInner {
        private String attraction;
        private String openingHours;
        private double price;

        public ParkInner(String attraction, String openingHours, double price) {
            this.attraction = attraction;
            this.openingHours = openingHours;
            this.price = price;
        }

        public void printAttractionInfo() {
            System.out.println("Аттракцион: " + attraction);
            System.out.println("Время работы: " + openingHours);
            System.out.println("Цена: " + price + "$");
        }
    }
}
