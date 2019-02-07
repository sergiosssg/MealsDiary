package ssg.happs;

/**
 * Created by User on 05.02.2019.
 */
public enum TypeOfSchedule implements ObjectRoot{
    PLANED,
    REALIZED;

    public String getName(){
        switch (this){
            case PLANED:
                return "planned";
            case REALIZED:
                return "realized";
            default:
                return "";
        }

    }
}
