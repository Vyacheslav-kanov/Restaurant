public class ClientThread extends Thread{

    public static final ClientMonitor clientMon = new ClientMonitor();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " зашел в ресторан!");
        clientMon.order();
        System.out.println("    *" + Thread.currentThread().getName() + " ушел из ресторана!");
    }
}
