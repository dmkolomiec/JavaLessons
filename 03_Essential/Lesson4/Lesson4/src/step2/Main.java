/*
Завдання 2. Використовуючи IntelliJ IDEA, створіть проект. Потрібно: Створити клас AbstractHandler.
        У тілі класу створити методи void open(), void create(), void change(), void save().
        Створити похідні класи XMLHandler, TXTHandler, DOCHandler від базового класу AbstractHandler.
        Написати програму, яка виконуватиме визначення документа і для кожного формату мають бути методи відкриття, створення, редагування,
        збереження певного формату документа.
*/
package step2;

abstract class AbstractHandler {
    protected static String ext;
    protected String filename;
    abstract void open(); abstract void create(); abstract void change(); abstract void save();
    public AbstractHandler(String filename) {
        this.filename = filename;
    }
    public String getFilename() {
        return this.filename + "." + ext;
    }
}
class XMLHandler extends AbstractHandler {
    @Override
    void open() { System.out.println("\nOpen " + this.getFilename() + " file"); }
    @Override
    void create() { System.out.println("Create " + this.getFilename() + " file"); }
    @Override
    void change() { System.out.println("Change " + this.getFilename() + " file"); }
    @Override
    void save() { System.out.println("Save " + this.getFilename() + " file"); }
    public XMLHandler(String filename) {
        super(filename);
    }
    static { ext = "xml"; }
}
class TXTHandler extends AbstractHandler {
    @Override
    void open() { System.out.println("\nOpen " + this.getFilename() + " file"); }
    @Override
    void create() { System.out.println("Create " + this.getFilename() + " file"); }
    @Override
    void change() { System.out.println("Change " + this.getFilename() + " file"); }
    @Override
    void save() { System.out.println("Save " + this.getFilename() + " file"); }
    public TXTHandler(String filename) {
        super(filename);
    }
    static { ext = "txt"; }
}
class DOCHandler extends AbstractHandler {
    @Override
    void open() { System.out.println("\nOpen " + this.getFilename() + " file"); }
    @Override
    void create() { System.out.println("Create " + this.getFilename() + " file"); }
    @Override
    void change() { System.out.println("Change " + this.getFilename() + " file"); }
    @Override
    void save() { System.out.println("Save " + this.getFilename() + " file"); }
    public DOCHandler(String filename) {
        super(filename);
    }
    static { ext = "docx"; }
}
public class Main {
    public static void Test(String filename) {
        int index = filename.indexOf('.');
        if (index == -1) return;
        String ext = filename.substring(index+1).toLowerCase();
        AbstractHandler handler =
        switch (ext) {
            case "xml" -> new XMLHandler(filename);
            case "txt" -> new TXTHandler(filename);
            case "docx" -> new DOCHandler(filename);
            default -> null;
        };
        if (handler == null) return;

        handler.open();
        handler.change();
        handler.save();
    }
    public static void main(String[] args) {
        Test("Something.xml");
        Test("Текст.txt");
        Test("Документ.docx");
        Test("shit.xxx");
    }
}
