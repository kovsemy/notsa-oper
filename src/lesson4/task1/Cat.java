package lesson4.task1;

public class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200;
    private static int count;
    private boolean isHungry = true;
    private int satiety = 5;

    public Cat(String name) {
        super(name);
        count++;
    }

    @Override
    public void run(int distance) {
        if (distance > MAX_RUN_DISTANCE) {
            System.out.println(getName() + " не может пробежать больше " + MAX_RUN_DISTANCE + " м.");
        } else {
            System.out.println(getName() + " пробежал " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не хочет плавать!");
    }

    public static void count() {
        System.out.println("Котов: " + count);
    }

    public void eatFromBowl(Bowl bowl, int foodPortion) {
        // Кот сыт..
        if (!isHungry) {
            System.out.println(getName() + " сыт!");
            return;
        }

        // Не порция
        if (foodPortion <= 0) {
            System.out.println("Порция на то и проция, она должна быть больше нуля)");
            return;
        }

        // Больше нормы сытости кот есть не будет
        if (foodPortion > satiety) {
            System.out.println(getName() + " не съест больше " + satiety + "г.");
            return;
        }

        // Если в миске нет нужного количества корма
        if (!bowl.canTakeFood(foodPortion)) {
            printNotEnoughFood(foodPortion, bowl.getAmountOfFood());
            return;
        }

        // Либо кот наесться, либо порция станет слишком большой
        if (foodPortion <= satiety) {
            int currentSatiety = satiety - foodPortion;
            int inBowlAfterEat = bowl.getAmountOfFood() - foodPortion;

            bowl.setAmountOfFood(inBowlAfterEat);
            System.out.printf("%s съел %dг. Сытость: %d/%d. В миске осталось: %dг.%n",
                    getName(),
                    foodPortion,
                    currentSatiety,
                    satiety,
                    bowl.getAmountOfFood()
            );
            satiety -= foodPortion;
            isHungry = satiety > 0;
        }
    }

    private void printNotEnoughFood(int needed, int available) {
        System.out.println(getName() + " хотел съесть " + needed + ", но в миске: " + available + "г.");
    }
}
