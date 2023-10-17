import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;


public class Zipper implements Runnable {
    private String nomefile;

    public Zipper(String nomefile) {
        this.nomefile = nomefile;
    }

    @Override
    public void run() {
        int index = nomefile.lastIndexOf(".");
        try {
            FileInputStream fis = new FileInputStream(nomefile);
            FileOutputStream fos = new FileOutputStream(nomefile.substring(0, index) + ".gz");
            GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
            byte[] buffer = new byte[1024];
            int len;
            while((len=fis.read(buffer)) != -1){
                gzipOS.write(buffer, 0, len);
            }
            //close resources
            gzipOS.close();
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
