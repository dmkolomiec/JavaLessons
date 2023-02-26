/*
Завдання 3. Створіть проєкт за допомогою IntelliJ IDEA. Потрібно:
        Створити клас Distance із полем distance типу double та методом print. У класі Distance створіть статичний
        клас Converter з методами, які конвертуватимуть відстань у різні одиниці виміру (наприклад, з метрів на
        кілометри, з кілометрів на милі й так далі).
*/
package static_nested_classes.step3;

class Distance {
    private final double distance;

    Distance(double distance) {
        this.distance = distance;
    }

    void print() {
        System.out.println(this.distance);
    }

    public double getDistance() {
        return distance;
    }

    public static class Converter {
        public static double convertMeters2Kilometers(double prm) {
            double retval = prm * 0.001;
            System.out.printf("%.4f м = %.4f км\n", prm, retval);
            return retval;
        }

        public static double convertKilometers2Miles(double prm) {
            double retval = prm * 0.6214;
            System.out.printf("%.4f км = %.4f миль\n", prm, retval);
            return retval;
        }

        public static double convertMillimeters2Inches(double prm) {
            double retval = prm / 25.4;
            System.out.printf("%.4f мм = %.4f дюйм\n", prm, retval);
            return retval;
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Distance d = new Distance(100);
        Distance.Converter.convertMeters2Kilometers(d.getDistance());
        Distance.Converter.convertKilometers2Miles(d.getDistance());
        Distance.Converter.convertMillimeters2Inches(50.8);
    }
}
