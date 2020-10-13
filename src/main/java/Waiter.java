public class Waiter {


    public synchronized void service(){
        System.out.println(Thread.currentThread().getName() + "жду клиента!");
        try {
            wait();

            System.out.println(Thread.currentThread().getName() + "отдал заказ повару!");
            Restourant.cooker.newOrderToCooker();

            wait();
            System.out.println(Thread.currentThread().getName() + "несет заказ!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void acceptCompleteOrder(){
        notify();
    }
}
