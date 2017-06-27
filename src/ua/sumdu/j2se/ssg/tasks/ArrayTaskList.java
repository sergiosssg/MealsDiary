package ua.sumdu.j2se.ssg.tasks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by SSG on 24.05.2017.
 */
public class ArrayTaskList extends TaskList{

    private static final int MINIMAL_OF_TASKS_IN_ARRAY = 16;

    private Task arrayOfTasks[];


    public ArrayTaskList(){
        arrayOfTasks = null;
        sizeOfArray = 0;
    } // ArrayTaskList()

    private void shrinkElement(int index){
        if(size() > 1){
            Task[] newArrayOfTasks = new Task[sizeOfArray - 1];
            System.arraycopy(arrayOfTasks, 0, newArrayOfTasks, 0, index);
            System.arraycopy(arrayOfTasks, index + 1, newArrayOfTasks, index, sizeOfArray - index - 1);
            --sizeOfArray;
            arrayOfTasks = newArrayOfTasks;
        } else {
            arrayOfTasks = new Task[MINIMAL_OF_TASKS_IN_ARRAY];
            sizeOfArray = 0;
        }
    } // void shrinkElement(int )



    @Override
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

    @Override
    public boolean remove(Task task){
        boolean success = false;

        try{
            if(task == null) throw new NullPointerException("Task to be deleted can't be null");
            if(size() > 0){
                int index = 0;
                for(Task tt : arrayOfTasks){
                    if(tt == task || tt.equals(task)){
                        // delete element
                        shrinkElement(index);
                        success = true;
                        break;
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

    @Override
    public Task getTask(int index){
        Task returnedTask = null;

        try{
            if(index < 0)  throw new NegativeArraySizeException("Index can't be negative");
            if( index >= size()) throw new ArrayIndexOutOfBoundsException("Index can't be greater of index of last element in array");

            returnedTask = arrayOfTasks[index];
        } catch (ArrayIndexOutOfBoundsException | NegativeArraySizeException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            return returnedTask;
        }
    } // getTask(int )


    public Iterator<Task> iterator(){
        return new ArrayListIterator();
    } // Iterator<Task> iterator()



    class ArrayListIterator implements Iterator<Task>{
        private int   nextIndex;
        private int lastReturned = -1;

        ArrayListIterator(){
            nextIndex = 0;

        }

        @Override
        public boolean hasNext() {
            if( nextIndex < size()) return true;
            return false;
        } // boolean hasNext()

        @Override
        public Task next() throws NoSuchElementException {

            int cursor = nextIndex;
            Task nextTask = null;

            try {
                nextTask = getTask(cursor);
                lastReturned = cursor;
                nextIndex = cursor + 1;
                return nextTask;
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
                System.err.println(e.getStackTrace());
                throw new NoSuchElementException();
            }
        } // Task next()

        @Override
        public void remove() throws IllegalStateException, NullPointerException, NoSuchElementException, UnsupportedOperationException{
            if (lastReturned == -1) {
                throw new IllegalStateException("it's necessary to call 'next' before");
            }
            shrinkElement(nextIndex = lastReturned);
            lastReturned = -1;
        } // void remove()
    } // class ArrayListIterator

} // class ArrayTaskList
