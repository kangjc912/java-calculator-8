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

        String[] WODelimiter = text.split(delimiter);


        int sum = 0;
        for (String string : WODelimiter) {
            if (!string.isEmpty()) {
                sum += Integer.parseInt(string);
            }
        }

        return sum;
    }


}
