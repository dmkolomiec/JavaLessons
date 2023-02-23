/*
Завдання 3. Використовуючи IntelliJ IDEA, створіть проект. Потрібно: Створіть 2 інтерфейси Playable та Recodable.
        У кожному з інтерфейсів створіть по 3 методи void play() / void pause() / void stop() та void record() / void pause() / void stop() відповідно.
        Створіть похідний клас Player від базових інтерфейсів Playable та Recodable. Написати програму, яка виконує програвання та запис.
*/
package step4;

interface Playable {
    void play();
    void pause();
    void stop();
}
interface Recodable {
    void record();
    void pause();
    void stop();
}
class Player implements Playable, Recodable {
    public void play() { System.out.println("Player: play"); }
    public void pause() { System.out.println("Player: pause"); }
    public void stop() { System.out.println("Player: stop");}
    public void record() { System.out.println("Player: record"); }
}
public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        player.play();
        player.pause();
        player.stop();
        player.record();
        player.stop();
    }
}
