/* Завдання 2. Створіть проєкт за допомогою IntelliJ IDEA. Потрібно:
   Створити клас Vehicle із методом print. У класі Vehicle створіть внутрішні класи Wheel і Door, які також
   мають містити метод print. Створіть екземпляри класів Wheel і Door.
*/
package static_nested_classes.step2;

class Vehicle {
    void print() {
        System.out.println(this.getClass().getSimpleName() + "::print");
    }

    class Wheel {
        void print() {
            System.out.println(this.getClass().getSimpleName() + "::print");
        }
    }

    class Door {
        void print() {
            System.out.println(this.getClass().getSimpleName() + "::print");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Vehicle.Wheel wheel1 = new Vehicle().new Wheel();
        Vehicle.Door door1 = new Vehicle().new Door();
        wheel1.print();
        door1.print();
    }
}
