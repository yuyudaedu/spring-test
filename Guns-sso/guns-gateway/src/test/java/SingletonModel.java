public class SingletonModel {
    //#1  添加静态属性
    //private static SingletonModel instance  = new SingletonModel(); //饿汉式
    private static volatile SingletonModel instance;  //懒汉式

    //#2  构造方法私有化
    private SingletonModel() {

    }

    //#3 静态入口
    public static SingletonModel getInstance() {
        //#5 考虑到多线程同时访问，造成不必要的同步，所以如果实例已经存在，直接返回实例
        if (null != instance) {
            return instance;
        }

        //#4 考虑到并发问题，需要加锁
        synchronized (SingletonModel.class) {
            //#6 由于存在指令重排问题，可能导致后边进入的线程拿到一个空对象，所以需要volatile即刻同步数据到主存上
            if (null == instance) {
                instance = new SingletonModel(); //创建类的过程： 1开辟空间->2初始化对象信息->3返回对象地址给引用
            }
        }

        return instance;
    }

    //#7 测试
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println(SingletonModel.getInstance().hashCode());
        });
        thread.start();
        System.out.println(SingletonModel.getInstance().hashCode());

        //SingletonModel@3fa77460
        //SingletonModel@3fa77460
        //1067938912
        //1067938912
    }

}
