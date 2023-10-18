import java.io.File;
import java.util.concurrent.ExecutorService;

public class Folderanalyzer implements Runnable{
    private File dir;
    private File[] files;
    private ExecutorService executor;

    public Folderanalyzer(String dir, ExecutorService executor) {
        this.dir = new File(dir);
        this.files = this.dir.listFiles();
        this.executor = executor;
    }

    @Override
    public void run() {
        for(File file : files){
            if (file.isDirectory()) {
                this.executor.execute(new Folderanalyzer(file.getAbsolutePath(), executor));
            } else {
                this.executor.execute(new Zipper(file.getAbsolutePath()));
            }
        }
    }
}