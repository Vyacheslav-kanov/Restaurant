public class WaiterMonitor1 {


    public synchronized void waitOrder(){
        System.out.println(Thread.currentThread().getName() + " жду клиента!");

        try {
            wait();
            CookerThread.cookMon.newOrderToCooker();
            System.out.println(Thread.currentThread().getName() + " отдал заказ повару!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void newClient(){
        notify();
    }
}
