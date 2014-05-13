package threadmanage;

public class PooledThread extends Thread implements Runnable {

    protected WorkPool linkedPool = null;

    public PooledThread(){
        
    }
    
    public PooledThread(WorkPool wp) {
        linkedPool = wp;
    }
    
    public void setWorkPool(WorkPool wp){
        linkedPool = wp;
    }
    
    public Object getNextJob(){
        return linkedPool.getSomeWork();
    }
    
    public boolean hasWork(){
        return linkedPool.isThereMore();
    }
    
}
