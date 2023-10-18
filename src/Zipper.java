import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;


public class Zipper implements Runnable {
    private String filename;

    public Zipper(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        int index = filename.lastIndexOf(".");
        try {
            FileInputStream fis = new FileInputStream(filename);
            FileOutputStream fos = new FileOutputStream(filename.substring(0, index) + ".gz");
            GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
            byte[] buffer = new byte[1024];
            int len;
            while((len=fis.read(buffer)) != -1){
                gzipOS.write(buffer, 0, len);
            }
            
            gzipOS.close();
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
