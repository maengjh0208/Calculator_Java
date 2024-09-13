package challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class App {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            try {
                // 피연산자 및 연산자 입력받기
                double num1 = InputParser.getValidateDouble(br, 1);
                double num2 = InputParser.getValidateDouble(br, 2);
                char operator = InputParser.getValidateChar(br);

                // 제네릭 테스트
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

        List<Double> results = calculator.getResults();
        for (Double result : results) {
            System.out.print(result + " ");
        }

        System.out.println();

        // 람다, 스트림 테스트 (N보다 큰 숫자만 조회)
        List<Double> results2 = calculator.getGoeList(3);
        System.out.println(results2);
    }
}
