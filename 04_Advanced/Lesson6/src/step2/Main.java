package step2;

import java.lang.reflect.Method;

/**
 *  Program entry class
 */
public class Main {
    /**
     * Start method
     * @param args not used in the current project
     */
    public static void main(String[] args) {
        System.out.println(new Calculator().run(1, 2, ArithmeticOperator.UNKNOWN));
        System.out.println(new Calculator().run(1, 2, ArithmeticOperator.DIVIDE));

        Calculator calculator = new Calculator();
        Class<?> c = calculator.getClass();

        Method m;
        try {
            m = c.getMethod("run", double.class, double.class, ArithmeticOperator.class);
            MethodAnnotation methodAnnotation = m.getAnnotation(MethodAnnotation.class);
            calculator.run(methodAnnotation.p1(), methodAnnotation.p2(), methodAnnotation.operator());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
