package ssg.happs.measures;

import ssg.happs.ObjectRoot;
import ssg.happs.foodpackage.ElementaryNutrient;
import ssg.happs.foodpackage.NutrientModel;

public class MeasurePaarUnitValue implements NutrientModel {

    private MeasureValue mValue;
    private ElementaryNutrient eNutrient;


    @Override
    public boolean isSimple() {
        return true;
    }

    @Override
    public String getName() {
        return "[" + eNutrient.getName() + "]" + " : " + mValue.getName();
    }

    @Override
    public void setName(String name) {

    }

    public float getFoodAmount() {
        return mValue.getValue();
    }

    public void setFoodAmount(float _amount) {

    }

    @Override
    public boolean isEtalon() {
        return false;
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
        if(this.eNutrient != which) return null;
        return mValue;
    }


    // ??????????
    @Override
    public void addNewFood(NutrientModel element) {

    }

    public boolean isThisElementaryNutrient(ElementaryNutrient which){
        return (which == this.eNutrient);
    }


    public MeasurePaarUnitValue(){
        mValue = new MeasureValue();
        eNutrient =  ElementaryNutrient.UNKNOWN;
    } // MeasurePaarUnitValue(

    public MeasurePaarUnitValue(ElementaryNutrient eNutrient){
        this.eNutrient = eNutrient;
    } // MeasurePaarUnitValue(

    public MeasurePaarUnitValue(MeasureValue _mValue){
        this.mValue = _mValue;
    } // MeasurePaarUnitValue(

    public MeasurePaarUnitValue(
            ElementaryNutrient eNutrient,
            MeasureValue _mValue
    ){
        this.mValue = _mValue;
        this.eNutrient = eNutrient;

    } // MeasurePaarUnitValue(



    public boolean equals(Object obj){

        if(obj == null) return false;
        if(this == obj) return true;
        else if(!obj.getClass().equals(this.getClass())) return false;
        MeasurePaarUnitValue meObj = (MeasurePaarUnitValue) obj;
        /*
        if(this.mValue.getTypeOfMesurements() != meObj.getMesureUnit())
        */
        return false;
    }


    public int hashCode(){

        return ((this.eNutrient.hashCode() << 24 ) & 2147483520);
    }


    public String toString(){

        return "";
    }


}
