package challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class App {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator();
        App app = new App();

        while (true) {
            try {
                // 피연산자 및 연산자 입력받기
                double num1 = app.validateDouble(br, 1);
                double num2 = app.validateDouble(br, 2);
                char operator = app.validateChar(br);

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
        List<Double> results2 = calculator.getGoeList(3.0);
        System.out.println(results2);
    }

    public double validateDouble(BufferedReader br, int idx) throws Exception {
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

//    public int validateNum(BufferedReader reader, int idx) throws Exception {
//        try {
//            System.out.print(idx + "번째 정수(0 포함)를 입력: ");
//            int num = Integer.parseInt(reader.readLine());
//
//            /* 입력받은 정수의 유효성 검증 */
//            if (num < 0) {
//                throw new IllegalArgumentException("[ERROR] 0 이상의 정수여야 합니다. 입력받은 정수: " + num);
//            }
//
//            return num;
//
//        } catch (NumberFormatException e) {
//            throw new NumberFormatException("[ERROR] 정수가 아닌 값을 입력했습니다.");
//        }
//    }

    public char validateChar(BufferedReader reader) throws Exception {
        System.out.print("사칙연산 기호(+, -, *, /) 입력: ");
        char operator = reader.readLine().charAt(0);

        if (!(operator == '+' || operator == '-' || operator == '*' || operator == '/')) {
            throw new IllegalArgumentException("[ERROR] 사칙연산 기호는 +, -, *, / 중 하나를 입력해야 합니다.");
        }

        return operator;
    }
}
