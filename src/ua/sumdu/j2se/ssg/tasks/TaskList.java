package ua.sumdu.j2se.ssg.tasks;

/**
 * Created by SSG on 13.06.2017.
 */
public abstract class TaskList {

    abstract public void add(Task task);

    abstract public boolean remove(Task task);

    abstract public int size();

    abstract public Task getTask(int index);

    TaskList incoming(int from, int to){
        TaskList returnedTaskArray =  new ArrayTaskList();

        try {
            if(from < 0 || to < 0) throw new IllegalArgumentException("Arguments can't be negative");
            if(to - from < 0)  throw new IllegalArgumentException("Difference between second and first arguments can't be negative");

            if(size() > 0){
                for(int index_Of_Task = 0; index_Of_Task < size(); index_Of_Task++){
                    Task tt = getTask(index_Of_Task);
                    if(!tt.isActive() || (tt.getStartTime() > to || tt.getEndTime() <= from )){
                        // go to the next task, that's why task or start after to, or ends till from
                        continue;
                    }
                    if(!tt.isRepeated() && tt.getTime() > from && tt.getTime() <= to){
                        // one single active task, to be performed within given range from to
                        returnedTaskArray.add(tt);
                    }
                    else if (tt.isRepeated()){
                        if(( tt.getStartTime() > from && tt.getStartTime() <= to ) ||
                                (tt.getEndTime() > from && tt.getEndTime() <= to)){
                            // task fits boundary conditions
                            returnedTaskArray.add(tt);
                        }
                        else if (tt.getStartTime() <= from) {
                            int currtime = tt.getStartTime();
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

}
