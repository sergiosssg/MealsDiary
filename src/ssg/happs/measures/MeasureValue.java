package ssg.happs.measures;

import ssg.happs.AbstractObject;

/**
 * Created by SSG on 02.07.2018.
 *
 * связка еденицы измерения и значения, причём в качестве значения может быть как точное число, с плавающей точкой,
 * так и нечеткое значение типа
 *
 */

public class MeasureValue implements AbstractObject {
    /**
     *  either exact value or fuzzy value is assigned
     */

    private float value;
    private MeasureFuzzyValue fuzzyValue;

    private MeasureUnits typeOfMesurements;
    private MeasureMegaObject typeOfMegaTypeMesures;

    private boolean defined;

    public MeasureValue(){
        this.defined = false;
        this.value = 0;
        this.typeOfMesurements = MeasureUnits.UNKNOWN;
        this.typeOfMegaTypeMesures = MeasureMegaObject.UNKNOWN;
    } // MeasureValue(

    public MeasureValue(MeasureUnits _typeOfMesurements,
                        MeasureMegaObject _typeOfMegaTypeMesures,
                        float _value){

        this.typeOfMesurements = _typeOfMesurements;
        this.typeOfMegaTypeMesures = _typeOfMegaTypeMesures;
        this.value = _value;
        if(_value == 0) {
            this.fuzzyValue = MeasureFuzzyValue.ZERO;
        } else {
            this.fuzzyValue = MeasureFuzzyValue.EXACT;
        }
        this.defined = true;
    } // MeasureValue(

    public MeasureValue(MeasureUnits _typeOfMesurements,
                        MeasureMegaObject _typeOfMegaTypeMesures,
                        MeasureFuzzyValue _fuzzyValue){
        this.typeOfMesurements = _typeOfMesurements;
        this.typeOfMegaTypeMesures = _typeOfMegaTypeMesures;
        if(_fuzzyValue == MeasureFuzzyValue.FULL){
            this.value = 100;
        } else {
            this.value = 0;
        }
        this.fuzzyValue = _fuzzyValue;
        this.defined = true;
    } // MeasureValue(


    /**
     *
     * @return true if any value asigned
     */
    public boolean isDefined(){
        return this.defined;
    }

    /**
     *
     * @return exact value in any time
     */
    public float getValue(){
        return this.value;
    }

    public void setValue(float _value){
        if(_value == 0){
            this.fuzzyValue = MeasureFuzzyValue.ZERO;
        } else {
            this.fuzzyValue = MeasureFuzzyValue.EXACT;
        }
        this.value = _value;
        this.defined = true;
    }

    /**
     *
     * @return unit of  as it assigned
     */
    public MeasureUnits getTypeOfMesurements(){
        return this.typeOfMesurements;
    }
    public void setTypeOfMesurements(MeasureUnits _typeOfMesurements){
        this.typeOfMesurements = _typeOfMesurements;
    }

    public MeasureMegaObject getMegaTypeMesures(){
        return this.typeOfMegaTypeMesures;
    }

    public void setMegaTypeMesures(MeasureMegaObject _typeOfMegaTypeMesures){
        this.typeOfMegaTypeMesures = _typeOfMegaTypeMesures;
    }

    public MeasureFuzzyValue getFuzzyValue(){
        return this.fuzzyValue;
    }

    public void setFuzzyValue(MeasureFuzzyValue _fuzzyValue){
        if(_fuzzyValue == MeasureFuzzyValue.FULL){
            this.value = 100;
        } else {
            this.value = 0;
        }
        this.fuzzyValue = _fuzzyValue;
        this.defined = true;
    }

    public boolean isExactValue(){
        return (this.defined && (this.fuzzyValue == MeasureFuzzyValue.EXACT ||
                          this.fuzzyValue == MeasureFuzzyValue.ZERO ||
                          this.fuzzyValue == MeasureFuzzyValue.FULL));
    }

    public float convertTo(MeasureUnits typeMesureUnit){
        if(!this.defined || !this.isExactValue()){
            return 0;
        } else if( this.typeOfMesurements == typeMesureUnit){
            return this.value;
        }else{ // выполняю конвертацию ...
            return 0;
        }
    } // convertTo(MeasureUnits )


    public int hashcode(){
        return -1;
    }


    @Override
    public String getName() {
        return fuzzyValue.getName() +" " + typeOfMegaTypeMesures.getName() + " " + typeOfMesurements.getName();
    } // getName()



} // class MeasureValue
