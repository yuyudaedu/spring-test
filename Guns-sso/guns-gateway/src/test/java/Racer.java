public class Racer implements Runnable {
    private String winner;
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (Thread.currentThread().getName() == "rabbit" && i%10 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "==>" + i);
            boolean checkSteps = checkSteps(i);
            if (checkSteps) {
                break;
            }
        }
    }

    private boolean checkSteps(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("last winner: " + winner);

                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer, "tortois").start();
        new Thread(racer, "rabbit").start();
    }
}
