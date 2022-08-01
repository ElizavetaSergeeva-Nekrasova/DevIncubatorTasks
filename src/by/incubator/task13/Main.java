package by.incubator.task13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println(JosephProblemSolution.getLastSurvivorNumber(myArrayList, scanner));
        System.out.println(JosephProblemSolution.getLastSurvivorNumber(myLinkedList, scanner));
        scanner.close();
    }
}