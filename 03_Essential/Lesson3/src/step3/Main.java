package step3;
// Потрібно: Створити клас Vehicle. У тілі класу створіть поля: координати та параметри суден (ціна, швидкість, рік випуску).
// Створіть 3 похідних класи Plane, Саг та Ship. Для класу Plane має бути визначена висота та кількість пасажирів.
// Для класу Ship – кількість пасажирів та порт приписки. Написати програму, яка виводить на екран інформацію про кожен засіб пересування.
class Vehicle {
    int latitude, longitude,   price, speed, year;
    public Vehicle(int price, int speed, int year) {
        this.price = price;
        this.speed = speed;
        this.year = year;
    }
    void Print() {
        System.out.printf("Ціна: %,d   Швидкість %d   Рік: %d\n", this.price, this.speed, this.year);
    }
}
class Plane extends Vehicle {
    int height, passCapacity;
    public Plane(int price, int speed, int year, int height, int passCapacity) {
        super(price, speed, year);
        this.height = height;
        this.passCapacity = passCapacity;
    }
    void  Print() {
        System.out.println("-----Літак");
        super.Print();
        System.out.printf("Висота: %d   Пасс.%d\n", this.height, this.passCapacity);
    }
}
class Car extends Vehicle {
    public Car(int price, int speed, int year) {
        super(price, speed, year);
    }
    void Print() {
        System.out.println("----- Автомобіль");
        super.Print();
    }
}
class Ship extends Vehicle {
    int passCapacity;
    String homePort;

    public Ship(int price, int speed, int year, int passCapacity, String homePort) {
        super(price, speed, year);
        this.passCapacity = passCapacity;
        this.homePort = homePort;
    }
    void  Print() {
        System.out.println("-----Судно");
        super.Print();
        System.out.printf("Пасс.%d  Порт:%s\n", this.passCapacity, this.homePort);
    }
}
public class Main {
    public static void main(String[] args) {
        Vehicle[] v = new Vehicle[4];

        v[0] = new Plane(30000000, 700, 1990,    10000, 120);
        v[1] = new Car( 5000,       160, 2010);
        v[2] = new Car(20000,       200, 2020);
        v[3] = new Ship(5000000,    50, 1980,1000, "Λάρνακα");

        for (Vehicle vehicle: v)
            vehicle.Print();
    }
}
