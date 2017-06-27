package ua.sumdu.j2se.ssg.tasks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by SSG on 13.06.2017.
 */
public class LinkedTaskList extends TaskList {

    private class Node {
        Node next;
        Node prev;
        Task value;
    } // class Node


    public Iterator<Task> iterator(){
        return new LinkedListIterator();
    } // Iterator<Task> iterator()

    class LinkedListIterator implements Iterator<Task>{
        Node  nextNode;
        Node  lastReturnedNode = null;
        int   nextIndex;

        LinkedListIterator(){
            nextNode = head;

            nextIndex = 0;
        } // LinkedListIterator()

        @Override
        public boolean hasNext() {
            if(nextNode != null) return true;
            return false;
        } // boolean hasNext()

        @Override
        public Task next() {
            if(!hasNext()) throw new NoSuchElementException("There aren't next task in list");
            lastReturnedNode = nextNode;
            nextNode = nextNode.next;
            return lastReturnedNode.value;
        } // Task next()

        @Override
        public void remove() throws IllegalStateException, NoSuchElementException{
            if (lastReturnedNode == null)   throw new IllegalStateException();

            Node lastNext = lastReturnedNode.next;

            if(size() > 1){
                unlink(lastReturnedNode);
            } else {
                tail = head = null;
            }
            lastNext = null;
            sizeOfArray--;
        } // void remove()
    } // class LinkedListIterator

    Node head;
    Node tail;

    private void unlink (Node current){
        Task t = current.value;
        Node next = current.next;
        Node prev = current.prev;

        if (prev == null) { // first element to be deleted
            head = next;
        } else if (next == null) { // last element to e deleted
            tail = prev;
        } else {
            prev.next = next;
            //current.prev = null;
            next.prev = prev;
            //current.next = null;
        }
    } // unlink (Node )

    private void link2end (Task t){
        final Node lNode = tail;
        final Node newTaskNode = new Node(); //new Node<>(l, e, null);
        newTaskNode.prev = lNode; newTaskNode.next = null; newTaskNode.value = t;
        tail = newTaskNode;
        if (lNode == null)
            head = newTaskNode;
        else
            lNode.next = newTaskNode;
    } // link2end (Task )

    public LinkedTaskList (){
        sizeOfArray = 0;
        head = tail = null;
    } // LinkedTaskList ()


    @Override
    public void add(Task task) {
        try{
            if(task == null) throw new NullPointerException("Task can't be null");
            link2end(task );
            ++sizeOfArray;
        } catch (NullPointerException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    } // add(Task )

    @Override
    public boolean remove(Task task) {
        boolean success = false;

        try{
            if(task == null) throw new NullPointerException("Task to be deleted can't be null");
            if(size() > 0){

                int i = 0; Node curr = head;
                do{
                    Task tt = curr.value;
                    if(tt == task || tt.equals(task)){
                        // delete element
                        if(size() > 1){
                            unlink(curr);
                            --sizeOfArray;
                        } else {
                            tail = head = null;
                            sizeOfArray = 0;
                        }
                        success = true;
                    }
                    curr = curr.next;
                } while (!success && curr != null);// while
            }
        } catch (NullPointerException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            return success;
        }
    } // remove(Task )

    @Override
    public Task getTask(int index) {
        Task returnedTask = null;

        try{
            if(index < 0)  throw new NegativeArraySizeException("Index can't be negative");
            if( index >= size()) throw new ArrayIndexOutOfBoundsException("Index can't be greater of index of last element in list");

            Node curr = head;
            for (int i = 0; i < index; i++){
                curr = curr.next;
            }
            returnedTask = curr.value;
        } catch (ArrayIndexOutOfBoundsException | NegativeArraySizeException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            return returnedTask;
        }
    } // getTask(int )

}  // class LinkedTaskList
