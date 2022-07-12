package by.incubator.task11;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Person[] people = createPersonArray();

        sortArrayUsingAgeComparator(people);
        showArray(people);

        sortArrayUsingNameComparator(people);
        showArray(people);

        sortArrayUsingAgeComparable(people);
        showArray(people);
    }

    private static Person[] createPersonArray() {
        Person[] people = {new Person("Bob", 10),
                new Person("Liza", 23),
                new Person("Mike", 20),
                new Person("Anna", 100),
                new Person("Tom", 30),
                new Person("Max", 5),
                new Person("Chuck", 100)};

        return people;
    }

    private static void sortArrayUsingAgeComparator(Person[] people) {
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
    }

    private static void sortArrayUsingAgeComparable(Person[] people) {
        Arrays.sort(people);
    }

    private static void sortArrayUsingNameComparator(Person[] people) {
        Arrays.sort(people, new PersonNameComparator());
    }

    private static void showArray(Person[] people) {
        for (Person person:
                people) {
            System.out.println(person);
        }

        System.out.println("-------------------------");
    }
}