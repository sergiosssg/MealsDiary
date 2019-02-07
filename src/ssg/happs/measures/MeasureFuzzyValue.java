package ssg.happs.measures;


/**
 * Created by SSG on 03.07.2018.
 */

import ssg.happs.ObjectRoot;

/**
 *  As part of day's
 */


public enum MeasureFuzzyValue implements ObjectRoot {
    EXACT,
    ZERO,      //  0 %
    ALMOSTZERO, // от 0 % до 5 %
    TINY,      //  от 5 % до 15 %
    VERYSMALL, //  от 10 % до 25 %
    SMALL,     //  от 20 % до 40 %
    AVERAGE,   //  от 35 % до 65 %
    LARGE,     //  от 60 % до 75 %
    VERYLARGE, //  от 70 % до 85 %
    HUGE,      //  от 80 % до 95 %
    ALMOSTFULL, //  т 95 % до 100 %
    FULL;      //  100 %


    public int hashcode(){
        return -1;
    }



    public String getName() {
        switch (this){
            case ZERO:
                return "exact 0";
            case FULL:
                return "exact 100";
            case ALMOSTZERO:
                return "almost 0";
            case TINY:
                return "very very small";
            case VERYSMALL:
                return "very small";
            case SMALL:
                return "small";
            case AVERAGE:
                return "average";
            case LARGE:
                return "large";
            case VERYLARGE:
                return "very large";
            case HUGE:
                return "very very large";
            case ALMOSTFULL:
                return "almost 100";
            default:
                return "exact";
        }
    } // getName()

} // enum MeasureFuzzyValue
