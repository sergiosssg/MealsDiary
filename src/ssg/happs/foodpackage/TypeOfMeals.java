package ssg.happs.foodpackage;

import ssg.happs.ObjectRoot;

/**
 * Created by SSG on 03.06.2018.
 */
public enum TypeOfMeals implements ObjectRoot {
    EARLYBREAKFAST, // с 5-00 до 7-00
    BREAKFAST,      // с 6-00 до 10-00
    BRUNCH,         // с 9-00 до 12-00
    LUNCH,          // с 11-00 до 14-00
    DINNER,         // с 12-00 до 13-00
    LATEDINNER,     // c 14.00 до 16-00
    EARLYSUPPER,    // с 15.00 до 18.00
    SUPPER,         // с 17.00 до 19.00
    LATESUPPER,     // с 18.00 до 21.00
    EVENINGSNACK,   // с 20.00 до 23.00
    NIGHTSNACK;      // с 22.00 до 5-00

    public String getName(){

        switch (this){
            case EARLYBREAKFAST:
                return "early breakfast";
            case BREAKFAST:
                return "breakfast";
            case BRUNCH:
                return "brunch";
            case LUNCH:
                return "lunch";
            case DINNER:
                return "dinner";
            case LATEDINNER:
                return "late dinner";
            case EARLYSUPPER:
                return "early supper";
            case SUPPER:
                return "supper";
            case LATESUPPER:
                return "late supper";
            case EVENINGSNACK:
                return "evening snack";
            case NIGHTSNACK:
                return "night snack";
            default:
                return "";
        }
    }
} // enum TypeOfMeals
