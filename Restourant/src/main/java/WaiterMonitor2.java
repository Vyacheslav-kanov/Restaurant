public class WaiterMonitor2 {

    public synchronized void carryOrder(){
        try {
            wait();
            ClientThread.clientMon.completeOrder();
            System.out.println(Thread.currentThread().getName() + " несет заказ!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void acceptCompleteOrder(){
        notify();
    }
}
