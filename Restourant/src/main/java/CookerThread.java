import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CookerThread extends Thread{

    public static final CookerMonitor cookMon = new CookerMonitor();

    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " на работе!");
        lock.lock();
        while (!isInterrupted()) {
            cookMon.cook();
        }
        lock.unlock();
        System.out.println(Thread.currentThread().getName() + " ушел с работы!");
    }
}
