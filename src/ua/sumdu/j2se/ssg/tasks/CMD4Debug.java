package ua.sumdu.j2se.ssg.tasks;

/**
 * Created by SSG on 27.04.2017.
 */
public class CMD4Debug {
    public static void main(String [] args){


        Task t1 = new Task("some", 10);
        t1.setActive(true);



        int timeAfter1 = t1.nextTimeAfter(0);
        int timeAfter2 = t1.nextTimeAfter(9);
        int timeAfter3 = t1.nextTimeAfter(10);
        int timeAfter4 = t1.nextTimeAfter(100);

        System.out.printf("\n");

    }

}
