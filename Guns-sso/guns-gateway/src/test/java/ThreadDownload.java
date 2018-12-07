public class ThreadDownload extends Thread {
    private String url;
    private String savePath;

    public ThreadDownload(String url, String savePath) {
        this.url = url;
        this.savePath = savePath;
    }

    @Override
    public void run() {
        WebDownload webDownload = new WebDownload();
        webDownload.download(url, savePath);
        System.out.println(savePath);
    }

    public static void main(String[] args) {
        ThreadDownload t1 = new ThreadDownload("http://d.hiphotos.baidu.com/image/pic/item/91ef76c6a7efce1b5ef04082a251f3deb58f659b.jpg", "1.jpg");
        ThreadDownload t2 = new ThreadDownload("http://a.hiphotos.baidu.com/image/h%3D300/sign=8162d6465482b2b7b89f3fc401accb0a/d009b3de9c82d158ec9917f38d0a19d8bc3e425c.jpg", "2.jpg");
        ThreadDownload t3 = new ThreadDownload("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4008968899,4134457348&fm=26&gp=0.jpg", "3.jpg");

        t1.start();
        t2.start();
        t3.start();


    }
}
