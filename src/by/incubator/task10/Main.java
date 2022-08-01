package by.incubator.task10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "src/by/incubator/task10/input.txt";
    private static final String INCORRECT_FILE_PATH = "src/by/incubator/task10/input1.txt";
    private static final String EMPTY_FILE_PATH = "src/by/incubator/task10/emptyFile.txt";

    public static void main(String[] args) {
        try {
            readFile(FILE_PATH);
        } catch (EmptyFileException e) {
            e.printStackTrace();
        }
        try {
            readFile(EMPTY_FILE_PATH);
        } catch (EmptyFileException e) {
            e.printStackTrace();
        }
        try {
            readFile(INCORRECT_FILE_PATH);
        } catch (EmptyFileException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(String path) throws EmptyFileException {
        File file = new File(path);

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                Scanner scanner = new Scanner(fileInputStream);
        ) {
            String fileLine = scanner.nextLine();
            System.out.printf("'%s' read from file '%s'%n", fileLine, path);
        } catch (IOException | NoSuchElementException ex) {
            throw new EmptyFileException("Empty file is located on " + path, ex, path);
        } finally {
            System.out.println("finally method for '" + path + "'");
        }
    }
}