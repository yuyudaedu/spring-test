import java.util.concurrent.atomic.AtomicInteger;

public class CAS {
    private static AtomicInteger stock = new AtomicInteger(5);
    public static void main(String[] args) {
        for (int i = 0; i< 5; i++) {
            new Thread(()->{
                Integer left = stock.decrementAndGet();
                if (left < 1) {
                    System.out.println("==>商品已被抢空");
                }

                System.out.print(Thread.currentThread().getName() + "抢到了一件商品");
                System.out.println("==>还剩余" + left);
            }).start();
        }
    }
}
