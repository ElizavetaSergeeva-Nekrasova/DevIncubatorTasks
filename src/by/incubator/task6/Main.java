package by.incubator.task6;

import java.util.Scanner;

public class Main {
    static int arrayDimension;
    static double average;

    public static void main(String[] args) {
        arrayDimension = getArrayDimension();
        Student[] students = getStudentsArray();
        average = calculateAverage(students);
        displayStudentsUnderAverageGrade(students);
    }

    private static int getArrayDimension() {
        int arrayDimension = 0;

        System.out.println("Enter an array dimension: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            arrayDimension = scanner.nextInt();
        }

        return arrayDimension;
    }

    private static Student[] getStudentsArray() {
        int i = 0;
        Student[] students = new Student[arrayDimension];

        System.out.println("Enter student parameters: ");
        while (i < arrayDimension) {
            students[i] = getStudent();
            i++;
        }

        return students;
    }

    private static Student getStudent() {
        String firstName = null;
        String lastName = null;
        double grade = 0.0d;

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            lastName = scanner.nextLine();
        }
        if (scanner.hasNextLine()) {
            firstName = scanner.nextLine();
        }
        if (scanner.hasNextDouble()) {
            grade = scanner.nextDouble();
        }

        Student student = new Student(firstName, lastName, grade);

        return student;
    }

    private static double calculateAverage (Student[] students) {
        double sum = 0;

        for (Student s:
             students) {
            sum += s.getGradePointAverage();
        }

        double average = sum / arrayDimension;

        return average;
    }

    private static void displayStudentsUnderAverageGrade(Student[] students) {
        System.out.printf("%.2f", average);
        System.out.println();

        for (Student s:
             students) {
            if (s.getGradePointAverage() < average) {
                System.out.println(s);
            }
        }
    }
}