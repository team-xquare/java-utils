package io.xquare.validator

import spock.lang.Specification
import spock.lang.Unroll

class StudentValidatorSpec extends Specification {
    def "StudentValidator 인스턴스화를 막는지 검증"() {
        when:
        StudentValidator validator = new StudentValidator()

        then:
        thrown AssertionError
    }

    @Unroll
    def "isEmailValid 반환 값이 올바른지 검증 [이메일: #email, 예상 결과값: #expectedResult]"() {
        when:
        boolean result = StudentValidator.isEmailValid(email)

        then:
        result == expectedResult

        where:
        email                                         | expectedResult
        // Valid address
        "email@example.name"                          | true
        "email@example.co.jp"                         | true
        "_______@example.com"                         | true
        "firstname+lastname@example.com"              | true
        "email@111.222.333.44444"                     | true

        // Invalid address
        "aaa"                                         | false
        "#@%^%#\$@#\$@#.com"                          | false
        "@example.com"                                | false
        "Joe Smith <email@example.com>"               | false
        "”(),:;<>[\\]@example.com"                    | false
        "just”not”right@example.com"                  | false
        "this\\ is\"really\"not\\allowed@example.com" | false

    }

    @Unroll
    def "IsGradeValid 반환 값이 올바른지 검증 [학번: #gcn, 학년: #grade, 예상 결과값: #expectedResult]"() {
        when:
        boolean result = StudentValidator.isGradeValid(gcn, grade)

        then:
        result == expectedResult

        where:
        gcn     | grade | expectedResult
        // Must return true
        "2304"  | 2     | true
        "1102"  | 1     | true

        // Must return false
        "2304"  | 1     | false
        "23005" | 2     | false
    }

    @Unroll
    def "IsGradeValid 다수의 학년 조건을 넣을때 반환 값이 올바른지 검증 [학번: #gcn, 학년1: #grade1, 학년2: #grade2, 예상 결과값: #expectedResult]"() {
        when:
        boolean result = StudentValidator.isGradeValid(gcn, grade1, grade2)

        then:
        result == expectedResult

        where:
        gcn     | grade1 | grade2 | expectedResult
        // Must return true
        "2304"  | 1      | 2      | true
        "1302"  | 1      | 3      | true

        // Must return false
        "2304"  | 1      | 3      | false
        "13021" | 1      | 2      | false
    }

    @Unroll
    def "IsGradeValid 정수형으로 학년 조건을 넣을때 반환 값이 올바른지 검증 [학번: #gcn, 학년: #grade, 예상 결과값: #expectedResult]"() {
        when:
        boolean result = StudentValidator.isGradeValid(gcn, grade)

        then:
        result == expectedResult

        where:
        gcn   | grade | expectedResult
        // Must return true
        1202  | 1     | true
        3304  | 3     | true

        // Must return false
        12025 | 1     | false
        1202  | 2     | false
        3040  | 1     | false
    }

    @Unroll
    def "IsGradeValid 정수형으로 다수의 학년 조건을 넣을때 반환 값이 올바른지 검증 [학번: #gcn, 학년1: #grade1, 학년2: #grade2, 예상 결과값: #expectedResult]"() {
        when:
        boolean result = StudentValidator.isGradeValid(gcn, grade1, grade2)

        then:
        result == expectedResult

        where:
        gcn   | grade1 | grade2 | expectedResult
        // Must return true
        1202  | 1      | 2      | true
        2304  | 2      | 3      | true
        3401  | 3      | 1      | true

        // Must return false
        1203  | 2      | 3      | false
        23010 | 1      | 2      | false
        3104  | 1      | 2      | false
    }
}
