package step5;

public class DeadLockDemo extends Thread {
    private DeadLockDemo neighbour;
    private boolean isWaitingObj; // Ознака очікування поточним потоком завершення роботи сусіднього потоку

    public DeadLockDemo() {
    }

    public void setNeighbour(DeadLockDemo neighbour) {
        this.neighbour = neighbour;
    }

    public void setWaitingObj(boolean waitingObj) {
        isWaitingObj = waitingObj;
    }

    synchronized private void doLock() {
        System.out.println("Called " + getName() + ".doLock()...");
        System.out.println(getName() + ".doLock() exiting. (This command should newer be executed)");
    }

    synchronized private void callLock() {
        System.out.println(getName() + " calling " + neighbour.getName() + ".doLock()");
        neighbour.doLock();
    }

    @Override
    public void run() {
        System.out.println(getName() + " started");

        if (isWaitingObj) {
            try {
                synchronized (this) {
                    wait(200);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        callLock();

        if (!isWaitingObj) synchronized (neighbour) {
            neighbour.notify();
        }

        System.out.println(getName() + " ended");
    }
}
