public class Tickets implements Runnable {
    private int num = 99;
    @Override
    public void run() {
        while (true) {
            if (num < 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ==> " + num--);
        }
    }


    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        System.out.println(Thread.currentThread().getName());

        new Thread(tickets, "线程1").start();
        new Thread(tickets, "线程2").start();
        new Thread(tickets, "线程3").start();
    }
}
