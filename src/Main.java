import ssg.happs.foodpackage.ElementaryNutrient;

public class Main {

    public static void main(String[] args) {
	// write your code here


       // MeasurePaarUnitValue  _measurePaarUnitValue = new MeasurePaarUnitValue();


        ElementaryNutrient eN = ElementaryNutrient.VITAMIN_C;


        System.out.printf("\n  eNutrient = %s,  hash  code = %d ", eN.getName(), eN.hashCode());

    }
}
