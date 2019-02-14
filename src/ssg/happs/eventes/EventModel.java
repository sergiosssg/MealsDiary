package ssg.happs.eventes;

import ssg.happs.AbonentModel;
import ssg.happs.ObjectRoot;

/**
 * Created by User on 05.02.2019.
 */
public interface EventModel extends ObjectRoot {

    long getBeginTime();

    long getDuration();

    String getEventName();

    long getID();

    AbonentModel getAbonent();

    TypeOfEvent getEventType();

} // interface EventModel
