/* Завдання 5. Напишіть на ConverterTemperature клас для конвертації з градусів за Цельсієм в Кельвіни, Фаренгейти.
                У класу має бути метод convert, який робить конвертацію.
*/
package step5;

interface ConverterTemperature {
    void convert();
}
class Convert2Far implements ConverterTemperature{
    double celsius;
    public void convert() {
        double retval = (this.celsius*1.8) + 32;
        System.out.printf("%.2fºC = %.2fºF\n", celsius, retval);
    }
    public Convert2Far(double celsius) {
        this.celsius = celsius;
    }
}

class Convert2Kelv implements ConverterTemperature{
    double celsius;
    public void convert() {
        double retval = this.celsius + 273.15;
        System.out.printf("%.2fºC = %.2fºK\n", celsius, retval);
    }
    public Convert2Kelv(double celsius) {
        this.celsius = celsius;
    }
}

public class Main {
    public static void main(String[] args) {
        new Convert2Far(232.777).convert();
        new Convert2Kelv( 0).convert();
    }
}
