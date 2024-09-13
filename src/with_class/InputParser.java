package with_class;

import java.io.BufferedReader;

public class InputParser {
    public static int getValidateNum(BufferedReader reader, int idx) throws Exception {
        try {
            System.out.print(idx + "번째 정수(0 포함)를 입력: ");
            int num = Integer.parseInt(reader.readLine());

            /* 입력받은 정수의 유효성 검증 */
            if (num < 0) {
                throw new IllegalArgumentException("[ERROR] 0 이상의 정수여야 합니다. 입력받은 정수: " + num);
            }

            return num;

        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 정수가 아닌 값을 입력했습니다.");
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
