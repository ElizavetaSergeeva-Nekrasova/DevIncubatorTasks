package by.incubator.task13;

import java.util.Scanner;

public class JosephProblemWithArrayList {
    private static MyArrayList<Integer> myArrayList;
    private static int warriorsNumber;
    private static int killInterval;

    public static Integer getLastSurvivorNumber() {
        getNumbers();

        initializeArrayList();

        removeWarriors();

        return myArrayList.get(0);
    }

    private static void getNumbers() {
        getNumbersFromConsole();
        if (isWrongNumbers()) {
            throw new IllegalArgumentException("Enter the numbers greater than one");
        }
    }

    private static void getNumbersFromConsole() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of warriors: ");
            if (scanner.hasNextInt()) {
                warriorsNumber = scanner.nextInt();
            }

            System.out.println("Enter the frequency of kills: ");
            if (scanner.hasNextInt()) {
                killInterval = scanner.nextInt() - 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isWrongNumbers() {
        return warriorsNumber <= 1 || killInterval <= 0;
    }

    private static void initializeArrayList() {
        myArrayList = new MyArrayList<>();
        for (int i = 1; i <= warriorsNumber; i++) {
            myArrayList.add(Integer.valueOf(i));
        }
    }

    private static void removeWarriors() {

        int i = 0;
        while (!isOnlyOneWarriorLeft()) {
            i = i + killInterval;

            while (i >= myArrayList.size()) {
                i = i - myArrayList.size();
            }

            myArrayList.remove(i);
        }
    }

    private static boolean isOnlyOneWarriorLeft() {
        return myArrayList.size() == 1;
    }
}