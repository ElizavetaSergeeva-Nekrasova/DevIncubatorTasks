package by.incubator.task17;

import com.sun.istack.internal.NotNull;

import javax.xml.ws.soap.Addressing;
import java.lang.annotation.Native;

public class Person implements ExampleInterface{

    @NotNull
    @Addressing
    private String name;

    @Native
    @NotNull
    protected int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void a() {
    }

    @Override
    public void b(String s) {
    }

    @Override
    public String c(int i) {
        return null;
    }

    public void showInfo() {
        System.out.println("This is a person");
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
}