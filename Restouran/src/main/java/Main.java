public class Main {

    public static void main(String[] args) {

        CookerThread cooker = new CookerThread();
        Thread cookThread = new Thread(cooker, "Повар");
        cookThread.start();

        for (int i = 1; i < 4; i++) {
            WaiterThread waiter = new WaiterThread();
            Thread thread = new Thread(waiter, "Официант" + i);
            thread.start();
        }

        for (int i = 1; i < 6; i++) {
            try {
                ClientThread client = new ClientThread();
                Thread thread = new Thread(client, "Клиент" + i);
                thread.start();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
