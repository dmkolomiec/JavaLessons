package step2;

class Car {
    int year;
    String color;
    public Car() {
        System.out.println("Constructor 1");
    }
    public Car(int year) {
        this.year = year;
        System.out.println("Constructor 2");
    }
    public Car(int year, String color) {
        this.year = year;
        this.color = color;
        System.out.println("Constructor 3");
    }
}
public class Main {
    public static void main(String[] args) {
        Car c0 = new Car(),
                c1 = new Car(2013),
                c2 = new Car(2020, "Red");
    }
}
