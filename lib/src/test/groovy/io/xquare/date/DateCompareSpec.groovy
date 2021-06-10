package io.xquare.date

import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalDateTime

class DateCompareSpec extends Specification {

    def "DateCompare 생성자 Assertion 에러"() {
        when:
        DateCompare validator = new DateCompare()

        then:
        thrown AssertionError
    }

    def "DateCompare LocalDateTime과 LocalDateTime 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        LocalDateTime sourceDate = LocalDateTime.of(2021, 6, 10, 6, 10)
        LocalDateTime targetDate = LocalDateTime.of(2020, 5, 5, 9, 20)

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 400
        result.getYear() == 1
        result.getMonth() == 13
        result.getHour() == 9620
        result.getMinute() == 577250
        result.getSecond() == 34635000
    }

    def "DateCompare LocalDate와 LocalDateTime 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        LocalDate sourceDate = LocalDate.of(2021, 6, 10)
        LocalDateTime targetDate = LocalDateTime.of(2020, 5, 5, 9, 20)

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 400
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare LocalDateTime과 LocalDate 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        LocalDateTime sourceDate = LocalDateTime.of(2021, 6, 10, 0, 0)
        LocalDate targetDate = LocalDate.of(2020, 5, 5)

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 401
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare LocalDate와 LocalDate 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        LocalDate sourceDate = LocalDate.of(2021, 6, 10)
        LocalDate targetDate = LocalDate.of(2020, 5, 5)

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 401
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare Date와 Date 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        Date sourceDate = new Date(2021, 6, 10)
        Date targetDate = new Date(2020, 5, 5)

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 400
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare LocalDateTime과 Date 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        LocalDateTime sourceDate = LocalDateTime.of(2021, 6, 10, 0, 0)
        Date targetDate = new Date(120, 4, 5)

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 401
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare Date와 LocalDateTime 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        Date sourceDate = new Date(121, 5, 10)
        LocalDateTime targetDate = LocalDateTime.of(2020, 5, 5, 9, 20)

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 400
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare LocalDate와 Date 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        LocalDate sourceDate = LocalDate.of(2021, 6, 10)
        Date targetDate = new Date(120, 4, 5)       // when we want to use Date Constructor, we have to give them the count after operation

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 401
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare Date와 LocalDate 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        Date sourceDate = new Date(121, 5, 10)
        LocalDate targetDate = LocalDate.of(2020, 5, 5)

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 401
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare LocalDateTime과 Calendar 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        LocalDateTime sourceDate = LocalDateTime.of(2021, 6, 10, 0, 0)
        Calendar targetDate = Calendar.getInstance()
        targetDate.set(2020, 4, 5)

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 401
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare Calender와 LocalDateTime 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        Calendar sourceDate = Calendar.getInstance()
        LocalDateTime targetDate = LocalDateTime.of(2020, 5, 5, 9, 20)
        sourceDate.set(2021, 5, 10)

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 400
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare Calendar와 LocalDate 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        Calendar sourceDate = Calendar.getInstance()
        sourceDate.set(2021, 5, 10)
        LocalDate targetDate = LocalDate.of(2020, 5, 5)

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 401
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare LocalDate와 Calendar 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        LocalDate sourceDate = LocalDate.of(2021, 6, 10)
        Calendar targetDate = Calendar.getInstance()
        targetDate.set(2020, 4, 5)

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 401
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare Date와 Calendar 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        Date sourceDate = new Date(121, 5, 10)
        Calendar targetDate = Calendar.getInstance()
        targetDate.set(2020, 4, 5)

        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 401
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare Calendar와 Date 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        Calendar sourceDate = Calendar.getInstance()
        sourceDate.set(2021, 5, 10)
        Date targetDate = new Date(120, 4, 5)


        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 401
        result.getYear() == 1
        result.getMonth() == 13
    }

    def "DateCompare Calendar와 Calendar 비교 [비교된 날짜: #sourceDate, 비교한 날짜: #targetDate]"() {
        given:
        Calendar sourceDate = Calendar.getInstance()
        sourceDate.set(2021, 5, 10)
        Calendar targetDate = Calendar.getInstance()
        targetDate.set(2020, 4, 5)


        when:
        DateDifference result = DateCompare.getDifference(sourceDate, targetDate)

        then:
        result.getDay() == 401
        result.getYear() == 1
        result.getMonth() == 13
    }

    /**
     * left : 2021년 6월 10일
     * right : 2020년 5월 5일
     * left LocalDateTime
     * LocalDateTime.of(2021,6,10,6,10)
     * right LocalDateTime
     */
}
