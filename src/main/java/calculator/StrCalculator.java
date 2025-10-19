package calculator;

public class StrCalculator {

    //정답 도출 함수
    public int add(String s) {

        //빈 문자열 확인
        if (isBlank(s)) {
            return 0;
        }

        String[] numbers = splitText(s);

        return sumNumbers(numbers);
    }

    //빈 문자열 처리
    private boolean isBlank(String s) {
        return s == null || s.isEmpty();
    }


    //구분자 처리
    private String[] splitText(String s) {
        String delimiter = "[,:]";
        String text = s;

        // 커스텀 구분자 처리
        if (s.startsWith("//")) {
            int index = s.indexOf("n") + 1;
            delimiter = s.substring(2, 3);
            text = s.substring(index);
        }

        return text.split(delimiter);
    }

    //최종 정답 덧셈
    private int sumNumbers(String[] numbers) {
        int sum = 0;

        //반복문
        for (String str : numbers) {
            sum += toInt(str);
        }
        return sum;
    }

    //문자열 유효성 검사
    private int toInt(String str) {
        //빈 문자열 처리
        if (str.isEmpty()) {
            return 0;
        }
        return Check(str);
    }


    //예외처리 함수
    private int Check(String str) {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            //잘못된 구분자나, 숫자가 아닌 문자가 입력됐을 때 처리
            throw new IllegalArgumentException("잘못된 구분자가 포함되어 있거나 숫자가 아닌 값이 있습니다.");
        }

        //음수가 입력됐을 때 처리
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return num;
    }


}
