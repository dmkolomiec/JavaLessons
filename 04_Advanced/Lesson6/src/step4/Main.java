/**
 * Завдання 4. Створити свою інструкцію, яка міститиме параметри для методу, виконати додавання 2-х чисел.
 *      @Math(num1 = 100, num2 = 200)
 *      public void mathSum(int num1, int num2)
 */
package step4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Math {
    int num1() default 100;

    int num2() default 200;
}

class TestClass {
    @Math // (num1 = 300, num2 = 400)
    public void mathSum(int num1, int num2) {
        System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
    }
}

public class Main {
    public static void main(String[] args) {
        TestClass tc = new TestClass();
        Class<?> c = TestClass.class;
        Math annotation;

        try {
            Method method = c.getDeclaredMethod("mathSum", int.class, int.class);

            if (method.isAnnotationPresent(Math.class)) {
                annotation = method.getAnnotation(Math.class);
                method.invoke(tc, annotation.num1(), annotation.num2());
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}