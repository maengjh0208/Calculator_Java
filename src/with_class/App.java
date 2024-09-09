package with_class;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1;
        int num2;
        char operator;
        double answer = 0;

        while (true) {
            // 사칙연산 기호 입력받기 (+, -, *, /)
            do {
                System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
                operator = scanner.nextLine().charAt(0);
            } while (!(operator == '+' || operator == '-' || operator == '*' || operator == '/'));

            // 양의 정수(0 포함) 입력받기
            do {
                System.out.print("첫 번째 0이상의 정수를 입력하세요: ");
                num1= scanner.nextInt();
            } while (num1 < 0);

            do {
                System.out.print("두 번째 0이상의 정수를 입력하세요: ");
                num2= scanner.nextInt();

                if (operator == '/' && num2 == 0) {
                    System.out.println("- 나눗셈 연산에서 분모(두 번째 정수)는 0이 입력될 수 없습니다. (재입력 필요)");
                }
            } while (num2 < 0 || (operator == '/' && num2 == 0));

            // 입력받은 양의 정수 2개와 사칙연산 기호를 사용해서 연산 진행 및 출력하기
            if (operator == '+') {
                answer = num1 + num2;
            } else if (operator == '-') {
                answer = num1 - num2;
            } else if (operator == '*') {
                answer = num1 * num2;
            } else if (operator == '/') {
                answer = (double) num1 / num2;
            }

            System.out.println("결과 (double type): " + answer);

            // 계산 종료
            scanner.nextLine();
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            if (scanner.nextLine().equals("exit")) {
                break;
            }
        }
    }
}
