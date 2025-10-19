package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력하세요:");

        String s = Console.readLine();
        StrCalculator calculator = new StrCalculator();
        int result = calculator.add(s);
        System.out.println("결과 : " + result);
    }
}


