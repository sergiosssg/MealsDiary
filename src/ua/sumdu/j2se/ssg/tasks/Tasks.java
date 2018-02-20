package ua.sumdu.j2se.ssg.tasks;

import java.util.*;

/**
 * Created by SSG on 26.12.2017.
 */
public class Tasks {
    private static final long MILISICONDS = 1000L;

    /**
     * Предикат находит время задачи, когла она самое раньше должна выполниться в
     * заданном интервале
     * @param task
     * @param start
     * @param stop
     * @return long целое, время в милисикундах, если задача выполняется в заданном интервале,
     *             и 0 в противном случае
     */
    private static long pGetEarliestTime(Task task, Date start, Date stop){
        long currTime = task.getStartTime().getTime();

        while(currTime <= start.getTime())
            currTime += task.getRepeatInterval()* MILISICONDS;
        if(currTime <= stop.getTime())
            return currTime;
        else
            return 0L;
    } // pGetEarliestTime(Task , Date )

    /**
     * Предикат определяет выполняется ди задача хотя бы раз в заланном интервале,
     * но через определенное число повторений
     * @param task
     * @param start
     * @param stop
     * @param hops - число повторений
     * @param fromBegining - если true повторения отсчитываются с начала выполнения задачи,
     *                     если false повторения отсчитываются с начала интервала
     * @return true если задача хотя бы раз выполняется, false в противном случае
     */
    private static boolean pIsInInterval(Task task, Date start, Date stop, int hops, boolean fromBegining){
        if(!task.isRepeated()){
            final Date currTime = task.getTime();
            return (currTime.after(start) && !currTime.after(stop));
        }
        long interval = task.getRepeatInterval() * MILISICONDS;
        long currTime = (fromBegining)? task.getTime().getTime() : pGetEarliestTime(task, start, stop);
        currTime += interval * hops;

        return (currTime > start.getTime() && currTime <= stop.getTime());
    } // pIsInInterval(Task, Date, Date, int, boolean)

    /**
     * Предикат определяет выполняется ди задача хотя бы раз в заланном интервале
     * @param task
     * @param start
     * @param stop
     * @return true если задача хотя бы раз выполняется, false в противном случае
     */
    private static boolean pIsTaskPerformed(Task task, Date start, Date stop){

        final Date taskStart = task.getStartTime();
        final Date taskStop = task.getEndTime();

        if(!task.isActive() || !taskStop.after(start) || taskStart.after(stop)) return false;
        final Date currentDate = task.getTime();
        if(!task.isRepeated() && currentDate.after(start) && !currentDate.after(stop))
            return true;
        if(task.isRepeated()){
            long task_interval = task.getRepeatInterval() * MILISICONDS;
            long timeOfTask = task.getStartTime().getTime();
            final long task_end = task.getEndTime().getTime();
            for(;timeOfTask <= start.getTime(); timeOfTask += task_interval){

            }
            return (timeOfTask > start.getTime() && timeOfTask <= stop.getTime() );
        }
        return false;
    } // pIsTaskPerformed(Task , Date , Date )

    /**
     * Получает коллекцию задач, которые хотя бы раз выполняются в заданном интервале
     * @param tasks
     * @param start
     * @param stop
     * @return возвращает коллекцию задач, которые хотя бы раз выполняются в заданном интервале
     */
    public static Iterable<Task> incoming(Iterable<Task> tasks, Date start, Date stop){
        Iterator<Task> it = tasks.iterator();
        TaskList taskList = new ArrayTaskList();
        try {
            while (it.hasNext()){
                final Task currTask = it.next();

                final Date taskStart = currTask.getStartTime();
                final Date taskStop = currTask.getEndTime();
                if(!currTask.isActive() || !taskStop.after(start) || taskStart.after(stop)) continue;
                long currTime = taskStart.getTime();
                if(currTask.isRepeated()){
                    for (currTime = taskStart.getTime();
                         currTime <= start.getTime();
                         currTime += currTask.getRepeatInterval()* MILISICONDS)
                        ;
                    if(currTime <= stop.getTime()){
                        taskList.add(currTask);
                    }
                }else{  // The task to be executed once only
                    if(currTime > start.getTime() && currTime <= stop.getTime())
                        taskList.add(currTask);
                }
            } // while
        } catch (IllegalArgumentException ex ){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            return taskList;
        }
    } // incoming(Iterable<Task> , Date , Date )

    /**
     *
     * @param tasks
     * @param start
     * @param stop
     * @return
     */
    public static SortedMap<Date, Set<Task>> calendar (Iterable<Task> tasks, Date start, Date stop){
        SortedMap<Date, Set<Task>> returnedMap = new TreeMap<>();
        try{
            final Iterable<Task> tasksInRange = incoming(tasks, start, stop);
            Iterator<Task> tasksIterator = tasksInRange.iterator();
            while ( tasksIterator.hasNext()){
                final Task currTask = tasksIterator.next();
                if(pIsTaskPerformed(currTask, start, stop)){
                    if(!currTask.isRepeated()){
                        if(returnedMap.containsKey(currTask.getTime())){
                            Set<Task> taskSet = returnedMap.get(currTask.getTime());
                            if(!taskSet.contains(currTask)){
                                taskSet.add(currTask);
                            }
                        }else{
                            Set<Task> taskSet = new HashSet<>();
                            taskSet.add(currTask);
                            returnedMap.put(currTask.getTime(), taskSet);
                        }
                    }else{
                        long _dateLong = pGetEarliestTime(currTask, start, stop);
                        for (int hops = 0;
                             _dateLong > start.getTime() && _dateLong <= stop.getTime();){
                            if(returnedMap.containsKey(new Date(_dateLong))){
                                Set<Task> setOfTasks = returnedMap.get(new Date(_dateLong));
                                if(!setOfTasks.contains(currTask)){
                                    setOfTasks.add(currTask);
                                }
                            }else{
                                Set<Task> taskset = new HashSet<>();
                                taskset.add(currTask);
                                returnedMap.put(new Date(_dateLong), taskset);
                            }
                            hops++;
                            _dateLong +=  currTask.getRepeatInterval() * MILISICONDS;
                        } // for
                    } // else
                } // if
            } // while
        } catch (IllegalArgumentException ex ){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            return returnedMap;
        }
    } // calendar (Iterable<Task> , Date , Date )
} // class Tasks