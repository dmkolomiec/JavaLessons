package step2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for method Calculator.run(double, double, char)
 * @see step2.Calculator#run(double, double, ArithmeticOperator)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {
    /**
     * @return First operand
     */
    double p1();
    /**
     * @return Second operand
     */
    double p2();
    /**
     * @return Arithmetic operator
     */
    ArithmeticOperator operator() default ArithmeticOperator.ADD;
}
