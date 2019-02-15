package ssg.happs.eventes;

import ssg.happs.ObjectRoot;

/**
 * Created by SSG on 05.02.2019.
 */
public enum TypeOfEvent implements ObjectRoot {
    DREAM,
    MEAL,
    HIKING,
    JOGGING,
    FITNES,
    SITTING,
    LAYING,
    TVWATCHING,
    NEARCOMPUTERSITTING,
    HARDWORKING,
    OFFICEWORKING;

    public String getName(){
        switch (this){
            case DREAM:
                return "dream";
            case MEAL:
                return "meal";
            case HIKING:
                return "hiking";
            case JOGGING:
                return "jogging";
            case FITNES:
                return "fitness";
            case SITTING:
                return "sitting";
            case LAYING:
                return "laying";
            case TVWATCHING:
                return "tv watching";
            case NEARCOMPUTERSITTING:
                return "near computer sitting";
            case HARDWORKING:
                return "hard working";
            case OFFICEWORKING:
                return "office working";
            default:
                return "";
        }
    } // getName(
} // enum TypeOfEvent
