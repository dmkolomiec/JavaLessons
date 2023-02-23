package step2;

import java.util.ArrayList;

public class Zoo {
    protected ArrayList<String> list;
    public Zoo(int size) {
         list = new ArrayList<>(size);
    }
    public void add(int index, String element) {
        list.add(index, element);
    }
    public void Print() {
        System.out.println(list/*.toString()*/);
    }

}
