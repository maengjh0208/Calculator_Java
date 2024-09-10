package with_class;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Calculator calculator = new Calculator();
        App app = new App();
        boolean isFirst = true;

        while (true) {
            try {
                if (!isFirst) {
                    System.out.println("현재까지 계산된 정보: " + calculator.getCalculationResults());
                }

                isFirst = false;

                // 피연산자 및 연산자 입력받기
                int num1 = app.validateNum(br, 1);
                int num2 = app.validateNum(br, 2);
                char operator = app.validateChar(br);

                double result = calculator.operate(operator, num1, num2);
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
//        System.out.println(calculator.removeFirstResult());
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
}
