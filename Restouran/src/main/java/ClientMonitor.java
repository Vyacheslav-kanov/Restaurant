import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClientMonitor {

    private Lock lock = new ReentrantLock();
    public Condition cond = lock.newCondition();

    public synchronized void order(){
        lock.lock();
        try {
            Thread.sleep(7000);
            System.out.println(Thread.currentThread().getName() + " готов сделать заказ!");
            WaiterThread.waiterMon.newClient();
            cond.await();
            System.out.println(ClientThread.currentThread().getName() + " получил заказ!");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void completeOrder(){
        lock.lock();
        try{
            cond.signal();
        }finally {
            lock.unlock();
        }
    }
}
