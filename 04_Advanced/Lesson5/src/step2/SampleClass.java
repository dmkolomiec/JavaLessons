package step2;
public class SampleClass {
    public static final String className = "Це тестовий клас";
    public String name = "Marsel";
    private int age = 5;
    short ears = 5;
    protected long tail = 30;
    int[] intArray;

    public SampleClass() {
    }

    public SampleClass(int age) {
        this.age = age;
    }

    public SampleClass(String name, int age, short ears, long tail) {
        this.name = name;
        this.age = age;
        this.ears = ears;
        this.tail = tail;
        intArray = new int[3];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public short getEars() {
        return ears;
    }

    public void setEars(short ears) {
        this.ears = ears;
    }

    public long getTail() {
        return tail;
    }

    public void setTail(long tail) {
        this.tail = tail;
    }

    /**
     * Внутрішній клас
     */
    class InnerSampleClass {
        public int field1;

        public InnerSampleClass(int field1) {
            this.field1 = field1;
        }

        class DoubleInnerSampleClass {
            public String field1;

            public DoubleInnerSampleClass(String field1) {
                this.field1 = field1;
            }
        }
    }

    /**
     * Вкладений клас
     */
    public static class staticInnerSampleClass {
        private final String field1;

        public staticInnerSampleClass(String field1) {
            this.field1 = field1;
        }
    }
}
