package step2;

import java.io.*;
import java.util.ArrayList;

public class AnimalShelter implements Serializable {
    private int capacity;
    private transient String address;
    private ArrayList<Animal> animals;

    public AnimalShelter(int capacity, String address) {
        this.capacity = capacity;
        this.address = address;
        animals = new ArrayList<>(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return animals.size();
    }

    public boolean add(Animal animal) {
        if (getSize() == getCapacity())
            return false;
        return animals.add(animal);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("AnimalShelter{" +
                "\n capacity= " + capacity +
                "\n address= " + address +
                "\n animals=\n");
        for (Animal animal : animals) result.append("\t").append(animal).append("\n");
        return result.toString() + '}';
    }

    public void saveToFile(String filename) {
        File file = new File(filename);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static AnimalShelter loadFromFile(String filename) {
        File file = new File(filename);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (AnimalShelter) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
