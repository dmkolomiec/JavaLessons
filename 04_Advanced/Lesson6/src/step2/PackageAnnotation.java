package step2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Simple annotation for package step2
 * @see step2
 */
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)

public @interface PackageAnnotation {
    /**
     * @return  Sequential revision number
     */
    int revision() default 0;

    /**
     * @return String array of reviewers
     */
    String[] reviewers() default {"Yuri Stojan", "Konstantin Panchenko"};
}

