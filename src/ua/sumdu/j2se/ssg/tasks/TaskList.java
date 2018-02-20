package ua.sumdu.j2se.ssg.tasks;

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
} // class TaskList
