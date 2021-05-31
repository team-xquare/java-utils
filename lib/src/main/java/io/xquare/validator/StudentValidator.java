package io.xquare.validator;

import java.util.regex.Pattern;

/**
 * 학생 정보와 관련된 검증을 하는 클래스입니다.
 */
public class StudentValidator {
    /*
     * 객체 생성을 막기 위한 생성자
     */
    private StudentValidator() {
        throw new AssertionError();
    }
    /**
     * 이메일 주소가 <a href="https://emailregex.com/">RFC 5322 표준</a>을 따르는지 검사합니다.
     * @param email 이메일 주소
     * @return true: 검증 성공, false: 검증 실패
     */
    public static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

        return pattern.matcher(email).matches();
    }

    /**
     *  학번을 통해 해당 학년이 맞는지 검사합니다.
     * @param gcn 학번
     * @param grade 학년
     * @return true: 검증 성공, false: 검증 실패
     */
    public static boolean isGradeValid(String gcn, Integer grade) {
        return gcn.matches(grade + "[0-9]*$") && gcn.length() < 5;
    }
}
