package ua.sumdu.j2se.ssg.tasks;

/**
 * Created by SSG on 24.05.2017.
 */
public class ArrayTaskList extends TaskList{

    private static final int MINIMAL_OF_TASKS_IN_ARRAY = 16;

    protected Task arrayOfTasks[];
    protected int sizeOfArray;


    public ArrayTaskList(){
        arrayOfTasks = null;
        sizeOfArray = 0;
    } // ArrayTaskList()


    public void add(Task task){
        try{
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
        } catch (NullPointerException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    } // add(Task )

    public boolean remove(Task task){
        boolean success = false;

        try{
            if(task == null) throw new NullPointerException("Task to be deleted can't be null");
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
        } catch (NullPointerException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            return success;
        }
    } // remove(Task )


    public int size(){
        return sizeOfArray;
    } // size()

    public Task getTask(int index){
        Task retTask = arrayOfTasks[index];
        return retTask;
    } // getTask(int )


} // class ArrayTaskList
