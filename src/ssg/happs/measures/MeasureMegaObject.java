package ssg.happs.measures;

import ssg.happs.AbstractObject;

/**
 * Created by SSG on 03.07.2018.
 */
public enum MeasureMegaObject implements AbstractObject {
    UNKNOWN,
    WEIGHT,
    LENGTH,
    TIME,
    ENERGY,
    AMOUNT,
    VOLUME;

    public int hashcode(){
        return -1;
    }


    @Override
    public String getName() {
        switch (this){
            case WEIGHT:
                return "weight";
            case LENGTH:
                return "length";
            case TIME:
                return "time";
            case ENERGY:
                return "energy";
            case AMOUNT:
                return "amount";
            case VOLUME:
                return "volume";
            default:
                return "unknown";
        }
    } // getName()
} // enum MeasureMegaObject
