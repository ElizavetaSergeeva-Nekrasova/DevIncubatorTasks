package by.incubator.task14;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(20, "Привет");
        myHashMap.put(10, "hello");
        myHashMap.put(200, "a");
        myHashMap.put(300, "b");
        myHashMap.put(700, "dear");

        System.out.println(myHashMap.remove(10));
        System.out.println(myHashMap.remove(300));
        System.out.println(myHashMap.size());

    }
}