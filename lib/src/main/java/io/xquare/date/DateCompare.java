package io.xquare.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * 여러 Date 타입끼리 비교하고, 차이를 반환해 주는 클래스 입니다.
 * @Param sourceDate 비교될 날짜
 * @Param targetDate 비교할 날짜
 */
public class DateCompare {

    /**
     * 객체 생성을 막아주는 생성자 입니다.
     */
    private DateCompare() {
        throw new AssertionError();
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 LocalDateTime으로 준다.
     * @param targetDate
     * 비교할 날짜는 LocalDateTime으로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(LocalDateTime sourceDate, LocalDateTime targetDate) {
        return DateDifference.builder()
                .year(ChronoUnit.YEARS.between(sourceDate, targetDate))
                .month(ChronoUnit.MONTHS.between(sourceDate, targetDate))
                .day(ChronoUnit.DAYS.between(sourceDate, targetDate))
                .hour(ChronoUnit.HOURS.between(sourceDate, targetDate))
                .minute(ChronoUnit.MINUTES.between(sourceDate, targetDate))
                .second(ChronoUnit.SECONDS.between(sourceDate, targetDate))
                .build();
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 LocalDate로 준다.
     * @param targetDate
     * 비교할 날짜는 LocalDateTime으로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(LocalDate sourceDate, LocalDateTime targetDate) {
        return getDifference(sourceDate.atStartOfDay(), targetDate);
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 LocalDateTime로 준다.
     * @param targetDate
     * 비교할 날짜는 LocalDate으로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(LocalDateTime sourceDate, LocalDate targetDate) {
        return getDifference(sourceDate, targetDate.atStartOfDay());
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 LocalDate로 준다.
     * @param targetDate
     * 비교할 날짜는 LocalDate으로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(LocalDate sourceDate, LocalDate targetDate) {
        return getDifference(sourceDate.atStartOfDay(), targetDate.atStartOfDay());
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 Date로 준다.
     * @param targetDate
     * 비교할 날짜는 Date로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(Date sourceDate, Date targetDate) {
        LocalDateTime source = dateToLocalDateTime(sourceDate);
        LocalDateTime target = dateToLocalDateTime(targetDate);
        return getDifference(source, target);
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 LocalDateTime로 준다.
     * @param targetDate
     * 비교할 날짜는 Date로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(LocalDateTime sourceDate, Date targetDate) {
        LocalDateTime target = dateToLocalDateTime(targetDate);
        return getDifference(sourceDate, target);
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 Date로 준다.
     * @param targetDate
     * 비교할 날짜는 LocalDateTime로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(Date sourceDate, LocalDateTime targetDate) {
        LocalDateTime source = dateToLocalDateTime(sourceDate);
        return getDifference(source, targetDate );
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 Date로 준다.
     * @param targetDate
     * 비교할 날짜는 LocalDate로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(Date sourceDate, LocalDate targetDate) {
        LocalDateTime source = dateToLocalDateTime(sourceDate);
        return getDifference(source, targetDate.atStartOfDay());
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 LocalDate로 준다.
     * @param targetDate
     * 비교할 날짜는 Date로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(LocalDate sourceDate, Date targetDate) {
        LocalDateTime target = dateToLocalDateTime(targetDate);
        return getDifference(sourceDate.atStartOfDay(), target);
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 LocalDateTime으로 준다.
     * @param targetDate
     * 비교할 날짜는 Calendar로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(LocalDateTime sourceDate, Calendar targetDate) {
        LocalDateTime target = dateToLocalDateTime(targetDate.getTime());
        return getDifference(sourceDate, target);
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 Calendar로 준다.
     * @param targetDate
     * 비교할 날짜는 LocalDateTime으로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(Calendar sourceDate, LocalDateTime targetDate) {
        LocalDateTime source = dateToLocalDateTime(sourceDate.getTime());
        return getDifference(source, targetDate);
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 LocalDate로 준다.
     * @param targetDate
     * 비교할 날짜는 Calendar로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(LocalDate sourceDate, Calendar targetDate) {
        LocalDateTime target = dateToLocalDateTime(targetDate.getTime());
        return getDifference(sourceDate.atStartOfDay(), target);
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 Calendar로 준다.
     * @param targetDate
     * 비교할 날짜는 LocalDate로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(Calendar sourceDate, LocalDate targetDate) {
        LocalDateTime source = dateToLocalDateTime(sourceDate.getTime());
        return getDifference(source, targetDate);
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 Date로 준다.
     * @param targetDate
     * 비교할 날짜는 Calendar로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(Date sourceDate, Calendar targetDate) {
        LocalDateTime source = dateToLocalDateTime(sourceDate);
        LocalDateTime target = dateToLocalDateTime(targetDate.getTime());
        return getDifference(source, target);
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 Calendar로 준다.
     * @param targetDate
     * 비교할 날짜는 Date로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(Calendar sourceDate, Date targetDate) {
        LocalDateTime source = dateToLocalDateTime(sourceDate.getTime());
        LocalDateTime target = dateToLocalDateTime(targetDate);
        return getDifference(source, target);
    }

    /**
     * @param sourceDate
     * 비교될 날짜를 Calendar로 준다.
     * @param targetDate
     * 비교할 날짜는 Calendar로 준다.
     * @return DateDifference
     * 비교된 년/월/일/시/분/초 를 DateDifference로 반환한다.
     */
    public static DateDifference getDifference(Calendar sourceDate, Calendar targetDate) {
        LocalDateTime source = dateToLocalDateTime(sourceDate.getTime());
        LocalDateTime target = dateToLocalDateTime(targetDate.getTime());
        return getDifference(source, target);
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

}
