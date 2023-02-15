package step3;

class Car {
    int year;
    double speed;
    int weight;
    String color;
    public Car() {
        System.out.println("Constructor 0");
    }
    public Car(int year) {
        this.year = year;
        System.out.println("Constructor 1");
    }
    public Car(int year, double speed) {
        this.year = year;
        this.speed = speed;
        System.out.println("Constructor 2");
    }
    public Car(int year, double speed, int weight) {
        this.year = year;
        this.speed = speed;
        this.weight = weight;
        System.out.println("Constructor 3");
    }
    public Car(int year, double speed, int weight, String color) {
        this.year = year;
        this.speed = speed;
        this.weight = weight;
        this.color = color;
        System.out.println("Constructor 4");
    }
}
public class Main {
    public static void main(String[] args) {
        Car c0, c1, c2, c3, c4;
        c0 = new Car();
        System.out.println("------");
        c1 = new Car(2013);
        System.out.println("------");
        c2 = new Car(2013, 180f);
        System.out.println("------");
        c3 = new Car(2013, 160f, 1560);
        System.out.println("------");
        c4 = new Car(2013, 150f, 2300, "Red");
    }
}
