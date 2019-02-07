package ssg.happs;

/**
 * Created by User on 05.02.2019.
 */
public interface EventModel extends ObjectRoot{

    long getBeginTime();

    String getEventName();

    long getID();

    AbonentModel getAbonent();

    TypeOfEvent getEventType();

} // interface EventModel
