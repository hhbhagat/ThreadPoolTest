package threadmanage;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread1<T> extends PooledThread {

    public Thread1(WorkPool<T> wp) {
        super.setWorkPool(wp);
    }

    @Override
    public void run() {
        Random rand = new Random();
        System.out.println("Started");
        if (super.hasWork()) {

            while (super.hasWork()) {
                int r = rand.nextInt(50); //random wait
                try {
                    Thread.sleep(r * 10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                }
                String str = "default";
                    str = (String) getNextJob();
                
                System.out.println(str);

            }
        } else {
            System.out.println("No work...");
        }
    }
}
