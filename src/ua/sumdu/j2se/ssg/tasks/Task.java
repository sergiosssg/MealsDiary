package ua.sumdu.j2se.ssg.tasks;

/**
 * Created by SSG on 26.04.2017.
 */
public class Task {

    private String title;
    private boolean active;
    private int startTime;
    private int endTime;
    private int interval;

    //

    /**
     * Creates new task, which is inactive and should be performed only once or never
     * @param taskTitle new task gets deep copy of this parameter
     * @param time when should be performed
     */
    public Task(String taskTitle, int time){
        try{
            if(time < 0) throw new IllegalArgumentException("Time can't have negative value");
            title = taskTitle;
            endTime = startTime =  time;
            active = false;
            interval = 0;
        } catch (NullPointerException | IllegalArgumentException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    } // Task(String title, int time)

    /**
     * Creates new task, which is inactive and should be performed several times
     * within range from start to end
     * @param taskTitle new task gets deep copy of this parameter
     * @param start excluding time when task could be accomplished
     * @param end including time when task could be accomplished
     * @param interval period in seconds, through which task could be accomplished
     */
    public Task(String taskTitle, int start, int end, int interval){
        try{
            if(start < 0) throw new IllegalArgumentException("Start time can't have negative value");
            if(end < 0) throw new IllegalArgumentException("End time can't have negative value");
            if(interval < 0) throw new IllegalArgumentException("Interval can't have negative value");
            title =  taskTitle;
            startTime =  start;
            endTime = end;
            active = false;
            this.interval = interval;
        } catch (NullPointerException | IllegalArgumentException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    } // Task(String title, int start, int end, int interval)

    /**
     * Creates new task, which is strict copy of task given in parameter
     * @param task , to be fully copied
     */
    public Task (Task task){
        try{
            if(task != null) throw new NullPointerException("Task can't be null");
            this.title = task.getTitle();
            if(task.isRepeated()){
                this.startTime = task.getStartTime();
                this.endTime = task.getEndTime();
            } else {
                this.startTime = this.endTime = task.getTime();
            }
            this.active = task.isActive();
        } catch (NullPointerException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    } //  Task (Task )


    public String getTitle(){ return title;}

    public void setTitle(String taskTitle){
        try{
            if( taskTitle.isEmpty()) throw new IllegalArgumentException(" title can't be empty");
            title = taskTitle;
        } catch (NullPointerException | IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    } // setTitle(String )


    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    /**
     * @return time, from which task could be performed, excluding this value
     */
    public int getTime(){
        return startTime;
    }

    /**
     * If this task was repeated, task should be not repeated
     * @param time int
     */
    public void setTime(int time){
        try {
            if (time < 0) throw new IllegalArgumentException("Time can't be negative");
            endTime = startTime =  time;
            interval = 0;
        } catch ( IllegalArgumentException ex ) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    } // setTime(int )

    public int getStartTime(){
        return startTime;
    }


    public int getEndTime(){
        return endTime;
    }


    public int getRepeatInterval(){
        if(startTime != endTime) return interval;
        return 0;
    }

    public void setTime(int start, int end, int interval){
        startTime = (start < 0 || (end - start) < 0)? 0 : start;
        endTime = (end < 0 || (end - start) < 0)? 0 : end;
        this.interval = (interval < 0)? 0 : interval;
    }

    /**
     * @return true, when task could be repeated
     */
    public boolean isRepeated(){
        return (startTime != endTime && interval != 0);
    }

    /**
     * @param currTime time, which towards compute next time of task execution
     * @return integer value of next time of task execution, if this task couldn't
     * be executed any more, function returns -1
     */
    public int nextTimeAfter(int currTime){
        int returnedValue = -1;
        try{
            if (currTime < 0) throw new IllegalArgumentException("Time can't be negative");

            if(!active || ( currTime >= endTime && interval == 0)){
                returnedValue = -1;
            } else if( currTime < startTime ){
                returnedValue = startTime;
            } else {
                int nextTime;

                for (nextTime = startTime;nextTime <= currTime;){
                    nextTime += interval;
                    if(nextTime > endTime) return -1;
                }
                returnedValue = nextTime;
            }
        } catch ( IllegalArgumentException ex ) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            return returnedValue;
        }
    } // int nextTimeAfter(int currTime)

} // class Task
