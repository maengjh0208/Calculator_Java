package challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private final List<Double> results = new ArrayList<>();

    public double operate(char operator, T num1, T num2) {
        OperatorType type = OperatorType.getOperatorType(operator);
        double result = 0;

        if (type == OperatorType.ADD) {
            result = num1.doubleValue() + num2.doubleValue();
        } else if (type == OperatorType.SUBTRACT) {
            result = num1.doubleValue() - num2.doubleValue();
        } else if (type == OperatorType.MULTIPLY) {
            result = num1.doubleValue() * num2.doubleValue();
        } else if (type == OperatorType.DIVIDE) {
            if (num2.doubleValue() == 0) {
                throw new ArithmeticException("[ERROR] 0 으로 나눌 수 없습니다.");
            }

            result = num1.doubleValue() / num2.doubleValue();
        }

        this.results.add(result);

        return result;
    }

    public List<Double> getResults() {
        return this.results;
    }

    public void setResults(double num) {
        this.results.add(num);
    }

    public List<Double> getGoeList(Double targetNum) {
        return this.results.stream()
                .filter(result -> result > targetNum)
                .collect(Collectors.toList());
    }
}
