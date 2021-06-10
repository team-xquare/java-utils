package io.xquare.date;

public class DateDifference {

    private final int year;

    private final int month;

    private final int day;

    private final long totalDays;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public long getTotalDays() {
        return totalDays;
    }

    private DateDifference(int year, int month, int day, long totalDays) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.totalDays = totalDays;
    }

    public static DateDifference.DateDifferenceBuilder builder() {
        return new DateDifference.DateDifferenceBuilder();
    }

    public static class DateDifferenceBuilder {
        private int year;
        private int month;
        private int day;
        private long totalDays;

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

        public DateDifference.DateDifferenceBuilder totalDays(final int totalDays) {
            this.totalDays = totalDays;
            return this;
        }

        public DateDifference build() {
            return new DateDifference(this.year, this.month, this.day, this.totalDays);
        }
    }
}
