package threadmanage;

import java.util.ArrayList;

public class ThreadManage {

    public static void main(String[] args) {
        
        //A workmanager manages the threads, while the workpool manages the work for each thread.
        
//        ClassRunner cr = new ClassRunner();
//        cr.start();
//        Scanner s =  new Scanner(System.in);
//        s.nextLine();
//        cr.shutdown();

        WorkManager wm = new WorkManager(3);
        
        ArrayList<String> work = new ArrayList<String>();
        for(int i=0;i<20;i++){
            work.add("Job number " + i + " Complete.");
            System.out.println(i);
        }
        WorkPool<String> masterPool = new WorkPool<String>();
        for(String w:work){ //this creates work from the arraylist of job strings
            masterPool.addWork(w);
        }
        
        for(int i=0;i<10;i++){ //this starts 50 workers on the masterPool
            wm.addJob(new Thread1<String>(masterPool));
        }
        
    }

}
