public class CookerThread extends Thread{

    public static final CookerMonitor cookMon = new CookerMonitor();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " на работе!");
        while (!isInterrupted()) {
            cookMon.cook();
        }
        System.out.println(Thread.currentThread().getName() + " ушел с работы!");
    }
}
