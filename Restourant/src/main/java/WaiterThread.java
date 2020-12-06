import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaiterThread extends Thread{

    public static final WaiterMonitor1 waiterMon1 = new WaiterMonitor1();
    public static final WaiterMonitor2 waiterMon2 = new WaiterMonitor2();

    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " на работе!");
        lock.lock();
        while (!isInterrupted()) {
            waiterMon1.waitOrder();
            waiterMon2.carryOrder();
        }
        lock.unlock();
        System.out.println(Thread.currentThread().getName() + " ушел с работы!");
    }
}
