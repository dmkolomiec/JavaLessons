package step3;

public class Car implements Comparable<Car> {
    int speed, price;
    String model, color;

    Car(int speed, int price, String model, String color) {
        this.speed = speed;
        this.price = price;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-8s %4d %6d", this.model, this.color, this.speed, this.price);
    }

    // Сортуємо за: швидкістю -> ціною -> моделі -> кольору машини.
    @Override
    public int compareTo(Car o) {

        int temp = this.speed - o.speed;
        if (temp != 0) return temp;

        temp = this.price - o.price;
        if (temp != 0) return temp;

        temp = this.model.compareTo(o.model);
        if (temp != 0) return temp;

        return this.color.compareTo(o.color);
    }
}
