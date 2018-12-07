import java.io.*;

public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\LzxFTP\\cgs.json");//D:\LzxFTP

        BufferedReader buf = new BufferedReader(new FileReader(file));
        String str = null;
        StringBuilder stringBuilder = new StringBuilder();
        while((str=buf.readLine())!=null){
            stringBuilder.append(str);
        }
        System.out.println(stringBuilder.toString());
        buf.close();
    }
}
