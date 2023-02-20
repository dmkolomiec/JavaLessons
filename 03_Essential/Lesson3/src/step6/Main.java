// Завдання 6. Створити клас Printer...
package step6;

class Printer {
    static final String ANSI_RESET = "\u001B[0m",
                         ANSI_RED = "\u001B[31m",
                         ANSI_GREEN = "\u001B[32m",
                         ANSI_CYAN = "\u001B[36m",
                         ANSI_YELLOW = "\u001B[33m";
    void print(String value) { System.out.println(value); }
}
class PrinterRed extends Printer {
    @Override
    void print(String value) { System.out.println(ANSI_RED + value + ANSI_RESET); }
}

class PrinterGreen extends Printer {
    @Override
    void print(String value) { System.out.println(ANSI_GREEN + value + ANSI_RESET); }
}
class PrinterCyan extends Printer {
    @Override
    void print(String value) { System.out.println(ANSI_CYAN + value + ANSI_RESET); }
}

class PrinterYellow extends Printer {
    @Override
    void print(String value) { System.out.println(ANSI_YELLOW + value + ANSI_RESET); }
}

public class Main {
    public static void main(String[] args) {
        new PrinterRed().print("Red line");
        new PrinterGreen().print("Green line");
        new PrinterCyan().print("Cyan line");
        new PrinterYellow().print("Yellow line");
    }
}
