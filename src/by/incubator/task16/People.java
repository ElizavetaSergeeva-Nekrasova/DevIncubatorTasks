package by.incubator.task16;

public class People {
    private String name;
    private double age;
    private Sex sex;

    public People(String name, double age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "[" +
                "{" +
                "name = " + name + ", " +
                "age = " + age + ", " +
                "sex = " + sex +
                "}" +
                "]";
    }
}
