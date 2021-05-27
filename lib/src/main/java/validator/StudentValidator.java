package validator;

import java.util.regex.Pattern;

/**
 * 학생 정보와 관련된 검증을 하는 클래스입니다.
 */
public class StudentValidator {
    /**
     * 이메일 주소가 <a href="https://emailregex.com/">RFC 5322 표준</a>을 따르는지 검사합니다.
     * @param email 이메일 주소
     */
    public static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

        return pattern.matcher(email).matches();
    }
}
