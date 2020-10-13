public class ClientThread extends Thread{

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + "зашел в ресторан!");

        Restourant.client.order();

        System.out.println(Thread.currentThread().getName() + "ушел из ресторана!");
    }
}
