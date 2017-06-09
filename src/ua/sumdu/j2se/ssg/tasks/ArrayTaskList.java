package ua.sumdu.j2se.ssg.tasks;

/**
 * Created by SSG on 24.05.2017.
 */
public class ArrayTaskList {

    private static final int MINIMAL_OF_TASKS_IN_ARRAY = 16;

    protected Task arrayOfTasks[];
    protected int sizeOfArray;


    public ArrayTaskList(){
        arrayOfTasks = null;
        sizeOfArray = 0;
    } // ArrayTaskList()


    public void add(Task task){
        if (task == null) throw new NullPointerException("Added task can't be null");
        if (sizeOfArray == 0){
           arrayOfTasks = new Task[1];
        } else if(sizeOfArray == arrayOfTasks.length){
           // expand of task array
           Task[] newArrayOfTasks = new Task[arrayOfTasks.length + 1];
           System.arraycopy(arrayOfTasks, 0, newArrayOfTasks,0, arrayOfTasks.length);
           arrayOfTasks = newArrayOfTasks;
        }
        arrayOfTasks[sizeOfArray++] =  task; // full copy of given task
    } // add(Task )

    public boolean remove(Task task){
        if(task == null) throw new NullPointerException("Task to be deleted can't be null");

        boolean success = false;

        if(sizeOfArray > 0){
            int index = 0;
            for(Task tt : arrayOfTasks){
                if(tt == task || tt.equals(task)){
                    // delete element
                    if(sizeOfArray > 1){
                        Task[] newArrayOfTasks = new Task[sizeOfArray - 1];
                        System.arraycopy(arrayOfTasks, 0, newArrayOfTasks, 0, index);
                        System.arraycopy(arrayOfTasks, index + 1, newArrayOfTasks, index, sizeOfArray - index - 1);
                        --sizeOfArray;
                        arrayOfTasks = newArrayOfTasks;
                    } else {
                        arrayOfTasks = new Task[MINIMAL_OF_TASKS_IN_ARRAY];
                        sizeOfArray = 0;
                    }
                    success = true;
                    return success;
                }
                ++index;
            } // for
        }
        return success;
    } // remove(Task )


    public int size(){
        return sizeOfArray;
    } // size()

    public Task getTask(int index){
        Task retTask = arrayOfTasks[index];
        return retTask;
    } // getTask(int )


    ArrayTaskList incoming(int from, int to){
        ArrayTaskList returnedTaskArray =  new ArrayTaskList();

        if(size() > 0  && from >= 0 && to >= 0 && ( to - from ) >= 0){
            for(Task tt : arrayOfTasks){
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
        return returnedTaskArray;
    } // incoming(int , int )


} // class ArrayTaskList
