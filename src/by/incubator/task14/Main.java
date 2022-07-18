package by.incubator.task14;

import java.util.Iterator;

public class Main {
    private static final String[] PRODUCTS = {"Milk", "Bread", "Salad", "Broccoli", "Pears", "Pineapples", "Butter"};
    private static final int MAX_QUANTITY = 70;
    private static final int MIN_QUANTITY = 30;

    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        fillMyMap(myHashMap);
        System.out.println("The most frequent product: " + mostFrequent(myHashMap));

        MyHashSet<String> myHashSet = getProductSet();

        System.out.println("The list of product: ");
        Iterator<String> iterator = myHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void fillMyMap(MyHashMap<String, Integer> myHashMap) {
        for (String product:
             PRODUCTS) {
            myHashMap.put(product, generateRandomQuantity());
        }
    }

    private static int generateRandomQuantity() {
        return (int) (Math.random() * (MAX_QUANTITY + 1 - MIN_QUANTITY) + MIN_QUANTITY);
    }

    private static String mostFrequent(MyHashMap<String, Integer> myHashMap) {
        int max = 0;
        String mostFrequentProduct = "";

        for (String product:
             PRODUCTS) {
            int quantity = myHashMap.get(product);

            if (quantity > max) {
                max = quantity;
                mostFrequentProduct = product;
            }
        }

        return mostFrequentProduct;
    }

    private static MyHashSet<String> getProductSet() {
        MyHashSet<String> myHashSet = new MyHashSet<>();

        for (String product:
                PRODUCTS) {
            myHashSet.add(product);
        }

        myHashSet.add("Sweets");
        myHashSet.add("Chocolate");
        myHashSet.add("Cookies");
        myHashSet.add("Marmalade");

        return myHashSet;
    }
}