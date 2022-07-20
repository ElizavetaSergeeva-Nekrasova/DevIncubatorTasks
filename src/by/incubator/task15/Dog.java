package by.incubator.task15;

public class Dog {
    String name;
    int age;
    double weight;

    public Dog(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + ", "
                + age + ", "
                + weight;
    }
}
