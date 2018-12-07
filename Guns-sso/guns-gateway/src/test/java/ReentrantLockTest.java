import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
     ReentrantLock lock = new ReentrantLock();
    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSomething();
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    //不可重入
    public void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        //................
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest reentrantLock = new ReentrantLockTest();
        reentrantLock.a();
        System.out.println(reentrantLock.lock.getHoldCount());
    }
}

class ReLock {
    //是否占用
    private boolean isLocked = false;
    //存储当前线程
    private Thread lockedBy = null;
    //锁计数器
    private Integer holdCount = 0;

    public Integer getHoldCount() {
        return holdCount;
    }

    //开启锁
    public void lock() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        while (isLocked && currentThread != lockedBy) {
            wait();
        }

        isLocked = true;
        lockedBy = currentThread;
        holdCount++;
    }
    //释放锁
    public void unlock() {
        if (Thread.currentThread() == lockedBy) {
            holdCount--;
            if (holdCount == 0) {
                isLocked = false;
                notify();
                lockedBy = null;
            }
        }
    }

}
