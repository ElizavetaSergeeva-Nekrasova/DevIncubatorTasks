package by.incubator.task12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isCorrect = isCorrectString();

        System.out.println(isCorrect);
    }

    private static boolean isCorrectString() {
        String text = getString();

        return CheckingBracketsAlgorithm.checkingBracketsAlgorithm(text);
    }

    private static String getString() {
        String text = null;

        System.out.println("Enter your text: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            text = scanner.nextLine();
        }

        return text;
    }
}