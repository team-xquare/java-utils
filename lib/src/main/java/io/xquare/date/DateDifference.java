package io.xquare.date;

public class DateDifference {

    private final int year;

    private final int month;

    private final int dayOfWeek;

    private final int dayOfMonth;

    private final int dayOfYear;

    private DateDifference(int year, int month, int dayOfWeek, int dayOfMonth, int dayOfYear) {
        this.year = year;
        this.month = month;
        this.dayOfYear = dayOfYear;
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getDayOfYear() {
        return dayOfYear;
    }

    public static DateDifference.DateDifferenceBuilder builder() {
        return new DateDifference.DateDifferenceBuilder();
    }

    public static class DateDifferenceBuilder {
        private int year;
        private int month;
        private int dayOfWeek;
        private int dayOfMonth;
        private int dayOfYear;

        public DateDifference.DateDifferenceBuilder year(final int year) {
            this.year = year;
            return this;
        }

        public DateDifference.DateDifferenceBuilder month(final int month) {
            this.month = month;
            return this;
        }

        public DateDifference.DateDifferenceBuilder dayOfWeek(final int dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
            return this;
        }

        public DateDifference.DateDifferenceBuilder dayOfMonth(final int dayOfMonth) {
            this.dayOfMonth = dayOfMonth;
            return this;
        }

        public DateDifference.DateDifferenceBuilder dayOfYear(final int dayOfYear) {
            this.dayOfYear = dayOfYear;
            return this;
        }

        public DateDifference build() {
            if (!isValid(year, month, dayOfWeek, dayOfMonth, dayOfYear)) {
                throw new AssertionError();
            }

            return new DateDifference(this.year, this.month, this.dayOfWeek, this.dayOfMonth, this.dayOfYear);
        }

        private boolean isValid(int year, int month, int dayOfWeek, int dayOfMonth, int dayOfYear) {
            return year >= 1
                    && month >= 0 && month <= 12
                    && dayOfMonth >= 1 && dayOfMonth <= 31
                    && dayOfWeek >= 0 && dayOfWeek <= 7
                    && dayOfYear >= 0 && dayOfYear <= 366;
        }
    }
}
