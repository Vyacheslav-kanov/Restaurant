public class ClientMonitor {

    public synchronized void order(){
        try {
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName() + " готов сделать заказ!");

            WaiterThread.waiterMon1.newClient();
            wait();

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void completeOrder(){
        notify();
    }
}
