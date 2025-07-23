package lesson4.task1;

public class Dog extends Animal {
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
