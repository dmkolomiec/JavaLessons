package Lesson1_4;

class Computer {
    private int id;
    private String Descr;
    public Computer(int id_, String Descr_) {
        id = id_;
        Descr = Descr_;
    }
    public void print(){
        System.out.println(this.id + ". " + this.Descr);
    }
}
public class Main {
    public static void main(String[] args) {
        Computer c[] = new Computer[5];
        for(int i = 0; i<c.length; i++)
            c[i] = new Computer(i+1, "Якась маячня № "+(i+1));

        for(Computer i:c)
            i.print();
    }
}