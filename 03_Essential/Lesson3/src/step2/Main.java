// Завдання 2. Створити клас, який представляє навчальний клас ClassRoom...
package step2;

class Student {
    static final String name = "student";
    static final String [] modes = {"reads", "writes", "learns", "relaxes"},
                            quals = {"Bad", "Good", "Excellent"};

    String getMode(int mode) {return name + " " + modes[mode]; }
    void read() { }
    void write(){ }
    void learn() { }
    void relax() { }
}
class BadStudent extends Student {
    static final String qualifier;
    String getProcInfo(int mode) {return qualifier + " " + super.getMode(mode) + " " + qualifier.toLowerCase() + "ly"; }
    void read() { System.out.println(getProcInfo(0));}
    void write(){ System.out.println(getProcInfo(1));}
    void learn() { System.out.println(getProcInfo(2));}
    void relax() { System.out.println(qualifier + " " + super.getMode(3) + " " + quals[(int)(Math.random()*3)].toLowerCase() + "ly");}

    static { qualifier = quals[0]; }
}
class GoodStudent extends Student {
    static final String qualifier;
    String getProcInfo(int mode) {return qualifier + " " + super.getMode(mode) + " " + qualifier.toLowerCase(); }
    void read() { System.out.println(getProcInfo(0));}
    void write(){ System.out.println(getProcInfo(1));}
    void learn() { System.out.println(getProcInfo(2));}
    void relax() { System.out.println(getProcInfo(3));}
    static { qualifier = quals[1]; }
}
class ExcelentStudent extends Student {
    static final String qualifier;
    String getProcInfo(int mode) {return qualifier + " " + super.getMode(mode) + " perfect"; }
    void read() { System.out.println(getProcInfo(0));}
    void write(){ System.out.println(getProcInfo(1));}
    void learn() { System.out.println(getProcInfo(2));}
    void relax() { System.out.println(getProcInfo(3));}
    static { qualifier = quals[2]; }
}

class ClassRoom {
    Student [] p;
    ClassRoom(Student p1, Student p2) {
        p = new Student[2];
        this.p[0] = p1;
        this.p[1] = p2;
    }
    ClassRoom(Student p1, Student p2, Student p3) {
        p = new Student[3];
        this.p[0] = p1;
        this.p[1] = p2;
        this.p[2] = p3;
    }
    ClassRoom(Student p1, Student p2, Student p3, Student p4) {
        p = new Student[4];
        this.p[0] = p1;
        this.p[1] = p2;
        this.p[2] = p3;
        this.p[3] = p4;
    }

    void read(){
        String s = "-";
        System.out.println(s.repeat(10) + "Class "+ Student.modes[0] + ":");
        for(Student Student:p)
            Student.read();
    }
    void write(){
        String s = "-";
        System.out.println(s.repeat(10) + "Class "+ Student.modes[1] + ":");
        for(Student Student:p)
            Student.write();
    }
    void learn(){
        String s = "-";
        System.out.println(s.repeat(10) + "Class "+ Student.modes[1] + ":");
        for(Student Student:p)
            Student.learn();
    }
    void relax(){
        String s = "-";
        System.out.println(s.repeat(10) + "Class "+ Student.modes[2] + ":");
        for(Student Student:p)
            Student.relax();
    }
}

public class Main {
    public static void main(String[] args) {
        ClassRoom c = new ClassRoom(new BadStudent(), new GoodStudent(), new ExcelentStudent());
        c.read();
        c.write();
        c.learn();
        c.relax();
    }
}
