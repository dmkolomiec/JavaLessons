/*
Завдання 4. Створіть проект за допомогою IntelliJ IDEA. Створіть перечислювальний тип (enum) Vehicles, що містить конструктор,
        який повинен набувати цілого числа (вартість автомобіля), містити метод getColor(), який повертає рядок з кольором автомобіля,
        і містити перевантажений метод toString(), який повинен повертати рядок з назвою екземпляра, кольором та вартістю автомобіля.
*/
package enumerates.step4;

enum Vehicles {
    CHEVROLET_AVEO(3000) {
        public String getColor() {
            return "бірюзовий";
        }
    }, MITSUBISHI_OUTLENDER(9000) {
        public String getColor() {
            return "жовтий";
        }
    }, TOYOTA_RAV4(15000) {
        public String getColor() {
            return "червоний";
        }

    };
    private final int cost;

    Vehicles(int cost) {
        this.cost = cost;
    }

    public abstract String getColor();

    @Override
    public String toString() {
        return String.format("%-20s %6d (%s)", this.name(), this.cost, getColor());
    }
}

public class Main {
    public static void main(String[] args) {

        for (Vehicles vehicle : Vehicles.values())
            System.out.println(vehicle.toString());

        System.out.println("------");
        Vehicles v = Vehicles.CHEVROLET_AVEO;
        System.out.printf("%s\n%s\n", v, v.getColor());
    }
}

