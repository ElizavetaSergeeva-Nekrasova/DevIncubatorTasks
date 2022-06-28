package by.incubator.task4;

public enum DaysOfWeek {
    MONDAY ("MON", false),
    TUESDAY ("TUE", false),
    WEDNESDAY ("WED", false),
    THURSDAY ("THU", false),
    FRIDAY ("FRI", false),
    SATURDAY ("SUT", true),
    SUNDAY ("SUN", true);

    public String getAbbreviation() {
        return abbreviation;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    private String abbreviation;
    private boolean isWeekend;

    private DaysOfWeek(String abbreviation, boolean isWeekend) {
        this.abbreviation = abbreviation;
        this.isWeekend = isWeekend;
    }
}
