package task1;

public class Main {

    public static void main(String[] args) {
        Knight knight = new Knight(new Quest1());
        knight.quest.pass();

        knight.setQuest(new Quest4());
        knight.quest.pass();

        knight.setQuest(new Quest5());
        knight.quest.pass();

    }
}
