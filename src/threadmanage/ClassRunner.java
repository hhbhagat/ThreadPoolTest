package threadmanage;

public class ClassRunner extends Thread{

    private volatile boolean keepRunning = true; //the volatile keyword makes it so that it does not cache the value in some cases, therefor causing an unstoppable thread.
    
    @Override
    public void run(){
     
        while(keepRunning){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            System.out.println("hasdfasdfasdfas"); //task
        }
                
    }
    
    public void shutdown(){ //self-explanatory
        keepRunning = false;
    }
    
}
