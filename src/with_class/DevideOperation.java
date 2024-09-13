package with_class;

public class DevideOperation implements Operation {
    @Override
    public double operate(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("0 으로 나눌 수 없습니다.");
        }

        return a / b;
    }
}
