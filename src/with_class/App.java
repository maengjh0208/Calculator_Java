package with_class;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("1 번째 숫자 입력 (0 이상 정수값): ");
            int num1 = scanner.nextInt();

            System.out.print("2 번째 숫자 입력 (0 이상 정수값): ");
            int num2 = scanner.nextInt();

            System.out.print("사칙연산 기호(+, -, *, /) 입력: ");
            scanner.nextLine();
            char operator = scanner.nextLine().charAt(0);

            double result = calculator.operate(operator, num1, num2);
            System.out.println("결과값: " + result);

            // 반복문 종료
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            if (scanner.nextLine().equals("exit")) {
                break;
            }
        }
//        System.out.println(calculator.removeFirstResult());
//        System.out.println(calculator.getCalculationResults());
    }
}
