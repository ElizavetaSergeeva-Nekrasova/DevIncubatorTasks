package by.incubator.test6;

public class Student {
    private static int studentsCount;
    private final String firstName;
    private final String lastName;
    private double gradePointAverage;

    public Student(String firstName, String lastName, double gradePointAverage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradePointAverage = gradePointAverage;

        studentsCount++;

        System.out.println("Constructor with parameters execution - " + studentsCount);
    }

    public double getGradePointAverage() {
        return gradePointAverage;
    }

    public void setGradePointAverage(double gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    public static void displayStudentsCount() {
        System.out.println("Students count: " + studentsCount);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + gradePointAverage;
    }
}
