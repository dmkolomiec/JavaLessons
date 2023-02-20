// Завдання 4. Створіть клас DocumentWorker...

package  step4;
import java.util.Scanner;

class DocumentWorker{
    public void openDocument() {
        System.out.println("Документ відкритий");
    }
    public void editDocument(){
        System.out.println("Правка документа доступна у версії Про");
    }
    public void saveDocument(){
        System.out.println("Збереження документа доступне у версії Про");
    }
    public void Demo(){
        this.openDocument();
        this.editDocument();
        this.saveDocument();
    }
}

class DocumentWorkerPro extends DocumentWorker{
    public static final String accessKey = "Pro";
    @Override
    public void editDocument() {
        System.out.println("Документ відредаговано");
    }
    @Override
    public void saveDocument() {
        System.out.println("Документ збережено у старому форматі, збереження в інших форматах доступне у версії Експерт");
    }
}

class DocumentWorkerExpert extends DocumentWorkerPro {
    public static final String accessKey = "Exp";
    @Override
    public void saveDocument() {
        System.out.println("Документ збережено у новому форматі (v.Експерт)");
    }
}

public class Main {
    static Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {
        String accessKey;
        DocumentWorker doc;
        System.out.print("Введіть код доступу (пусто/Pro/Exp):");
        accessKey = inp.nextLine();
        doc = switch (accessKey) {
            case DocumentWorkerPro.accessKey -> new DocumentWorkerPro();
            case DocumentWorkerExpert.accessKey -> new DocumentWorkerExpert();
            default -> new DocumentWorker();
        };
        doc.Demo();
    }
}