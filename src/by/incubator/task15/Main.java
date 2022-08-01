package by.incubator.task15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Integer[] integers = createArray();
        List<String> nameList = createList();

        Filter<Integer> integerFilter = integer -> integer >= 100;
        Predicate<Integer> integerPredicate = integer -> integer >= 100;
        Function<Integer, Integer> function = integer -> integer * integer;
        Converter<Dog, Cat> dogToCatConverter = dog -> new Cat(dog.getName(), dog.getAge(), dog.getWeight());
        Predicate<Integer> predicateParity = integer -> integer % 2 == 0;
        Consumer<String> consumer = string -> System.out.println("Hello, " + string + "!");
        Supplier<Integer> supplier = () -> {return (int) (Math.random() * nameList.size());};
        Function<String, Integer> stringToIntConverter = Integer::parseInt;
        UnaryOperator<Integer> unaryOperator = integer -> integer * integer;

        Integer[] filteredArray = filterArray(integers, integerFilter);
        Integer[] filteredArrayWithPredicate = filterArray(integers, integerPredicate::test);
        Integer[] mappedArray = fill(integers, function);

        showArray(integers);
        showArray(filteredArray);
        showArray(filteredArrayWithPredicate);
        showArray(mappedArray);

        Dog dog = new Dog("Alisa", 5, 10.0);
        Cat cat = dogToCatConverter.convert(dog);
        System.out.println(cat);

        showResultOfParityPredicate(predicateParity, 2);
        showResultOfParityPredicate(predicateParity, 3);
        showResultOfParityPredicate(predicateParity, 7);

        greetings(consumer, "Liza");
        outputRandomName(nameList, supplier);
        showConvertedInt("5", stringToIntConverter);
        showSquareNumber(10, unaryOperator);
    }

    private static List<String> createList() {
        List<String> list = new ArrayList<>();
        list.add("Elena");
        list.add("Alex");
        list.add("Jim");
        list.add("John");
        list.add("Sara");

        return list;
    }

    private static Integer[] createArray() {
        Integer[] array = {777, 333, 2, 5, 7, 3, 5, 10, 100, 1000, 23, 2323, 777, 7777777};

        return array;
    }

    private static <T> boolean filter(T arrayElement, Filter<T> filter) {
        return filter.apply(arrayElement);
    }

    private static Integer[] filterArray(Integer[] integerArray, Filter<Integer> filter) {
        return Arrays.stream(integerArray).filter(integer -> filter(integer, filter)).toArray(Integer[]::new);
    }

    private static Integer[] fill(Integer[] integerArray, Function<Integer,Integer> function) {
        return Arrays.stream(integerArray).map(function).toArray(Integer[]::new);
    }

    private static void showArray(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            System.out.println(integers[i]);
        }
        System.out.println("------------------");
    }

    private static void showResultOfParityPredicate(Predicate<Integer> predicate, int number) {
        System.out.println(number + " - is even? " + predicate.test(number));
    }

    private static void greetings(Consumer<String> consumer, String name) {
        consumer.accept(name);
    }

    private static void outputRandomName(List<String> names, Supplier<Integer> supplier) {
        System.out.println(names.get(supplier.get()));
    }

    private static int convertString(String s, Function<String, Integer> function) {
        return function.apply(s);
    }

    private static void showConvertedInt(String s, Function<String, Integer> stringToIntConverter) {
        System.out.println(convertString(s, stringToIntConverter));
    }

    private static int squareNumber(int i, UnaryOperator<Integer> unaryOperator) {
        return unaryOperator.apply(i);
    }

    private static void showSquareNumber(int i, UnaryOperator<Integer> unaryOperator) {
        System.out.println(squareNumber(i, unaryOperator));
    }
}