import java.util.Scanner;

public class DisplayWeekDay {
    public static String getDayInfo() {
        int number = readNumber();
        String result = null;

        if (number >=1 && number <= 7) {
            result = getDescriptionByNumber (number);
        }
        else {
            result = Integer.toString (number);
        }

        return result;
    }

    public static int readNumber() {
        int number = 0;

        System.out.println("Enter the day number: ");
        Scanner scanner = new Scanner (System.in);
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
        }

        return number;
    }

    public static String getDescriptionByNumber (int number) {
        switch (number) {
            case 1:
                return getDescriptionFromEnum (DaysOfWeek.MONDAY);
            case 2:
                return getDescriptionFromEnum (DaysOfWeek.TUESDAY);
            case 3:
                return getDescriptionFromEnum (DaysOfWeek.WEDNESDAY);
            case 4:
                return getDescriptionFromEnum (DaysOfWeek.THURSDAY);
            case 5:
                return getDescriptionFromEnum(DaysOfWeek.FRIDAY);
            case 6:
                return getDescriptionFromEnum(DaysOfWeek.SATURDAY);
            case 7:
                return getDescriptionFromEnum(DaysOfWeek.SUNDAY);
            default: return null;

        }
    }

    public static String getDescriptionFromEnum (DaysOfWeek day) {
        String result = day + " (" + day.getAbbreviation() + ") " + isWeekendInfo(day);

        return result;
    }

    public static String isWeekendInfo (DaysOfWeek day) {
        if (day.isWeekend()) {
            return "is a weekend";
        }
        else {
            return "is not a weekend";
        }
    }
}
