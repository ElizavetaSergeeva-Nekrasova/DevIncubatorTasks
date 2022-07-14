package by.incubator.task14;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("Hello", 7);
        myHashMap.put("Hello", 5);
        System.out.println(myHashMap.get("Hello"));
    }
}