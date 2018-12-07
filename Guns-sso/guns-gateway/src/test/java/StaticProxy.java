public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
    }
}

interface Marry {
    void happyMarry();
}

class You implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("我是真实角色。。。。。。。。。。。");
    }
}

class WeddingCompany implements Marry {
    Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        System.out.println("我是代理角色。。。。。。。。。");
        this.target.happyMarry();
        after();
    }

    public void before() {
        System.out.println("布置狗窝。。。。。。。。。。。。。");
    }

    public void after() {
        System.out.println("闹玉兔。。。。。。。。。。。。。");
    }
}
