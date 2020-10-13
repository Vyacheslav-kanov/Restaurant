public class WaiterThread extends Thread{


    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + "на работе!");

        while (!isInterrupted()) {
            Restourant.waiter.service();
            Restourant.client.completeOrder();
        }

        System.out.println(Thread.currentThread().getName() + "ушел с работы!");
    }
}
