public class NonRetrantLockTest {
    Lock lock = new Lock();
    public void a() throws InterruptedException {
        lock.lock();
        doSomething();
        lock.unlock();
    }

    //不可重入
    public void doSomething() throws InterruptedException {
        lock.lock();
        //................
        lock.unlock();
    }
    public static void main(String[] args) throws InterruptedException {
        NonRetrantLockTest nonRetrantLock = new NonRetrantLockTest();
        nonRetrantLock.a();
        nonRetrantLock.doSomething();
    }
}

class Lock {
    //是否占用
    private boolean isLocked = false;

    //开启锁
    public void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }

        isLocked = true;
    }
    //释放锁
    public void unlock() {
        isLocked = false;
        notify();
    }

}
