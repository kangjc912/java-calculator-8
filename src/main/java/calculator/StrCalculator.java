package calculator;
import java.lang.String;

public class StrCalculator {
    //빈 문자열 처리
    private boolean isBlank(String s) {
        return s  == null || s.isEmpty();
    }

    public int add(String s) {
        //빈 문자열 확인
        if (isBlank(s)) {
            return 0;
        }
        // ,: 구분자
        String[] WODelimiter = s.split("[,:]");

        int sum = 0;
        for (String string : WODelimiter) {
            sum += Integer.parseInt(string);
        }

        return sum;
    }


}
