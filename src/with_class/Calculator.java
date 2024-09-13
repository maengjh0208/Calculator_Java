package with_class;

import java.util.ArrayList;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private ArrayList<Double> resultHistory = new ArrayList<>();

    public double operate(char operator, int num1, int num2) {
        double answer = OperatorType.getOperation(operator).operate(num1, num2);
        resultHistory.add(answer);

        return answer;
    }

    public ArrayList<Double> getCalculationResults() {
        /* 연산 결과 리스트 반환 */
        return resultHistory;
    }

    public void setCalculationResults(ArrayList<Double> resultHistory) {
        /* 연산 결과 리스트 수정 */
        this.resultHistory = resultHistory;
    }

    public boolean removeFirstResult() {
        /* 연산 결과 리스트에서 첫 번째 연산 결과 제거 */
        if (!resultHistory.isEmpty()) {
            resultHistory.remove(0);
            return true;
        } else {
            return false;
        }
    }
}
