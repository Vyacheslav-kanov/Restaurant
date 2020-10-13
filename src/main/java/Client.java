public class Client {


    public synchronized void order(){
        try {
            Thread.sleep(3000);
            Restourant.waiter.acceptCompleteOrder();
            wait();

            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Restourant.waiter.acceptCompleteOrder();
    }

    public synchronized void completeOrder(){
        notify();
    }
}
