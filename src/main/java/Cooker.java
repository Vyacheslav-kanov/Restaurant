public class Cooker {


    public synchronized void cook(){
        try {
            wait();
            System.out.println(Thread.currentThread().getName() + "принял заказ!");

            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "приготовил заказ!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void newOrderToCooker(){
        notify();
    }
}
