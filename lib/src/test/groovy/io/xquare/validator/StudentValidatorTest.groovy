package io.xquare.validator

import spock.lang.Specification

class StudentValidatorTest extends Specification {
    def "isEmailValid 반환 값이 올바른지 검증"() {
        when:
        boolean result = StudentValidator.isEmailValid(email)

        then:
        result == result

        where:
        email                    | result
        "smoothbear04@gmail.com" | true
        "aaa"                    | false

    }

    def "IsGradeValid"() {
    }
}
