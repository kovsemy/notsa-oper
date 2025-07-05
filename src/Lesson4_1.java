public class Lesson4_1 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Славик");
        Cat cat2 = new Cat("Виталик");
        Dog dog = new Dog("Кирилл");
        Cat.count();
        Dog.count();
        Animal.count();

        Bowl bowl = new Bowl(10);
        bowl.addFood(10);

        cat1.eatFromBowl(bowl, 4);
        cat1.eatFromBowl(bowl, 1);
        cat1.eatFromBowl(bowl, 2);

        Cat[] cats = new Cat[10];

        for (int i = 0; i < cats.length; i++) {
            int randomPortion = (int) (Math.random() * 6);

            cats[i] = new Cat("Дымок" + i);
            cats[i].eatFromBowl(bowl, randomPortion);
        }
    }
}

class Bowl {
    private int amountOfFood;

    // По умолчанию в тарелку меньше 0 не попадет)
    public Bowl() {
        this.amountOfFood = 0;
    }

    public Bowl(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }

    public void setAmountOfFood(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public boolean canTakeFood(int foodPortion) {
        return this.amountOfFood > 0 && this.amountOfFood >= foodPortion;
    }

    public void addFood(int amountOfFood) {
        if (amountOfFood <= 0) {
            System.out.println("А где еда то? Ничего ж не положили..");
        } else {
            System.out.println("В миску добавлено: " + amountOfFood);
            this.amountOfFood += amountOfFood;
        }
    }
}

abstract class Animal {
    private String name;
    private static int count;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public String getName() {
        return this.name;
    }

    public static void count() {
        System.out.println("Животных: " + count);
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
}

class Cat extends Animal {
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

class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500;
    public static final int MAX_SWIM_DISTANCE = 10;
    private static int count;

    public Dog(String name) {
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
        if (distance > MAX_SWIM_DISTANCE) {
            System.out.println(getName() + " не может проплыть больше " + MAX_SWIM_DISTANCE + " м.");
        }
        System.out.println(getName() + " проплыл " + distance + " м.");
    }

    public static void count() {
        System.out.println("Собак: " + count);
    }
}
