public class CookerThread extends Thread{



    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + "на работе!");

        while (!isInterrupted()) {
            Restourant.cooker.cook();
            Restourant.waiter.acceptCompleteOrder();
        }

        System.out.println(Thread.currentThread().getName() + "ушел с работы!");
    }
}
