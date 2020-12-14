import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaiterMonitor {

    private Lock lock = new ReentrantLock();
    private Condition cond1 = lock.newCondition();
    private Condition cond2 = lock.newCondition();

    public void service(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " жду клиента!");
            cond1.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        CookerThread.cookMon.newOrderToCooker();
        System.out.println(Thread.currentThread().getName() + " отдал заказ повару!");

        lock.lock();
        try{
            cond2.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        ClientThread.clientMon.completeOrder();
        System.out.println(Thread.currentThread().getName() + " несет заказ!");
    }

    public void newClient(){
        lock.lock();
        try{
            cond1.signal();
        }finally {
            lock.unlock();
        }
    }

    public void acceptCompleteOrder(){
        lock.lock();
        try {
            cond2.signal();
        }finally {
            lock.unlock();
        }
    }
}
