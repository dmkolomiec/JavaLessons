package Lesson1_2;
import java.util.Scanner;

class Rectangle {
    private double side1,side2;
    public Rectangle(double s1, double s2) {
        side1 = s1;
        side2 = s2;
    }
    public static double areaCalculator(double side1 , double side2) {
        return side1 * side2;
    }
    public static double perimeterCalculator(double side1 , double side2) {
        return (side1 + side2)*2;
    }
    public double areaCalculator() {
        return areaCalculator(this.side1, this.side2);
    }
    public double perimeterCalculator() {
        return perimeterCalculator(this.side1, this.side2);
    }
    public void Print() {
        System.out.printf("Площа прямокутника: %.4f\n", areaCalculator());
        System.out.printf("Периметр прямокутника: %.4f\n", perimeterCalculator());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double s1, s2;
        Rectangle r;

        System.out.print("Введіть довжину першої сторони: ");
        s1 = input.nextDouble();

        System.out.print("Введіть довжину другої сторони: ");
        s2 = input.nextDouble();

        r = new Rectangle(s1, s2);
        r.Print();
        // Static
    }
}
