package io.xquare.validator

import spock.lang.Specification

class StudentValidatorSpec extends Specification {
    def "isEmailValid 반환 값이 올바른지 검증"() {
        when:
        boolean result = StudentValidator.isEmailValid(email)

        then:
        result == expectedResult

        where:
        email                                         | expectedResult
        // Valid address
        "s!owiI@gmail.com"                            | true
        "email@example.name"                          | true
        "email@example.co.jp"                         | true
        "_______@example.com"                         | true
        "firstname+lastname@example.com"              | true
        "Abc..123@example.com"                        | true
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

    def "IsGradeValid 반환 값이 올바른지 검증"() {
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
}
