public class WaiterThread extends Thread{

    public static final WaiterMonitor waiterMon = new WaiterMonitor();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " на работе!");
        while (!isInterrupted()) {
            waiterMon.service();
        }
        System.out.println(Thread.currentThread().getName() + " ушел с работы!");
    }
}
