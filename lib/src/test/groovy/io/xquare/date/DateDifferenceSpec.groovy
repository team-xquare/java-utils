package io.xquare.date

import spock.lang.Specification

class DateDifferenceSpec extends Specification {
    def "DateCompare day 빌더 검증 [날짜: #day]"() {
        when:
        DateDifference diff = DateDifference.builder()
                .day(day)
                .build()

        then:
        diff.day == day
        diff.totalDays == 0
        diff.month == 0
        diff.year == 0

        where:
        day | _
        10  | _
        20  | _
        5   | _
    }

    def "DateCompare month 빌더 검증 [월: #month]"() {
        when:
        DateDifference diff = DateDifference.builder()
                .month(month)
                .build()

        then:
        diff.month == month
        diff.day == 0
        diff.totalDays == 0
        diff.year == 0

        where:
        month   | _
        1       | _
        2       | _
        3       | _
    }

    def "DateCompare year 빌더 검증 [년도: #year]"() {
        when:
        DateDifference diff = DateDifference.builder()
                .year(year)
                .build()

        then:
        diff.month == 0
        diff.day == 0
        diff.totalDays == 0
        diff.year == year

        where:
        year    | _
        1       | _
        2       | _
        3       | _
    }

    def "DateCompare totalDays 빌더 검증 [총 날짜 수: #totalDays]"() {
        when:
        DateDifference diff = DateDifference.builder()
                .totalDays(totalDays)
                .build()

        then:
        diff.month == 0
        diff.day == 0
        diff.totalDays == totalDays
        diff.year == 0

        where:
        totalDays    | _
        1            | _
        2            | _
        3            | _
    }

    def "DateCompare 빌더 전체 검증 [일: #day, 월: #month, 년도: #year, 총 날짜 수: #totalDays]"() {
        when:
        DateDifference diff = DateDifference.builder()
                .day(day)
                .month(month)
                .year(year)
                .totalDays(totalDays)
                .build()

        then:
        diff.month == month
        diff.day == day
        diff.totalDays == totalDays
        diff.year == year

        where:
        day     | month     | year      | totalDays
        1       | 1         | 3         | 20
        20      | 30        | 10        | 30
        10      | 40        | 20        | 20
    }
}
