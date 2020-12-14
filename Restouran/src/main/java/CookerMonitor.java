import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CookerMonitor {

    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    public void cook(){
        lock.lock();
        try {
            cond.await();
            System.out.println(Thread.currentThread().getName() + " принял заказ!");
            Thread.sleep(6000);
            WaiterThread.waiterMon.acceptCompleteOrder();
            System.out.println(Thread.currentThread().getName() + " приготовил заказ!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void newOrderToCooker(){
        lock.lock();
        try{
            cond.signal();
        }finally {
            lock.unlock();
        }
    }
}
