public class Main {

    public static void main(String[] args) {

        CookerThread cooker = new CookerThread();
        Thread cookThread = new Thread(cooker, "Повар ");
        cookThread.start();

        WaiterThread waiter = new WaiterThread();
        Thread threadWaiter = new Thread(waiter, "Официант1 ");
        threadWaiter.start();

        WaiterThread waiter2 = new WaiterThread();
        Thread threadWaiter2 = new Thread(waiter2, "Официант2 ");
        threadWaiter2.start();

        WaiterThread waiter3 = new WaiterThread();
        Thread threadWaiter3 = new Thread(waiter3, "Официант3 ");
        threadWaiter3.start();


        ClientThread client1 = new ClientThread();
        Thread threadClient1 = new Thread(client1, "Клиент1 ");
        threadClient1.start();

        ClientThread client2 = new ClientThread();
        Thread threadClient2 = new Thread(client2, "Клиент2 ");
        threadClient2.start();

        ClientThread client3 = new ClientThread();
        Thread threadClient3 = new Thread(client3, "Клиент3 ");
        threadClient3.start();

        ClientThread client4 = new ClientThread();
        Thread threadClient4 = new Thread(client4, "Клиент4 ");
        threadClient4.start();

    }
}
