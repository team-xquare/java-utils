package io.xquare.date;

public class DateDifference {

    private final int year;
    private final int month;
    private final int day;
    private final long hour;
    private final long minute;
    private final long second;

    private DateDifference(int year, int month, int day, long hour, long minute, long second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public long getHour() {
        return hour;
    }

    public long getMinute() {
        return minute;
    }

    public long getSecond() {
        return second;
    }

    public static DateDifference.DateDifferenceBuilder builder() {
        return new DateDifference.DateDifferenceBuilder();
    }

    public static class DateDifferenceBuilder {
        private int year;
        private int month;
        private int day;
        private long hour;
        private long minute;
        private long second;

        public DateDifference.DateDifferenceBuilder year(final int year) {
            this.year = year;
            return this;
        }

        public DateDifference.DateDifferenceBuilder month(final int month) {
            this.month = month;
            return this;
        }

        public DateDifference.DateDifferenceBuilder day(final int day) {
            this.day = day;
            return this;
        }

        public DateDifference.DateDifferenceBuilder hour(final long hour) {
            this.hour = hour;
            return this;
        }

        public DateDifference.DateDifferenceBuilder minute(final long minute) {
            this.minute = minute;
            return this;
        }

        public DateDifference.DateDifferenceBuilder second(final long second) {
            this.second = second;
            return this;
        }

        public DateDifference build() {
            return new DateDifference(this.year, this.month, this.day, this.hour, this.minute, this.second);
        }
    }
}
