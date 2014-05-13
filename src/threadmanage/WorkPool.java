package threadmanage;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * This class is a generic class that manages synchronized access to a pool of
 * jobs that have to be executed.
 *
 * @param <T>
 */
public class WorkPool<T> {

    /* NOTE: about synchronized methods... They lock up the entire class, such that only one thread is allowed to use methods inside the class. 
    This code has been refactored to work with object locks, which uses synchronized code blocks instead of methods such that a singular method call by a single thread
    does not cause the entire instantiated class to block other methods from entering and doing stuff. This will not change, however, the behavior where two threads try
    to operate on a single variable because synchronized locks, by nature, take care of that.
    */
    private ArrayList<T> workList = new ArrayList<T>(); //Arraylist of generic T things. 
    private ListIterator<T> iterWorkList = null; //makes it so that once the work is handed off, it is never touched again by any asking thread
    
    //these are object locks. they 
    private Object getwork = new Object();
    private Object addwork = new Object();
    private Object istheremore = new Object();

    public WorkPool() {
        iterWorkList = workList.listIterator();
    }

    public T getSomeWork() {
        synchronized (getwork) {
            return iterWorkList.next();  //This gives some work/work info to the calling method, and gives out whatever T is from the iterWorkList iterator.
        }
    }

    public void addWork(T job) { //Can synchronously add work to the "queue" without causing errors due to parallel access. 
        synchronized (addwork) {
            workList.add(job);
        }
    }

    public boolean isThereMore() {
        synchronized (istheremore) { //synchronously checks for more work.
            return iterWorkList.hasNext();
        }
    }
    //refactored away...
    /*
     public synchronized T getSomeWork() {
     return iterWorkList.next();  //This actually gives some work/work info to the calling method, and gives out whatever T is from the iterWorkList iterator.
     }

     public synchronized void addWork(T job) { //Can synchronously add work to the "queue" without 
     workList.add(job); 
     }
    
     public synchronized boolean isThereMore(){
     return iterWorkList.hasNext();
     }
     */
}
