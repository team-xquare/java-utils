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
        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");

        return pattern.matcher(email).matches();
    }

    /**
     * 학번을 통해 해당 학년이 맞는지 검사합니다.
     * 문자열 길이가 4자리를 넘었을 경우에는 검증에 실패합니다.
     * @param gcn 학번
     * @param grade 학년
     * @return true: 검증 성공, false: 검증 실패
     */
    public static boolean isGradeValid(String gcn, Integer grade) {
        return gcn.matches(grade + "[0-9]*$") && gcn.length() < 5;
    }

    /**
     * 학번을 통해 해당 학년이 맞는지 검사합니다.
     * 문자열 길이가 4자리를 넘었을 경우에는 검증에 실패합니다.
     * @param gcn 학번
     * @param grades 학년
     * @return true: 검증 성공, false: 검증 실패
     */
    public static boolean isGradeValid(String gcn, Integer... grades) {
        if (gcn.length() > 4)
            return false;

        for (int grade : grades) {
            if (gcn.matches(grade + "[0-9]*$"))
                return true;
        }

        return false;
    }

    /**
     * 학번을 통해 해당 학년이 맞는지 검사합니다.
     * 문자열 길이가 4자리를 넘었을 경우에는 검증에 실패합니다.
     * @param gcn 학번
     * @param grade 학년
     * @return true: 검증 성공, false: 검증 실패
     */
    public static boolean isGradeValid(Integer gcn, Integer grade) {
        return gcn / 1000 == grade && gcn / 10000 == 0;
    }

    /**
     * 학번을 통해 해당 학년이 맞는지 검사합니다.
     * 문자열 길이가 4자리를 넘었을 경우에는 검증에 실패합니다.
     * @param gcn 학번
     * @param grades 학년
     * @return true: 검증 성공, false: 검증 실패
     */
    public static boolean isGradeValid(Integer gcn, Integer... grades) {
        if (gcn / 10000 != 0) {
            return false;
        }

        for (int grade : grades) {
            if (gcn / 1000 == grade)
                return true;
        }

        return false;
    }
}
