import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        
        final int dimthreadpool = 10;
        ExecutorService executor = Executors.newFixedThreadPool(dimthreadpool);
        
        FileReader fr = new FileReader("directorylist.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;

        while((line = br.readLine()) != null){
            executor.execute(new Folderanalyzer(line,executor));
        }


        //trovare modo per aspettare tutti e poi chiudere executor
        executor.awaitTermination(2, TimeUnit.SECONDS);
        executor.shutdown();
        while(!executor.isTerminated()){
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        fr.close();
        br.close();
    }
}
 