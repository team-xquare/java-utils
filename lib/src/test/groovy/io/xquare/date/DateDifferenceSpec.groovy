package io.xquare.date

import spock.lang.Specification

class DateDifferenceSpec extends Specification {

    def "DateCompare 빌더 검증 [월: #month, 년도: #year, 날: #day, 시: #hour, 분: #minute, 초: second]"() {
        when:
        DateDifference diff = DateDifference.builder()
                .minute(minute)
                .second(second)
                .hour(hour)
                .day(day)
                .month(month)
                .year(year)
                .build()

        then:
        diff.month == month
        diff.year == year
        diff.day == day
        diff.hour == hour
        diff.minute == minute
        diff.second == second

        where:
        month     | year      | day     | hour     | minute     | second
        1         | 3         | 20      | 6        | 10         | 10
        1         | 10        | 30      | 4        | 20         | 10
    }

    def "DateCompare 빌더 시/분/초 제외 검증 [월: #month, 년도: #year, 날: #day]"() {
        when:
        DateDifference diff = DateDifference.builder()
                .day(day)
                .month(month)
                .year(year)
                .build()

        then:
        diff.month == month
        diff.year == year
        diff.day == day
        diff.hour == 0
        diff.minute == 0
        diff.second == 0

        where:
        month     | year      | day
        1         | 3         | 20
        1         | 10        | 30
    }

    def "DateCompare 빌더 년/월/일 제외 검증 [시: #hour, 분: #minute, 초: second]"() {
        when:
        DateDifference diff = DateDifference.builder()
                .hour(hour)
                .minute(minute)
                .second(second)
                .build()

        then:
        diff.hour == hour
        diff.minute == minute
        diff.second == second

        where:
        hour     | minute     | second
        6        | 10         | 10
        4        | 20         | 10
    }

}
