public class CookerMonitor {

    public synchronized void cook(){
        try {
            wait();
            System.out.println(Thread.currentThread().getName() + " принял заказ!");

            Thread.sleep(6000);
            WaiterThread.waiterMon2.acceptCompleteOrder();
            System.out.println(Thread.currentThread().getName() + " приготовил заказ!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void newOrderToCooker(){
        notify();
    }
}
