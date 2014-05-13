package threadmanage;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//This class starts threads automatically after addJob has been called.
public class WorkManager {

    private ExecutorService pool = null;
    //CountDownLatch cdl = new CountDownLatch(1);

    public WorkManager() {
    }

    public WorkManager(int numThreads) {
        pool = Executors.newFixedThreadPool(numThreads); //creates a limiter of how many threads in "pool" can run at once.
    }

    public void addJob(Runnable job) { //submits a runnable job into pool.
        pool.submit(job);
    }
    
    public void stop(){
        pool.shutdown();
    }
    
    public List<Runnable> stopNow(){
        return pool.shutdownNow();
    }
}
