import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClientThread extends Thread{

    public static final ClientMonitor clientMon = new ClientMonitor();

    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " зашел в ресторан!");
        lock.lock();
        clientMon.order();
        lock.unlock();
        System.out.println("    *" + Thread.currentThread().getName() + " ушел из ресторана!");
    }
}
