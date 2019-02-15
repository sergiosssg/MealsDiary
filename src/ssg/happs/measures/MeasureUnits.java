package ssg.happs.measures;

import ssg.happs.ObjectRoot;

/**
 * Created by SSG on 02.07.2018.
 */


public enum MeasureUnits implements ObjectRoot {
    UNKNOWN,
    FUZZY,
    PERCENTAGES,
    CALORIES,
    KILOCALORIES,
    ITEMS,
    MILLIGRAMMS,
    GRAMMS,
    PINCHS,   // щепотка
    TEASPOONS,
    SPOONS,
    GLASSFULS,
    POUNDS,
    LITTERS,
    PINTS,
    KILOGRAMMS,
    SECONDS,
    MINUTES,
    HOURS,
    DAYS,
    WEEKS,
    MONTHS,
    YEARS;

    public int hashcode(){
        return -1;
    }

    public String getName(){
        switch (this){
            case FUZZY:
                return "fuzzy";
            case PERCENTAGES:
                return "percentages";
            case CALORIES:
                return "calories";
            case ITEMS:
                return "items";
            case MILLIGRAMMS:
                return "milligramms";
            case GRAMMS:
                return "gramms";
            case PINCHS:
                return "pinchs";
            case TEASPOONS:
                return "teaspoonsu";
            case SPOONS:
                return "spoons";
            case GLASSFULS:
                return "glassfuls";
            case POUNDS:
                return "pounds";
            case LITTERS:
                return "litters";
            case PINTS:
                return "pints";
            case KILOGRAMMS:
                return "kilogramms";
            case SECONDS:
                return "seconds";
            case MINUTES:
                return "minutes";
            case HOURS:
                return "hours";
            case DAYS:
                return "days";
            case WEEKS:
                return "weeks";
            case YEARS:
                return "years";
            case MONTHS:
                return "months";
            default:
                return "unknown";
        }
    } // getName()

} //
