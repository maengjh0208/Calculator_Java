package with_class;

public enum OperatorType {
    ADD('+', new AddOperation()),
    SUBTRACT('-', new SubstractOperation()),
    MULTIPLY('*', new MultipleOperation()),
    DIVIDE('/', new DevideOperation());

    private final char symbol;
    private final Operation operation;

    OperatorType(char symbol, Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operation getOperation(char operator) {
        for(OperatorType type : OperatorType.values()) {
            if (type.symbol == operator) {
                return type.operation;
            }
        }

        throw new IllegalArgumentException("해당하는 연산자가 없습니다. " + operator);
    }
}
