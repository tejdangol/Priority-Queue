public class Process1 {
/**
 * This class is a helper class for more conveniently creating processes and 
 * storing information about each process. The class has a default time to 
 * completion for each process of 3 context switches.
 * @param newNumber, newPriority, the new process number and priority for this 
 * process
 * @return Process
 */
    private final int processNumber;
    private final int priority;
    private int timeToCompletion;
    
    public Process1(int newNumber, int newPriority){
        processNumber = newNumber;
        priority = newPriority;
        timeToCompletion = 2;
    }
    
    public int getPriority(){
        return priority;
    }
    
    public int getProcessNumber(){
        return processNumber;
    }
    
    public int getTimeToCompletion(){
        return timeToCompletion;
    }
    
    public void doWork(){
        if(timeToCompletion > 0){
            timeToCompletion--;
        }
    }
}