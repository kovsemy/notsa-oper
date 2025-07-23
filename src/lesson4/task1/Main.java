package lesson4.task1;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Славик");
        Cat cat2 = new Cat("Виталик");
        Dog dog = new Dog("Кирилл");
        Cat.count();
        Dog.count();
        Animal.count();
        System.out.println();

        Bowl bowl = new Bowl(10);
        bowl.addFood(10);
        System.out.println();

        cat1.eatFromBowl(bowl, 4);
        cat1.eatFromBowl(bowl, 1);
        cat1.eatFromBowl(bowl, 2);
        System.out.println();

        Cat[] cats = new Cat[10];

        for (int i = 0; i < cats.length; i++) {
            int randomPortion = (int) (Math.random() * 6);

            cats[i] = new Cat("Дымок" + i);
            cats[i].eatFromBowl(bowl, randomPortion);
        }
    }
}
