package lesson4.task1;

public abstract class Animal {
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
