package by.incubator.task16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = createList();
        List<String> emptyList = Collections.emptyList();
        List<People> peopleList = createPeopleList();

        displayNumberOfA1(stringList);
        displayFirstElement(stringList);
        displayFirstElement(emptyList);
        displayThirdElement(stringList);
        displayTwoAfterSecond(stringList);
        displayByTemplate(stringList);
        displayIsA1Present(stringList);
        displayIsA7NotPresent(stringList);
        displayNumberArray(stringList);
        displayOneRow(stringList);
        Main.displaySortedStringCollection(stringList);

        displayMenLiableForAMilitaryService(peopleList);
        displayAverageMenAge(peopleList);
        displayNumberOfBodyAblePeople(peopleList);
        displayPersonWithMinAge(peopleList);
        displaySortedPeopleCollection(peopleList);
    }

    private static List<String> createList() {
        List<String> list = new ArrayList<>();
        list.add("a1");
        list.add("a2");
        list.add("a3");
        list.add("a1");

        return list;
    }

    private static List<People> createPeopleList() {
        return Arrays.asList(new People("Basil", 16, Sex.MEN),
                new People("Peter", 23, Sex.MEN),
                new People("Helen", 42, Sex.WOMEN),
                new People("Ivan", 69, Sex.MEN));
    }

    private static long getNumberOfA1(List<String> stringList) {
        return stringList
                .stream()
                .filter(element -> element.equals("a1"))
                .count();
    }

    private static void displayNumberOfA1(List<String> stringList) {
        System.out.println(getNumberOfA1(stringList));
    }

    private static String getFirstElement(List<String> stringList) {
        return stringList
                .stream()
                .findFirst()
                .orElse("0");
    }

    private static void displayFirstElement(List<String> stringList) {
        System.out.println("First element: " + getFirstElement(stringList));
    }


    private static String getThirdElement(List<String> stringList) {
        return stringList
                .stream()
                .skip(2)
                .findFirst()
                .orElse("0");
    }

    private static void displayThirdElement(List<String> stringList) {
        System.out.println(getThirdElement(stringList));
    }

    private static void displayTwoAfterSecond(List<String> stringList) {
        stringList
                .stream()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);
    }

    private static void displayByTemplate(List<String> stringList) {
        List<String> list =
                stringList
                        .stream()
                        .filter(element -> element.equals("a1"))
                        .collect(Collectors.toList());

        System.out.println(list);
    }

    private static boolean isA1Present(List<String> stringList) {
        return stringList
                .stream()
                .anyMatch(element -> element.equals("a1"));
    }

    private static void displayIsA1Present(List<String> stringList) {
        System.out.println(isA1Present(stringList));
    }

    private static boolean isA7NotPresent(List<String> stringList) {
        return !(stringList
                .stream()
                .anyMatch(element -> element.equals("a7"))
                );
    }

    private static void displayIsA7NotPresent(List<String> stringList) {
        System.out.println(isA7NotPresent(stringList));
    }

    private static Integer[] getNumberArray(List<String> stringList) {
        return stringList
                .stream()
                .map(element -> Integer.parseInt(element.substring(1)))
                .toArray(Integer[]::new);
    }

    private static void displayNumberArray(List<String> stringList) {
        System.out.println(Arrays.toString(getNumberArray(stringList)));
    }

    private static String getOneRow(List<String> stringList) {
        return stringList
                .stream()
                .reduce((accumulator, element) -> accumulator + element)
                .get();
    }

    private static void displayOneRow(List<String> stringList) {
        System.out.println(getOneRow(stringList));
    }

    private static List<String> sortCollection(List<String> stringList) {
        return stringList
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static void displaySortedStringCollection(List<String> stringList) {
        System.out.println(sortCollection(stringList));
    }

    private static People findMenLiableForAMilitaryService(List<People> peopleList) {
        return peopleList
                .stream()
                .filter(people -> people.getAge() >= 18 && people.getAge() < 27)
                .collect(Collectors.toList())
                .get(0);
    }

    private static void displayMenLiableForAMilitaryService(List<People> peopleList) {
        System.out.println(findMenLiableForAMilitaryService(peopleList));
    }

    private static double findAverageMenAge(List<People> peopleList) {
        return peopleList
                .stream()
                .filter(people -> people.getSex() == Sex.MEN)
                .mapToDouble(people -> people.getAge())
                .average()
                .getAsDouble();
    }

    private static void displayAverageMenAge(List<People> peopleList) {
        System.out.println(findAverageMenAge(peopleList));
    }

    private static long findNumberOfBodyAblePeople(List<People> peopleList) {
        return peopleList
                .stream()
                .filter(people -> {
                    if (people.getSex() == Sex.MEN) {
                        return people.getAge() >= 18 && people.getAge() < 60;
                    } else {
                        return people.getAge() >= 18 && people.getAge() < 55;
                    }
                })
                .count();
    }

    private static void displayNumberOfBodyAblePeople(List<People> peopleList) {
        System.out.println(findNumberOfBodyAblePeople(peopleList));
    }

    private static People findPersonWithMinAge(List<People> peopleList) {
        return peopleList
                .stream()
                .min((p1, p2) -> Double.compare(p1.getAge(), p2.getAge()))
                .get();
    }

    private static void displayPersonWithMinAge(List<People> peopleList) {
        System.out.println(findPersonWithMinAge(peopleList));
    }

    private static List<People> sortByGender(List<People> peopleList) {
        return peopleList
                .stream()
                .sorted((p1, p2) -> p1.getSex().compareTo(p2.getSex()))
                .collect(Collectors.toList());
    }

    private static List<People> sortByAge(List<People> peopleList) {
        return peopleList
                .stream()
                .sorted((p1, p2) -> Double.compare(p1.getAge(), p2.getAge()))
                .collect(Collectors.toList());
    }

    private static void displaySortedPeopleCollection(List<People> peopleList) {
        System.out.println(sortByGender(peopleList));
        System.out.println(sortByAge(peopleList));
    }
}