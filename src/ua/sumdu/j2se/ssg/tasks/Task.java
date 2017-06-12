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

        title = new String(taskTitle);
        endTime = startTime = (time < 0)? 0 : time;
        active = false;
        interval = 0;
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
        title = new String(taskTitle);
        startTime = (start < 0 || (end - start) < 0)?  0 : start;
        endTime = (end < 0 || (end - start) < 0)? 0 : end;
        active = false;
        this.interval = (interval < 0)? 0 : interval;
    } // Task(String title, int start, int end, int interval)

    /**
     * Creates new task, which is strict copy of task given in parameter
     * @param task , to be fully copied
     */
    public Task (Task task){
        if(task != null){
            this.title = task.getTitle();
            if(task.isRepeated()){
                this.startTime = task.getStartTime();
                this.endTime = task.getEndTime();
            } else {
                this.startTime = this.endTime = task.getTime();
            }
            this.active = task.isActive();
        } // if(task != null)
    } //  Task (Task )


    public String getTitle(){ return title;}

    public void setTitle(String taskTitle){
        title = taskTitle;
    }


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
        endTime = startTime = (time < 0)? 0 : time;
        interval = 0;
    }

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

        if (!active ||  (currTime >= endTime && interval == 0)) return -1;
        if(currTime < startTime) return startTime;

        int nextTime;

        for (nextTime = startTime;nextTime <= currTime;){
            nextTime += interval;
            if(nextTime > endTime) return -1;
        }
        return nextTime;
    } // int nextTimeAfter(int currTime)





} // class Task