/*
Завдання 2. Створити класи: 1) Основний клас Device (manufacturer(String), price(float), serialNumber(String));
                            2) Сабклас Monitor (resolutionX(int), resolutionY(int))
                            3) і EthernetAdapter (speed(int), mac(String)); Додати методи доступу. Конструктор.
Завдання 3. Дивитися завдання 2. В обох класах перевизначити метод toString, щоб висновок був наступним:
            Device: manufacturer = Samsung, price = 120, serialNumber=AB1234567CD, X=1280,Y=1024.
Завдання 4. Подивитися завдання 2. Перевизначити методи equals & hashCode у кожному класі. Створити клас Main, де створити об'єкти класів і продемонструвати перевизначені методи.
 */
package step2_4;

import java.util.Objects;

class Device {
    protected String manufacturer, serialNumber;
    protected float price;

    public Device(String manufacturer, String serialNumber, float price) {
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    protected String specifications() {
        return "manufacturer=" + manufacturer + ", serialNumber=" + serialNumber + ", price=" + price;
    }

    @Override
    public String toString() {
        return "Device: " + specifications();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (Float.compare(device.price, price) != 0) return false;
        if (!Objects.equals(manufacturer, device.manufacturer)) return false;
        return Objects.equals(serialNumber, device.serialNumber);
    }

    @Override
    public int hashCode() {
        int result = 17 + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        return result;
    }
}

class Monitor extends Device {
    protected int resolutionX, resolutionY;

    public Monitor(String manufacturer, String serialNumber, float price, int resolutionX, int resolutionY) {
        super(manufacturer, serialNumber, price);
        this.resolutionX = resolutionX;
        this.resolutionY = resolutionY;
    }

    public int getResolutionX() {
        return resolutionX;
    }

    public int getResolutionY() {
        return resolutionY;
    }

    @Override
    protected String specifications() {
        return "X=" + resolutionX + ", Y=" + resolutionY;
    }

    @Override
    public String toString() {
        return "Monitor: " + super.specifications() + ", " + specifications();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Monitor monitor = (Monitor) o;

        if (resolutionX != monitor.resolutionX) return false;
        return resolutionY == monitor.resolutionY;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + resolutionX;
        result = 31 * result + resolutionY;
        return result;
    }
}

class EthernetAdapter extends Device {
    protected int speed;
    protected String mac;

    public EthernetAdapter(String manufacturer, String serialNumber, float price, int speed, String mac) {
        super(manufacturer, serialNumber, price);
        this.speed = speed;
        this.mac = mac;
    }

    public int getSpeed() {
        return speed;
    }

    public String getMac() {
        return mac;
    }

    @Override
    protected String specifications() {
        return "speed=" + speed + ", mac=" + mac;
    }

    @Override
    public String toString() {
        return "EthernetAdapter: " + super.specifications() + ", " + specifications();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EthernetAdapter that = (EthernetAdapter) o;

        if (speed != that.speed) return false;
        return Objects.equals(mac, that.mac);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + speed;
        result = 31 * result + (mac != null ? mac.hashCode() : 0);
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Device monic1 = new Monitor("Samsung", "AB1234567CD", 120, 1280, 1024);
        Device monic2 = new Monitor("Samsung", "AB1234567CD", 120, 1280, 1024);
        Device adic = new EthernetAdapter("TP-Link", "123qwe", 2500, 600, "1C-B1-0D-C5-4C-49");

        System.out.println("------------ Монитор №1");
        System.out.println(monic1);
        System.out.println("hashcode = " + monic1.hashCode());

        System.out.println("------------ Монитор №2");
        System.out.println(monic2);
        System.out.println("hashcode = " + monic2.hashCode());

        System.out.println("\nМонитор №1.equals(Монитор №2) = " + monic1.equals(monic2) + "\n");

        monic2.setPrice(130f);
        System.out.println("------------ Монитор №2");
        System.out.println(monic2);
        System.out.println("hashcode = " + monic2.hashCode());
        System.out.println("\nМонитор №1.equals(Монитор №2) = " + monic1.equals(monic2) + "\n");

        System.out.println("------------ Мер.адаптер");
        System.out.println(adic);
        System.out.println("hashcode = " + adic.hashCode());


    }
}
