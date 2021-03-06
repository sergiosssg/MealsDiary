package ssg.happs.foodpackage;

import ssg.happs.ObjectRoot;
import ssg.happs.measures.MeasureFuzzyValue;
import ssg.happs.measures.MeasureUnits;
import ssg.happs.measures.MeasureValue;

/**
 * Created by SSG on 14.02.2019.
 *
 * store food, can't be broken down into more simple food staff,
 * e.g.  fresh uncooked potato, tomato, white bread, ordinary crude milk etc.
 *
 */
public class FoodSimple extends FoodAbstract{



    public FoodSimple(){
        super();
    }


    @Override
    public int getAmountOfNutrients() {
        return super.elementaryNutrientValues.size();
    }

    @Override
    public float showKiloCalories(boolean deepCalculate) {
        return 0;
    }

    @Override
    public float showGramOfProteins(boolean deepCalculate) {
        return 0;
    }

    @Override
    public float showGramOfCarbohydrates(boolean deepCalculate) {
        return 0;
    }

    @Override
    public float showGramOfFats(boolean deepCalculate) {
        return 0;
    }

    @Override
    public boolean isSimple() {
        return true;
    }

    @Override
    public boolean isEtalon() {
        return true;
    }

    @Override
    public float calculateExactValue(ElementaryNutrient which, MeasureUnits inWhatMesureUnit, ObjectRoot whichDetailed) {
        return 0;
    }

    @Override
    public MeasureFuzzyValue calculateFuzzyValue(ElementaryNutrient which, MeasureUnits inWhatMesureUnit, ObjectRoot whichDetailed) {
        return null;
    }

    @Override
    public boolean isCalculable(ElementaryNutrient which) {
        return false;
    }

    @Override
    public MeasureValue getMeasureValue(ElementaryNutrient which) {
        return null;
    }


} // class FoodSimple
