package lesson4.task1;

public class Bowl {
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
            System.out.println("В миску добавлено: " + amountOfFood + "г.");
            this.amountOfFood += amountOfFood;
        }
    }
}
