package without_class;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1;
        int num2;
        char operator;
        double answer = 0;

        while (true) {
            // 양의 정수(0 포함) 입력받기
            do {
                System.out.print("첫 번째 0이상의 정수를 입력하세요: ");
                num1= scanner.nextInt();
                scanner.nextLine(); // 개행 문자 처리
            } while (num1 < 0);

            do {
                System.out.print("두 번째 0이상의 정수를 입력하세요: ");
                num2= scanner.nextInt();
                scanner.nextLine(); // 개행 문자 처리
            } while (num2 < 0);

            // 사칙연산 기호 입력받기 (+, -, *, /)
            do {
                System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
                operator = scanner.nextLine().charAt(0);
            } while (!(operator == '+' || operator == '-' || operator == '*' || operator == '/'));

            // 사칙연산 나눗셈 입력받은 경우, 두 번째 정수가 0이면 재입력 받음
            if (operator == '/' && num2 == 0) {
                while (num2 == 0) {
                    System.out.print("나눗셈 연산에서 분모(두 번째 정수)는 0이 입력될 수 없습니다. 두 번째 정수 다시 입력하세요: ");
                    num2 = scanner.nextInt();
                    scanner.nextLine(); // 개행 문자 처리
                }
            }

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

            System.out.println("결과: " + answer);

            // 계산 종료
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            if (scanner.nextLine().equals("exit")) {
                break;
            }
        }
    }
}
