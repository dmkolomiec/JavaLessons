package Lesson1_5;
//import java.awt.print.Printable;
/*
Потрібно: Створити клас із ім'ям Address. У тілі класу потрібно створити поля: index, country, city, street, house, apartment.
Для кожного поля створити метод з двома методами доступу (get, set) Створити екземпляр класу Address.
У поля екземпляра записати інформацію про поштову адресу. Виведіть на екран значення полів, що описують адресу.
*/
class Address {
    private String index, country, city, street;
    private int house, apartment;

    public String getIndex() { return index; }
    public void setIndex(String index) { this.index = index; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public int getHouse() { return house; }
    public void setHouse(int house) { this.house = house; }
    public int getApartment() { return apartment; }
    public void setApartment(int apartment) { this.apartment = apartment; }

    public void setAll(String index, String country, String city, String street, int house, int apartment) {
        this.setIndex    (index);
        this.setCountry  (country);
        this.setCity     (city);
        this.setStreet   (street);
        this.setHouse    (house);
        this.setApartment(apartment);
    }
    public Address(String index, String country, String city, String street, int house, int apartment) {
        this.setAll(index, country, city, street, house, apartment);
    }

    public void Print() {
        System.out.printf("Індекс: %s   Держава: %s   Місто: %s\nВулиця: %s   Буд.%d    Кв.%d\n\n",
                this.getIndex(), this.getCountry(), this.getCity(), this.getStreet(), this.getHouse(), this.getApartment());
    }
}
public class Main {
    public static void main(String[] args) {
        Address a = new Address("04212", "Україна", "Київ", "Левка Лук'яненка", 8, 96);
        a.Print();

        a.setStreet("------Набережно-Лугова------");
        a.Print();
    }
}
