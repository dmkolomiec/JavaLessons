package step2;

/**
 * enum for arithmetic operations
 * @see step2.Calculator#run(double, double, ArithmeticOperator) 
 */
public enum ArithmeticOperator {
    /**
     * Adding operator
     */
    ADD,
    /**
     * Divide operator
     */
 DIVIDE,
    /**
     * Multiplying operator
     */
 MULTIPLY,
    /**
     * Subtraction operator
     */
 SUBTRACT,
    /**
     *  I don't know what is going on here
     */
 UNKNOWN
}
