package calculator;

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

        //변수 초기화
        String delimiter = "[,:]";
        String text = s;


        //커스텀 구분자 처리
        if(s.startsWith("//")){
            int Index = s.indexOf("n")+1;
            delimiter = s.substring(2, 3);
            text = s.substring(Index);

        }

        //구분자 기준으로 split
        String[] WODelimiter = text.split(delimiter);

        //정답변수 초기화
        int sum = 0;

        //유효한 숫자인지 확인 후 sum에 합하기
        for (String str : WODelimiter) {
            if (!str.isEmpty()) {
                int num = Check(str);
                sum += num;
            }
        }

        return sum;
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
