package by.incubator.task9;

public class Main {
    static Animal[] herd;
    static Horse horse;
    static Kangaroo kangaroo;
    static Dragonfly dragonfly;

    public static void main(String[] args) {
        createArrayOfAnimals();
        createThreeAnimals();

        getVoicesOfAnimalsArray();
        getVoicesOfThreeAnimals();
        getMovesOfAnimalsArray();
        getMovesOfThreeAnimals();
        getIsHungryInfoOfAnimalsArray();
        getIsHungryInfoOfThreeAnimals();
    }

    private static void createArrayOfAnimals() {
        herd = new Animal[7];
        herd[0] = new Horse("Horse", 4, false);
        herd[1] = new Horse("Horse 2", 4, false);
        herd[2] = new Kangaroo("Kangaroo", 4, false);
        herd[3] = new Kangaroo("Kangaroo 2", 4, false);
        herd[4] = new Dragonfly("Dragonfly", 6, true);
        herd[5] = new Dragonfly("Dragonfly 2", 6, true);
        herd[6] = new Animal("Unknown type", 10, true){};
    }

    private static void createThreeAnimals() {
        horse = new Horse("Horse 3", 4, false);
        kangaroo = new Kangaroo("Kangaroo 3", 4, false);
        dragonfly = new Dragonfly("Dragonfly 3", 6, true);
    }

    private static void getVoicesOfAnimalsArray() {
        for (Animal animal:
             herd) {
            animal.voice();
        }
    }

    private static void getVoicesOfThreeAnimals() {
        horse.voice();
        kangaroo.voice();
        dragonfly.voice();
    }

    private static void getMovesOfAnimalsArray() {
        for (Animal animal:
                herd) {
            animal.move();
        }
    }

    private static void getMovesOfThreeAnimals() {
        horse.move();
        kangaroo.move();
        dragonfly.move();
    }

    private static void getIsHungryInfoOfAnimalsArray() {
        for (Animal animal:
                herd) {
            animal.isHungry();
        }
    }

    private static void getIsHungryInfoOfThreeAnimals() {
        horse.isHungry();
        kangaroo.isHungry();
        dragonfly.isHungry();
    }
}