import java.util.concurrent.*;

public class CallableDownload implements Callable<Boolean> {
    private String url;
    private String savePath;

    public CallableDownload(String url, String savePath) {
        this.url = url;
        this.savePath = savePath;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDownload t1 = new CallableDownload("http://d.hiphotos.baidu.com/image/pic/item/91ef76c6a7efce1b5ef04082a251f3deb58f659b.jpg", "1.jpg");
        CallableDownload t2 = new CallableDownload("http://a.hiphotos.baidu.com/image/h%3D300/sign=8162d6465482b2b7b89f3fc401accb0a/d009b3de9c82d158ec9917f38d0a19d8bc3e425c.jpg", "2.jpg");
        CallableDownload t3 = new CallableDownload("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4008968899,4134457348&fm=26&gp=0.jpg", "3.jpg");

        ExecutorService service = Executors.newFixedThreadPool(3);

        Future<Boolean> submit1 = service.submit(t1);
        Future<Boolean> submit2 = service.submit(t2);
        Future<Boolean> submit3 = service.submit(t3);

        Boolean aBoolean = submit1.get();
        Boolean bBoolean = submit2.get();
        Boolean cBoolean = submit3.get();

        System.out.println(cBoolean);

        service.shutdownNow();

    }

    @Override
    public Boolean call() throws Exception {
        WebDownload webDownload = new WebDownload();
        webDownload.download(url, savePath);
        System.out.println(savePath);
        return true;
    }
}
