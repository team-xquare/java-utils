package io.xquare.date

import spock.lang.Specification

class DateDifferenceSpec extends Specification {

    def "DateCompare 빌더 전체 검증 [월: #month, 년도: #year, DayOfWeek: #dayOfWeek, dayOfMonth: #dayOfMonth, dayOfYear: #dayOfYear]"() {
        when:
        DateDifference diff = DateDifference.builder()
                .dayOfWeek(dayOfWeek)
                .dayOfMonth(dayOfMonth)
                .dayOfYear(dayOfYear)
                .month(month)
                .year(year)
                .build()

        then:
        diff.month == month
        diff.dayOfYear == dayOfYear
        diff.dayOfMonth == dayOfMonth
        diff.dayOfWeek == dayOfWeek
        diff.year == year

        where:
        month     | year      | dayOfYear     | dayOfWeek     | dayOfMonth
        1         | 3         | 20            | 6            | 10
        1         | 10        | 30            | 4            | 20
        4         | 20        | 20            | 3            | 20
    }

    def "DateCompare 빌더 Month에서 AssertionError [월: #month, 년도: #year, DayOfWeek: #dayOfWeek, dayOfMonth: #dayOfMonth, dayOfYear: #dayOfYear]"() {
        when:
        DateDifference diff = DateDifference.builder()
                .dayOfWeek(dayOfWeek)
                .dayOfMonth(dayOfMonth)
                .dayOfYear(dayOfYear)
                .month(month)
                .year(year)
                .build()

        then:
        thrown AssertionError

        where:
        month     | year      | dayOfYear     | dayOfWeek     | dayOfMonth
        13        | 3         | 20            | 6            | 10
        -1        | 10        | 30            | 4            | 20
    }

    def "DateCompare 빌더 year에서 AssertionError [월: #month, 년도: #year, DayOfWeek: #dayOfWeek, dayOfMonth: #dayOfMonth, dayOfYear: #dayOfYear]"() {
        when:
        DateDifference diff = DateDifference.builder()
                .dayOfWeek(dayOfWeek)
                .dayOfMonth(dayOfMonth)
                .dayOfYear(dayOfYear)
                .month(month)
                .year(year)
                .build()

        then:
        thrown AssertionError

        where:
        month     | year      | dayOfYear     | dayOfWeek     | dayOfMonth
        2        | -1         | 20            | 6             | 10
    }

    def "DateCompare 빌더 dayOfYear에서 AssertionError [월: #month, 년도: #year, DayOfWeek: #dayOfWeek, dayOfMonth: #dayOfMonth, dayOfYear: #dayOfYear]"() {
        when:
        DateDifference diff = DateDifference.builder()
                .dayOfWeek(dayOfWeek)
                .dayOfMonth(dayOfMonth)
                .dayOfYear(dayOfYear)
                .month(month)
                .year(year)
                .build()

        then:
        thrown AssertionError

        where:
        month     | year      | dayOfYear     | dayOfWeek     | dayOfMonth
        2        | 10         | 2000          | 6             | 10
        2        | 10         | -1            | 6             | 10
    }

    def "DateCompare 빌더 dayOfWeek에서 AssertionError [월: #month, 년도: #year, DayOfWeek: #dayOfWeek, dayOfMonth: #dayOfMonth, dayOfYear: #dayOfYear]"() {
        when:
        DateDifference diff = DateDifference.builder()
                .dayOfWeek(dayOfWeek)
                .dayOfMonth(dayOfMonth)
                .dayOfYear(dayOfYear)
                .month(month)
                .year(year)
                .build()

        then:
        thrown AssertionError

        where:
        month     | year      | dayOfYear     | dayOfWeek     | dayOfMonth
        2        | 20         | 20            | 8             | 10
        2        | 20         | 20            | -1            | 10
    }

    def "DateCompare 빌더 dayOfMonth에서 AssertionError [월: #month, 년도: #year, DayOfWeek: #dayOfWeek, dayOfMonth: #dayOfMonth, dayOfYear: #dayOfYear]"() {
        when:
        DateDifference.builder()
                .dayOfWeek(dayOfWeek)
                .dayOfMonth(dayOfMonth)
                .dayOfYear(dayOfYear)
                .month(month)
                .year(year)
                .build()

        then:
        thrown AssertionError

        where:
        month     | year      | dayOfYear     | dayOfWeek     | dayOfMonth
        2        | 20         | 20            | 8             | 400
        2        | 20         | 20            | -1            | -10
    }

}
