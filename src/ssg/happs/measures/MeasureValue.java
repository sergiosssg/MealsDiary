package ssg.happs.measures;

import ssg.happs.AbstractObject;

/**
 * Created by SSG on 02.07.2018.
 *
 * связка еденицы измерения и значения, причём в качестве значения может быть как точное число, с плавающей точкой,
 * так и нечеткое значение типа
 *
 */

public class MeasureValue implements AbstractObject, Constants {
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


    public MeasureValue(MeasureUnits _typeOfMesurements, float _value){
        this.typeOfMesurements = _typeOfMesurements;
        this.typeOfMegaTypeMesures =
                (this.typeOfMesurements == MeasureUnits.CALORIES || this.typeOfMesurements == MeasureUnits.KILOCALORIES)?  MeasureMegaObject.ENERGY:
                        (this.typeOfMesurements == MeasureUnits.SECONDS || this.typeOfMesurements == MeasureUnits.MINUTES ||
                                this.typeOfMesurements == MeasureUnits.HOURS || this.typeOfMesurements == MeasureUnits.DAYS ||
                                this.typeOfMesurements == MeasureUnits.WEEKS || this.typeOfMesurements == MeasureUnits.MONTHS ||
                                this.typeOfMesurements == MeasureUnits.YEARS)? MeasureMegaObject.TIME:
                                (this.typeOfMesurements == MeasureUnits.MILLIGRAMMS || this.typeOfMesurements == MeasureUnits.GRAMMS ||
                                        this.typeOfMesurements == MeasureUnits.KILOGRAMMS || this.typeOfMesurements == MeasureUnits.POUNDS)? MeasureMegaObject.WEIGHT:
                                        (this.typeOfMesurements == MeasureUnits.TEASPOONS || this.typeOfMesurements == MeasureUnits.SPOONS ||
                                                this.typeOfMesurements == MeasureUnits.GLASSFULS || this.typeOfMesurements == MeasureUnits.LITTERS ||
                                                this.typeOfMesurements == MeasureUnits.PINTS || this.typeOfMesurements == MeasureUnits.PINCHS)? MeasureMegaObject.VOLUME:
                                                (this.typeOfMesurements == MeasureUnits.PERCENTAGES || this.typeOfMesurements == MeasureUnits.ITEMS)? MeasureMegaObject.AMOUNT:
        MeasureMegaObject.UNKNOWN; // split into (is _typeOfMesurements of MeasureMegaObject.LENGTH)


        this.defined = true;
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

    /**
     * @param typeMesureUnit
     * @return
     *
     * @TODO: 31.01.2019
     */

    public float convertTo(MeasureUnits typeMesureUnit){
        if(!this.defined || !this.isExactValue()){
            return 0;
        } else if( this.typeOfMesurements == typeMesureUnit){
            return this.value;
        }else if((this.typeOfMesurements == MeasureUnits.SECONDS ||
                this.typeOfMesurements == MeasureUnits.MINUTES ||
                this.typeOfMesurements == MeasureUnits.HOURS ||
                this.typeOfMesurements == MeasureUnits.DAYS ||
                this.typeOfMesurements == MeasureUnits.WEEKS ||
                this.typeOfMesurements == MeasureUnits.MONTHS  ||
                this.typeOfMesurements == MeasureUnits.YEARS) &&
            (typeMesureUnit == MeasureUnits.SECONDS ||
                    typeMesureUnit == MeasureUnits.MINUTES ||
                    typeMesureUnit == MeasureUnits.HOURS ||
                    typeMesureUnit == MeasureUnits.DAYS ||
                    typeMesureUnit == MeasureUnits.WEEKS ||
                    typeMesureUnit == MeasureUnits.MONTHS  ||
                    typeMesureUnit == MeasureUnits.YEARS)){
            switch (typeMesureUnit){
                case SECONDS:
                    switch (this.typeOfMesurements){
                        case SECONDS:
                            return this.value;
                        case MINUTES:
                            return this.value * Constants.SECONDS_IN_MINUTE;
                        case HOURS:
                            return this.value * Constants.SECONDS_IN_HOUR;
                        case DAYS:
                            return this.value * Constants.SECONDS_IN_DAY;
                        case WEEKS:
                            return this.value * Constants.SECONDS_IN_DAY * 7;
                        case MONTHS:
                            return this.value * Constants.SECONDS_IN_MONTH;
                        case YEARS:
                            return this.value * Constants.SECONDS_IN_YEAR;
                        default:
                            return this.value * Constants.JUST_ONE_SECOND;
                    }
                case MINUTES:
                    switch (this.typeOfMesurements){
                        case SECONDS:
                            return this.value * Constants.MINUTE_IN_SECOND;
                        case MINUTES:
                            return this.value * Constants.JUST_ONE_MINUTE;
                        case HOURS:
                            return this.value * Constants.MINUTES_IN_HOUR;
                        case DAYS:
                            return this.value * Constants.MINUTES_IN_DAY;
                        case WEEKS:
                            return this.value * Constants.MINUTES_IN_DAY * 7;
                        case MONTHS:
                            return this.value * Constants.MINUTES_IN_MONTH;
                        case YEARS:
                            return this.value * Constants.MINUTES_IN_YEAR;
                        default:
                            return this.value;
                    }
                case HOURS:
                    switch (this.typeOfMesurements) {
                        case SECONDS:
                            return this.value * Constants.HOURS_IN_SECOND;
                        case MINUTES:
                            return this.value * Constants.HOURS_IN_MINUTE;
                        case HOURS:
                            return this.value * Constants.JUST_ONE_HOUR;
                        case DAYS:
                            return this.value * Constants.HOURS_IN_DAY;
                        case WEEKS:
                            return this.value * Constants.HOURS_IN_DAY * 7;
                        case MONTHS:
                            return this.value * Constants.HOURS_IN_MONTH;
                        case YEARS:
                            return this.value * Constants.HOURS_IN_YEAR;
                        default:
                            return this.value;
                    }
                case DAYS:
                    switch (this.typeOfMesurements) {
                        case SECONDS:
                            return this.value * Constants.DAYS_IN_SECOND;
                        case MINUTES:
                            return this.value * Constants.DAYS_IN_MINUTE;
                        case HOURS:
                            return this.value * Constants.DAYS_IN_HOUR;
                        case DAYS:
                            return this.value * Constants.JUST_ONE_DAY;
                        case WEEKS:
                            return this.value * Constants.JUST_ONE_DAY * 7;
                        case MONTHS:
                            return this.value * Constants.DAYS_IN_MONTH;
                        case YEARS:
                            return this.value * Constants.DAYS_IN_YEAR;
                        default:
                            return this.value;
                    }
                case WEEKS:
                    ;
                    break;
                case MONTHS:
                    ;
                    break;
                case YEARS:
                    ;
                    break;
                default:
                    ;
            }

        }
        else{ // выполняю конвертацию ...
            return 0;
        }
        return 0;
    } // convertTo(MeasureUnits )


    public int hashcode(){
        return -1;
    }


    @Override
    public String getName() {
        return fuzzyValue.getName() +" " + typeOfMegaTypeMesures.getName() + " " + typeOfMesurements.getName();
    } // getName()



} // class MeasureValue
