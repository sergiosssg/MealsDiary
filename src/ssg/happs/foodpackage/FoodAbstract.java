package ssg.happs.foodpackage;

import ssg.happs.MeasurePaarUnitValue;
import ssg.happs.measures.MeasureUnits;

import java.util.EnumMap;

/**
 * Created by SSG on 03.07.2018.
 */
abstract public class FoodAbstract implements NutrientModel {


    //protected Map<String, NutrientModel> nutrients;  // here key is name of inserted nutrient

    protected EnumMap<ElementaryNutrient, MeasurePaarUnitValue> elementaryNutrientValues;

    protected String name;
    protected MeasureUnits typeOfMesureUnits;
    protected float amount;



    /**
     *
     */
    protected FoodAbstract(){
        this.name = "H2O";
        this.typeOfMesureUnits = MeasureUnits.GRAMMS;
        this.elementaryNutrientValues = new EnumMap<ElementaryNutrient, MeasurePaarUnitValue>(ElementaryNutrient.class);
        this.elementaryNutrientValues.put(ElementaryNutrient.LIQUID,
                new MeasurePaarUnitValue());
        this.amount = 0;
    }


    protected FoodAbstract(String _name){
        this.name = _name;
        this.typeOfMesureUnits = MeasureUnits.GRAMMS;
        this.elementaryNutrientValues = new EnumMap<ElementaryNutrient, MeasurePaarUnitValue>(ElementaryNutrient.class);
        this.elementaryNutrientValues.put(ElementaryNutrient.LIQUID,
                new MeasurePaarUnitValue());
        this.amount = 0;
    }


    protected FoodAbstract(String _name, ElementaryNutrient elementaryNutrient, MeasurePaarUnitValue _value){
        this.name = _name;
        this.typeOfMesureUnits = MeasureUnits.GRAMMS;
        this.elementaryNutrientValues = new EnumMap<ElementaryNutrient, MeasurePaarUnitValue>(ElementaryNutrient.class);
        this.elementaryNutrientValues.put(elementaryNutrient, _value);

        this.amount = _value.getAmount();
    }



    abstract public int getAmountOfNutrients();



    abstract public float showKiloCalories(boolean deepCalculate);
    abstract public float showGramOfProteins(boolean deepCalculate);
    abstract public float showGramOfCarbohydrates(boolean deepCalculate);
    abstract public float showGramOfFats(boolean deepCalculate);



    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void setName(String _name){
        this.name = _name;
    }

    @Override
    public float getAmount(){
        return this.amount;
    }

    @Override
    public void setAmount(float _amount){
        this.amount = _amount;
    }


} // class  FoodAbstract
