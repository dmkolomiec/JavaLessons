package step2;

public class Main {
    public static void main(String[] args) {
       String filename =  AnimalShelter.class.getSimpleName() + ".bin";

        AnimalShelter shelter1 = new AnimalShelter(5, "Somewhere");
        shelter1.add(new Cat("Безпородний", 3, true, "Рижик"));
        shelter1.add(new Cat("Безпородний", 6, true, "Пушок"));
        shelter1.add(new Cat("Сіамська", 10, false, "Матільда"));
        shelter1.add(new Dog("Безпородний", 4, true, "Том"));

        System.out.println(shelter1);
        shelter1.saveToFile(filename);

        AnimalShelter shelter2 = AnimalShelter.loadFromFile(filename);
        System.out.println(shelter2);
    }
}
