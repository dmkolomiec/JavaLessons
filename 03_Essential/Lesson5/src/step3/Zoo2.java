package step3;
import step2.Zoo;

public class Zoo2 extends Zoo {
    public Zoo2(int size) {
        super(size);
    }
    @Override
    public void Print() {
        System.out.printf("(%d) %s\n", list.size(), list.toString());
    }

    public void delete(int count) {
        if (count > list.size()) return;

        while(count-- > 0)
            super.list.remove(list.size()-1);
    }
}
