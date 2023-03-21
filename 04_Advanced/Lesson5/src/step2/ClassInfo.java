package step2;

import java.lang.reflect.*;

public class ClassInfo {
    Class<?> c;
    boolean isPrintPackage;
    int indentLevel;

    static final String ANSI_RESET = "\u001B[0m",
                        ANSI_RED = "\u001B[31m";


    public ClassInfo(String fullClassName, boolean isPrintPackage, int indentLevel) throws ClassNotFoundException {
        c = Class.forName(fullClassName);
        this.isPrintPackage = isPrintPackage;
        this.indentLevel = indentLevel;
    }

    public ClassInfo(Class<?> c, boolean isPrintPackage, int indentLevel) {
        this.c = c;
        this.isPrintPackage = isPrintPackage;
        this.indentLevel = indentLevel;
    }

    /**
     * @param fullClassName  повне ім'я класу
     * @param isPrintPackage друкувати ім'я пакета в іменах класів
     */
    public static void check(String fullClassName, boolean isPrintPackage) {
        System.out.println("----------");
        try {
            System.out.println(new ClassInfo(fullClassName, isPrintPackage, 0));
        } catch (ClassNotFoundException e) {
            System.out.println("Невідомий клас: " + fullClassName);
        }
    }

    /**
     * @param c              посилання на об'єкт Class
     * @param isPrintPackage друкувати ім'я пакета в ім'ях класів
     */
    public static void check(Class<?> c, boolean isPrintPackage) {
        System.out.println("----------");
        System.out.println(new ClassInfo(c, isPrintPackage, 0));
    }

    String makeIndent(int additionalIndent) {
        StringBuilder retval = new StringBuilder();
        int indent = indentLevel + additionalIndent;
        while (indent-- > 0) retval.append("\t");
        return retval.toString();
    }

    String GetCommonModifiersString(int m) {
        return (Modifier.isPrivate(m) ? "private " : "") + (Modifier.isProtected(m) ? "protected " : "") + (Modifier.isPublic(m) ? "public " : "") + (Modifier.isAbstract(m) ? "abstract " : "") + (Modifier.isStatic(m) ? "static " : "") + (Modifier.isFinal(m) ? "final " : "") + (Modifier.isNative(m) ? "native " : "");
    }

    String GetClassModifiersString(int m) {
        return (Modifier.isInterface(m) ? "interface " : "class ");
    }

    String GetImplementsString() {
        StringBuilder retval = new StringBuilder();
        Class<?> sc = c.getSuperclass();
        if (sc != null && sc != Object.class)
            retval = new StringBuilder("extends " + (isPrintPackage ? sc.getName() : sc.getSimpleName()) + " ");

        Class<?>[] in = c.getInterfaces();
        for (int i = 0; i < in.length; i++)
            retval.append(i == 0 ? "implements " : "").append(isPrintPackage ? in[i].getName() : in[i].getSimpleName()).append(i == in.length - 1 ? " " : ", ");

        return retval.toString();
    }

    String getClassHeader() {
        return ANSI_RED +
                makeIndent(0) + GetCommonModifiersString(c.getModifiers()) + // модифікатори доступу
                GetClassModifiersString(c.getModifiers()) + // модифікатори класу інші
                (isPrintPackage ? c.getName() : c.getSimpleName()) + " " +  // клас
                GetImplementsString() + // супер-клас + implements
                ANSI_RESET + "{\n";
    }

    String getClassFields() {
        StringBuilder retval = new StringBuilder();

        Field[] f = c.getDeclaredFields();
        for (int i = 0; i < f.length; i++) {
            if (i == 0) retval.append(makeIndent(1)).append("// Fields\n");
            retval.append(makeIndent(1)).append(GetCommonModifiersString(f[i].getModifiers())).append(isPrintPackage ? f[i].getType().getName() : f[i].getType().getSimpleName()).append(" ").append(f[i].getName()).append(";\n");
        }
        return retval.toString();
    }

    String getClassClasses() {
        StringBuilder retval = new StringBuilder();
        ClassInfo ic;

        Class<?>[] cc = c.getDeclaredClasses();
        for (int i = 0; i < cc.length; i++) {
            if (i == 0) retval.append(makeIndent(1)).append("// Classes\n");

            try {
                ic = new ClassInfo(cc[i].getName(), isPrintPackage, indentLevel + 1);
                retval.append(ic.getClassInfo());

            } catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }
        return retval.toString();
    }


    String getClassMethods() {
        StringBuilder retval = new StringBuilder();

        Method[] m = c.getDeclaredMethods();
        for (int i = 0; i < m.length; i++) {
            if (i == 0) retval.append(makeIndent(1)).append("// Methods\n");
            retval.append(makeIndent(1)).append(GetCommonModifiersString(m[i].getModifiers())).append(isPrintPackage ? m[i].getReturnType().getName() : m[i].getReturnType().getSimpleName()).append(" ").append(m[i].getName()).append("(");
            Parameter[] params = m[i].getParameters();
            for (int j = 0; j < params.length; j++)
                retval.append(j == 0 ? "" : ", ").append(params[j].getType().getSimpleName()).append(" ").append(params[j].getName());
            retval.append(");\n");
        }
        return retval.toString();
    }

    String getConstructors() {
        StringBuilder retval = new StringBuilder();

        Constructor<?>[] cn = c.getDeclaredConstructors();
        for (int i = 0; i < cn.length; i++) {
            if (i == 0) retval.append(makeIndent(1)).append("// Constructors\n");
            retval.append(makeIndent(1)).append(GetCommonModifiersString(cn[i].getModifiers())).append( // модифікатори доступу
                    c.getSimpleName()).append("(");
            Parameter[] params = cn[i].getParameters();
            for (int j = 0; j < params.length; j++)
                retval.append(j == 0 ? "" : ", ").append(params[j].getType().getSimpleName()).append(" ").append(params[j].getName());
            retval.append(");\n");
        }
        return retval.toString();
    }

    public String getClassInfo() {
        return getClassHeader() + getClassFields() + getConstructors() + getClassMethods() + getClassClasses();
    }

    @Override
    public String toString() {
        return getClassInfo();
    }
}
