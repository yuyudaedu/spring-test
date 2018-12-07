public class StartThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("一边听歌。。。。。。。。。。。");
        }
    }

    public static void main(String[] args) {
        StartThread startThread = new StartThread();

        startThread.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("一边coding...................");
        }
    }
}
