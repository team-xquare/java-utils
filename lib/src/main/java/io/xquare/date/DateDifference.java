package io.xquare.date;

public class DateDifference {

    private final long year;
    private final long month;
    private final long day;
    private final long hour;
    private final long minute;
    private final long second;

    private DateDifference(long year, long month, long day, long hour, long minute, long second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public long getYear() {
        return year;
    }

    public long getMonth() {
        return month;
    }

    public long getDay() {
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
        private long year;
        private long month;
        private long day;
        private long hour;
        private long minute;
        private long second;

        public DateDifference.DateDifferenceBuilder year(final long year) {
            this.year = year;
            return this;
        }

        public DateDifference.DateDifferenceBuilder month(final long month) {
            this.month = month;
            return this;
        }

        public DateDifference.DateDifferenceBuilder day(final long day) {
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
