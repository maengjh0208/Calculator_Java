package challenge;

import java.io.BufferedReader;

public class InputParser {
    public static double getValidateDouble(BufferedReader br, int idx) throws Exception {
        try {
            System.out.print(idx + "번째 실수(0 포함)를 입력: ");
            String num = br.readLine();

            double doubleNum = Double.parseDouble(num);
            if (doubleNum < 0) {
                throw new IllegalArgumentException("[ERROR] 0 이상이어야 합니다.");
            }

            return doubleNum;
        } catch (NumberFormatException e) {
            throw new RuntimeException("[ERROR] 숫자가 아닌 값을 입력했습니다.");
        }
    }

    public static char getValidateChar(BufferedReader reader) throws Exception {
        System.out.print("사칙연산 기호(+, -, *, /) 입력: ");
        char operator = reader.readLine().charAt(0);

        if (!(operator == '+' || operator == '-' || operator == '*' || operator == '/')) {
            throw new IllegalArgumentException("[ERROR] 사칙연산 기호는 +, -, *, / 중 하나를 입력해야 합니다.");
        }

        return operator;
    }
}
