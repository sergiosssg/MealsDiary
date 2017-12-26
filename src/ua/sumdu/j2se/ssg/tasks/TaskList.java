package ua.sumdu.j2se.ssg.tasks;

import java.util.Date;

/**
 * Created by SSG on 13.06.2017.
 */
public abstract class TaskList implements Iterable<Task>{

    protected int sizeOfArray;

    abstract public void add(Task task);

    abstract public boolean remove(Task task);

    public int size(){
        return sizeOfArray;
    } // size();

    public boolean isEmpty() {
        return (sizeOfArray == 0);
    } // isEmpty()

    abstract public Task getTask(int index);

    public TaskList incoming(int from, int to){
        TaskList returnedTaskArray =  new ArrayTaskList();

        try {
            if(from < 0 || to < 0) throw new IllegalArgumentException("Arguments can't be negative");

            Date fromDate = new Date(from);
            Date toDate = new Date(to);

            if(fromDate.after(toDate)) throw new IllegalArgumentException("Difference between second and first arguments can't be negative");

            if( !isEmpty()){
                for(int index_Of_Task = 0; index_Of_Task < size(); index_Of_Task++){
                    Task tt = getTask(index_Of_Task);
                    if(!tt.isActive() || (tt.getStartTime().after(toDate) || !tt.getEndTime().after(fromDate) )){
                        // go to the next task, that's why task or start after to, or ends till from
                        continue;
                    }
                    if(!tt.isRepeated() && tt.getTime().after(fromDate) && !tt.getTime().after(toDate)){
                        // one single active task, to be performed within given range from to
                        returnedTaskArray.add(tt);
                    }
                    else if (tt.isRepeated()){
                        if(( tt.getStartTime().after(fromDate) && !tt.getStartTime().after(toDate))){
                            // task fits boundary conditions
                            returnedTaskArray.add(tt);
                        }
                        else if (!tt.getStartTime().after(fromDate)) {
                            long currtime = tt.getStartTime().getTime();
                            while (currtime <= from) currtime += tt.getRepeatInterval();
                            if (currtime <= to) {
                                // active task, scheduled several times to perform, started already before from
                                // and should be performed till to
                                returnedTaskArray.add(tt);
                            }
                        }
                    }
                } // for( ...
            }  // if(size() > 0 ...
        } catch ( IllegalArgumentException ex ){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            return returnedTaskArray;
        }
    } // incoming(int , int )


} // class TaskList
