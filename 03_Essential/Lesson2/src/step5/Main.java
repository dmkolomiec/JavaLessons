package step5;


class MyArea {
    static double PI = Math.PI;
    static double areaOfCircle(double radius) {
        return MyArea.PI * Math.pow(radius, 2);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.printf("1. %.4f\n", MyArea.areaOfCircle(1));
        System.out.printf("2. %.4f\n", MyArea.areaOfCircle(2));
    }
}
