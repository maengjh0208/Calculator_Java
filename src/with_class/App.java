package with_class;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Calculator calculator = new Calculator();
        boolean isFirst = true;

        while (true) {
            try {
                if (!isFirst) {
                    System.out.println("현재까지 계산된 정보: " + calculator.getCalculationResults());
                }

                isFirst = false;

                // 피연산자 및 연산자 입력받기
                int num1 = InputParser.getValidateNum(br, 1);
                int num2 = InputParser.getValidateNum(br, 2);
                char operator = InputParser.getValidateChar(br);

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
    }
}
