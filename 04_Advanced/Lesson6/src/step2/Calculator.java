package step2;

/**
 *  Signals that arithmetic operator symbol is invalid in Calculator.GetParams() method
 * @see Calculator#run(double, double, ArithmeticOperator)
 */
class InvalidOperatorException extends Exception {
    /**
     * @param operator Arithmetic operator
     */
    public InvalidOperatorException(ArithmeticOperator operator) {
        super("Непримустмимй оператор " + operator + ". Оператором може бути один з 4 типів {" + ArithmeticOperator.ADD + ", " +
                ArithmeticOperator.SUBTRACT + ", " + ArithmeticOperator.MULTIPLY + ", " + ArithmeticOperator.DIVIDE + "}");
    }
}

/**
 * Represents simple calculator with 4 arithmetic operations
 * @author Dmytro Kolomiiets
 *
 */
public class Calculator {

    /**
     * Result of arithmetic operation
     */
    private double result;

    /**
     *  Empty constructor - doing nothing.
     */
    public Calculator() {
    }

    /**
     * Performs an arithmetic operation
     * @param p1 First operand
     * @param p2 Second operand
     * @param operator An arithmetic operator
     * @throws InvalidOperatorException Не знаю, что тут надо писать
     */
    private void calculate(double p1, double p2, ArithmeticOperator operator) throws InvalidOperatorException {
        switch (operator) {
            case ADD -> result = p1 + p2;
            case SUBTRACT -> result = p1 - p2;
            case MULTIPLY -> result = p1 * p2;
            case DIVIDE -> result = p1 / p2;
            default -> throw new InvalidOperatorException(operator);
        }
    }

    /**
     * Prints arithmetic operands and result of the operation to the console
     * @param p1 First operand
     * @param p2 Second operand
     * @param operator An arithmetic operator
     */
    public void print(double p1, double p2, ArithmeticOperator operator) {
        System.out.println("====================");
        System.out.printf("%.4f %s %.4f = %.4f\n", p1, operator, p2, result);
        System.out.println("====================");
    }

    /**
     * @param p1 First operand
     * @param p2 Second operand
     * @param operator An arithmetic operator
     * @return An execution result: true - on success, false - on fail
     */
    @MethodAnnotation(p1 = 20, p2 = 10/*, operator = DIVIDE */)
    public boolean run(double p1, double p2, ArithmeticOperator operator) {
        try {
            calculate(p1, p2, operator);
            print(p1, p2, operator);
            return true;
        }catch (InvalidOperatorException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}