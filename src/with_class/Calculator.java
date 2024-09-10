package with_class;

import java.util.ArrayList;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private ArrayList<Double> calculationResults = new ArrayList<>();

    public double operate(char operator, int num1, int num2) {
        double answer = 0;

        if (operator == '+') {
            answer = num1 + num2;
        } else if (operator == '-') {
            answer = num1 - num2;
        } else if (operator == '*') {
            answer = num1 * num2;
        } else if (operator == '/') {
            answer = (double) num1 / num2;
        }

        calculationResults.add(answer);
        return answer;
    }

    public ArrayList<Double> getCalculationResults() {
        return calculationResults;
    }

    public void setCalculationResults(ArrayList<Double> calculationResults) {
        this.calculationResults = calculationResults;
    }

    public boolean removeFirstResult() {
        if (!calculationResults.isEmpty()) {
            calculationResults.remove(0);
            return true;
        } else {
            return false;
        }
    }
}
