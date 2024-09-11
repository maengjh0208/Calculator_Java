package challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticCalculator {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArithmeticCalculator a = new ArithmeticCalculator();

        while (true) {
            try {
                // 피연산자 및 연산자 입력받기
                int num1 = a.validateNum(br, 1);
                int num2 = a.validateNum(br, 2);
                char operator = a.validateChar(br);

                double result = a.operate(operator, num1, num2);
                System.out.println("결과값: " + result);

                // 계산기 종료
                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
                if (br.readLine().equals("exit")) {
                    break;
                }

                System.out.println();
            }
            catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

    public int validateNum(BufferedReader reader, int idx) throws Exception {
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

    public char validateChar(BufferedReader reader) throws Exception {
        System.out.print("사칙연산 기호(+, -, *, /) 입력: ");
        char operator = reader.readLine().charAt(0);

        if (!(operator == '+' || operator == '-' || operator == '*' || operator == '/')) {
            throw new IllegalArgumentException("[ERROR] 사칙연산 기호는 +, -, *, / 중 하나를 입력해야 합니다.");
        }

        return operator;
    }

    public double operate(char operator, int num1, int num2) {
        OperatorType type = OperatorType.getOperatorType(operator);
        double result = 0;

        if (type == OperatorType.ADD) {
            result = num1 + num2;
        } else if (type == OperatorType.SUBTRACT) {
            result = num1 - num2;
        } else if (type == OperatorType.MULTIPLY) {
            result = num1 * num2;
        } else if (type == OperatorType.DIVIDE) {
            if (num2 == 0) {
                throw new ArithmeticException("0 으로 나눌 수 없습니다.");
            }

            result = (double) num1 / num2;
        }

        return result;
    }
}
