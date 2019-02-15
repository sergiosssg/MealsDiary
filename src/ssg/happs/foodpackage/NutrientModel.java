package ssg.happs.foodpackage;

import ssg.happs.ObjectRoot;
import ssg.happs.measures.MeasureFuzzyValue;
import ssg.happs.measures.MeasureUnits;
import ssg.happs.measures.MeasureValue;

/**
 * Created by SSG on 02.07.2018.
 */
public interface NutrientModel extends ObjectRoot {

    public boolean isSimple();

    public String getName();

    public void setName(String name);

    public float getFoodAmount();

    public void setFoodAmount(float _amount);

    public boolean isEtalon();

    /**
     *
     * @ TODO: 08.11.2018 need to simplify this function, cut last argument ObjectRoot
     *
     *
     * @param which
     * @param inWhatMesureUnit
     * @param whichDetailed
     * @return
     */

    float calculateExactValue(ElementaryNutrient which, MeasureUnits inWhatMesureUnit, ObjectRoot whichDetailed);

    MeasureFuzzyValue calculateFuzzyValue(ElementaryNutrient which, MeasureUnits inWhatMesureUnit, ObjectRoot whichDetailed);

    boolean isCalculable(ElementaryNutrient which);

    MeasureValue getMeasureValue(ElementaryNutrient which);

    void addNewFood(NutrientModel element);

} // interface NutrientModel
