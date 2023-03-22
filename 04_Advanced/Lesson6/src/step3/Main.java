/**
 * Завдання 3.
 * Створіть кілька класів, один клас успадковує інший і використовує інструкцію Inherited.
 * Крім цього, спробуйте ще в проєкті використовувати 5 різних інструкцій.
 */
package step3;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface SomeClassComment {
    String classNote();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface SomeMethodComment1 {
    String note();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface SomeMethodComment2 {
    String comment();
}


@SomeClassComment(classNote = "Class comment (inh)")
class BaseClass {
    @SomeMethodComment1(note = "Comment 1 for overriddenMethod in BaseClass")
    protected void overriddenMethod(int i) {
    }
}

class InheritedClass extends BaseClass {
    protected void notInheritedMethod() {
    }

    @Override
    @SomeMethodComment1(note = "Comment 1 for overriddenMethod in InheritedClass")
    @SomeMethodComment2(comment = "SomeComment 2")
    protected void overriddenMethod(int i) {
        super.overriddenMethod(i);
    }

    @Deprecated(forRemoval = true, since = "17")
    public void deprecatedMethod() {
    }
}

public class Main {
    public static void main(String[] args) {
        BaseClass obj = new InheritedClass(); // BaseClass()
        Class<?> c = obj.getClass();
        Method[] methods;
        Annotation[] annotations;

        System.out.println("Вся маячня класу " + c);
        annotations = c.getDeclaredAnnotations();
        for (Annotation a : annotations)
            System.out.println("\t" + a);

        methods = c.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("\tВся маячня методу " + m);
            annotations = m.getDeclaredAnnotations();
            for (Annotation a : annotations)
                System.out.println("\t\t" + a);
        }
    }
}
