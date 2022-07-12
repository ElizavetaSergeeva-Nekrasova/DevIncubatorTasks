package by.incubator.task13;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        System.out.println(JosephProblemWithArrayList.getLastSurvivorNumber(myArrayList));
        System.out.println(JosephProblemWithArrayList.getLastSurvivorNumber(myLinkedList));
    }
}