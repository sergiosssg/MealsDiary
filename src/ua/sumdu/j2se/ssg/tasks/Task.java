package ua.sumdu.j2se.ssg.tasks;

import java.util.Date;

/**
 * Created by SSG on 26.04.2017.
 */
public class Task {

    private String title;
    private boolean active;
    Date startTime;
    Date endTime;
    private int interval;

    //

    /**
     * Creates new task, which is inactive and should be performed only once or never
     * @param taskTitle new task gets deep copy of this parameter
     * @param time when should be performed
     */
    public Task(String taskTitle, Date time){
        try{
            title = taskTitle;
            endTime = startTime =  (Date)time.clone();
            active = false;
            interval = 0;
        } catch (NullPointerException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    } // Task(String title, int time)

    /**
     *
     * @param taskTitle
     * @param time
     * @param active
     */
    public Task(String taskTitle, Date time, boolean active){
        try{
            title = taskTitle;
            endTime = startTime =  (Date)time.clone();
            this.active = active;
            interval = 0;
        } catch (NullPointerException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Creates new task, which is inactive and should be performed several times
     * within range from start to end
     * @param taskTitle new task gets deep copy of this parameter
     * @param start excluding time when task could be accomplished
     * @param end including time when task could be accomplished
     * @param interval period in seconds, through which task could be accomplished
     */
    public Task(String taskTitle, Date start, Date end, int interval){
        try{
            if(interval < 0) throw new IllegalArgumentException("Interval can't have negative value");
            title =  taskTitle;
            startTime =  (Date) start.clone();
            endTime = (Date) end.clone();
            active = false;
            this.interval = interval;
        } catch (NullPointerException | IllegalArgumentException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    } // Task(String title, int start, int end, int interval)

    /**
     *
     * @param taskTitle
     * @param start
     * @param end
     * @param interval
     * @param active
     */
    public Task(String taskTitle, Date start, Date end, int interval, boolean active){
        try{
            if(interval < 0) throw new IllegalArgumentException("Interval can't have negative value");
            title =  taskTitle;
            startTime =  (Date) start.clone();
            endTime = (Date) end.clone();
            this.active = active;
            this.interval = interval;
        } catch (NullPointerException | IllegalArgumentException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }



    /**
     * Creates new task, which is strict copy of task given in parameter
     * @param task , to be fully copied
     */
    public Task (Task task){
        try{
            if(task == null) throw new NullPointerException("Task can't be null");
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


    public boolean equals(Object tObj){

        if(tObj == null) return false;
        if(this == tObj) return true;
        if(!this.getClass().equals(tObj.getClass())) return false;
        Task _t = (Task) tObj;
        if(_t.getTitle().compareToIgnoreCase(this.getTitle())== 0 &&
                _t.getTime().compareTo(this.getTime()) == 0 &&
                _t.getRepeatInterval() == this.getRepeatInterval() &&
                _t.getStartTime().compareTo(this.getStartTime()) == 0 &&
                _t.getEndTime().compareTo(this.getEndTime()) == 0 &&
                _t.isActive() == this.isActive())
            return true;
        /* title == t.title &&  time == t.time && repeatInterval == t.repeatInterval && startTime == t.startTime) && endTime == t.endTime && active == t.active*/
        return false;
    } // boolean equals(Object)

    public int hashCode() {
        int retHashCode = this.title.hashCode()<< 16
                + this.getTime().hashCode() << 8
                + this.getRepeatInterval() +
                + this.getStartTime().hashCode()
                + this.getEndTime().hashCode();
        return retHashCode;
    } // int hashCode()


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
    public Date getTime(){
        return startTime;
    }

    /**
     * If this task was repeated, task should be not repeated
     * @param time int
     */
    public void setTime(Date time){
         endTime = startTime =  time;
         interval = 0;
    } // setTime(int )

    public Date getStartTime(){
        return startTime;
    }


    public Date getEndTime(){
        return endTime;
    }


    public int getRepeatInterval(){
        if(startTime != endTime) return interval;
        return 0;
    }

    public void setTime(Date start, Date end, int interval){
        startTime = start;
        endTime = end;
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
    public Date nextTimeAfter(Date currTime){
        if(!isActive()) return null;
        if( currTime.before(startTime)){
            return startTime;
        } else if( isRepeated() && endTime.after(currTime)){
            Date nextTime = startTime;
            long intervalAmount = startTime.getTime();
            final long AMOUNT_OF_MILLISECONDS = 1000L;

            do{
                if(currTime.before(nextTime)) return nextTime;
                nextTime.setTime( intervalAmount += (interval * AMOUNT_OF_MILLISECONDS));

            } while(!nextTime.after(endTime));

            return nextTime;
        } else {
            return null;
        }
    } // int nextTimeAfter(int currTime)

} // class Task
