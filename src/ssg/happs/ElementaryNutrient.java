package ssg.happs;

/**
 * Created by SSG on 02.07.2018.
 */
public enum ElementaryNutrient implements AbstractObject {
    UNKNOWN,
    ENERGY,
    PROTEINS,
    CARBOHYDRATES,
    FATS_TOTAL,
    FAT_OMEGA3,
    FAT_OMEGA6,
    FAT_OMEGA9,
    FIBRE,
    LIQUID,
    MICROELEMENTS_TOTAL,
    VITAMINS_TOTAL,
    VITAMIN_A,
    VITAMIN_B_TOTAL,
    VITAMIN_B1,  // тиамин
    VITAMIN_B2,  // рыбофлавин
    VITAMIN_B3,  // ниациамид
    VITAMIN_B5,  // пантотеновая кислота
    VITAMIN_B6,  // адермин
    VITAMIN_B7,  // биотин
    VITAMIN_B9,  // фолиевая кислота
    VITAMIN_B12, // группа кобальтсодержащих биологически активных веществ
    VITAMIN_C,   // аскорбиновая кислота
    VITAMIN_D3,
    VITAMIN_E,   // токоферолы и токотриенолы
    MINERALS_TOTAL,
    MINERAL_CR,  // хром
    MINERAL_CU,  // медь
    MINERAL_SE,  // селен
    MINERAL_MG,  // магний
    MINERAL_CA,  // кальций
    MINERAL_K,   // калий
    MINERAL_NA,  // натрий
    MINERAL_FE,  // железо
    MINERAL_ZN,  // цинк
    MINERAL_J,   // йод
    MINERAL_MN,  // марганец
    MINERAL_P,   // фосфор
    MINERAL_F,   // фтор
    MINERAL_MO;  // молибден


    public int hashcode(){
        switch (this){
            case ENERGY:
                return 1;
            case PROTEINS:
                return 2;
            case CARBOHYDRATES:
                return 3;
            case FATS_TOTAL:
                return 4;
            case FAT_OMEGA3:
                return 5;
            case FAT_OMEGA6:
                return 6;
            case FAT_OMEGA9:
                return 7;
            case FIBRE:
                return 8;
            case LIQUID:
                return 9;
            case MICROELEMENTS_TOTAL:
                return 10;
            case VITAMINS_TOTAL:
                return 11;
            case VITAMIN_A:
                return 12;
            case VITAMIN_B_TOTAL:
                return 13;
            case VITAMIN_B1:
                return 14;
            case VITAMIN_B2:
                return 15;
            case VITAMIN_B3:
                return 16;
            case VITAMIN_B5:
                return 17;
            case VITAMIN_B6:
                return 18;
            case VITAMIN_B7:
                return 19;
            case VITAMIN_B9:
                return 20;
            case VITAMIN_B12:
                return 21;
            case VITAMIN_C:
                return 22;
            case VITAMIN_D3:
                return 23;
            case VITAMIN_E:
                return 24;
            case MINERALS_TOTAL:
                return 25;
            case MINERAL_CR:
                return 26;
            case MINERAL_CU:
                return 27;
            case MINERAL_SE:
                return 28;
            case MINERAL_MG:
                return 29;
            case MINERAL_CA:
                return 30;
            case MINERAL_K:
                return 31;
            case MINERAL_NA:
                return 32;
            case MINERAL_FE:
                return 33;
            case MINERAL_ZN:
                return 34;
            case MINERAL_J:
                return 35;
            case MINERAL_MN:
                return 36;
            case MINERAL_P:
                return 37;
            case MINERAL_F:
                return 38;
            case MINERAL_MO:
                return 39;
            default:
                return 0;
        }
    } // hashcode(

    @Override
    public String getName() {
        switch (this){
            case ENERGY:
                return "energy";
            case PROTEINS:
                return "proteins";
            case CARBOHYDRATES:
                return "carbohydrates";
            case FATS_TOTAL:
                return "fats_total";
            case FAT_OMEGA3:
                return "fat_omega3";
            case FAT_OMEGA6:
                return "fat_omega6";
            case FAT_OMEGA9:
                return "fat_omega9";
            case FIBRE:
                return "fibre";
            case LIQUID:
                return "liquid";
            case MICROELEMENTS_TOTAL:
                return "microelements_total";
            case VITAMINS_TOTAL:
                return "vitamins_total";
            case VITAMIN_A:
                return "vitamin_a";
            case VITAMIN_B_TOTAL:
                return "vitamin_b_total";
            case VITAMIN_B1:
                return "vitamin_b1";
            case VITAMIN_B2:
                return "vitamin_b2";
            case VITAMIN_B3:
                return "vitamin_b3";
            case VITAMIN_B5:
                return "vitamin_b5";
            case VITAMIN_B6:
                return "vitamin_b6";
            case VITAMIN_B7:
                return "vitamin_b7";
            case VITAMIN_B9:
                return "vitamin_b9";
            case VITAMIN_B12:
                return "vitamin_b12";
            case VITAMIN_C:
                return "vitamin_c";
            case VITAMIN_D3:
                return "vitamin_d3";
            case VITAMIN_E:
                return "vitamin_e";
            case MINERALS_TOTAL:
                return "minerals_total";
            case MINERAL_CR:
                return "mineral_cr";
            case MINERAL_CU:
                return "mineral_cu";
            case MINERAL_SE:
                return "mineral_se";
            case MINERAL_MG:
                return "mineral_mg";
            case MINERAL_CA:
                return "mineral_ca";
            case MINERAL_K:
                return "mineral_k";
            case MINERAL_NA:
                return "mineral_na";
            case MINERAL_FE:
                return "mineral_fe";
            case MINERAL_ZN:
                return "mineral_zn";
            case MINERAL_J:
                return "mineral_j";
            case MINERAL_MN:
                return "mineral_mn";
            case MINERAL_P:
                return "mineral_p";
            case MINERAL_F:
                return "mineral_f";
            case MINERAL_MO:
                return "mineral_mo";
            default:
                return "unknown";
        } // switch (
    } //getName()



    public ElementaryNutrient name2enum(String _name){
        if(_name != null && !_name.isEmpty()){

                if(_name.equalsIgnoreCase("ENERGY") ){
                    return ENERGY;
                } else if(_name.equalsIgnoreCase("PROTEINS")){
                    return PROTEINS;
                } else if(_name.equalsIgnoreCase("CARBOHYDRATES")){
                    return CARBOHYDRATES;
                } else if(_name.equalsIgnoreCase("FATS_TOTAL")){
                    return FATS_TOTAL;
                } else if(_name.equalsIgnoreCase("FAT_OMEGA3")){
                    return FAT_OMEGA3;
                } else if(_name.equalsIgnoreCase("FAT_OMEGA6")){
                    return FAT_OMEGA6;
                } else if(_name.equalsIgnoreCase("FAT_OMEGA9")){
                    return FAT_OMEGA9;
                } else if(_name.equalsIgnoreCase("FIBRE")){
                    return FIBRE;
                } else if(_name.equalsIgnoreCase("LIQUID")){
                    return LIQUID;
                } else if(_name.equalsIgnoreCase("MICROELEMENTS_TOTAL")){
                    return MICROELEMENTS_TOTAL;
                } else if(_name.equalsIgnoreCase("VITAMINS_TOTAL")){
                    return VITAMINS_TOTAL;
                } else if(_name.equalsIgnoreCase("VITAMIN_A")){
                    return VITAMIN_A;
                } else if(_name.equalsIgnoreCase("VITAMIN_B_TOTAL")){
                    return VITAMIN_B_TOTAL;
                } else if(_name.equalsIgnoreCase("VITAMIN_B1")){
                    return VITAMIN_B1;
                } else if(_name.equalsIgnoreCase("VITAMIN_B2")){
                    return VITAMIN_B2;
                } else if(_name.equalsIgnoreCase("VITAMIN_B3")){
                    return VITAMIN_B3;
                } else if(_name.equalsIgnoreCase("VITAMIN_B5")){
                    return VITAMIN_B5;
                } else if(_name.equalsIgnoreCase("VITAMIN_B6")){
                    return VITAMIN_B6;
                } else if(_name.equalsIgnoreCase("VITAMIN_B7")){
                    return VITAMIN_B7;
                } else if(_name.equalsIgnoreCase("VITAMIN_B9")){
                    return VITAMIN_B9;
                } else if(_name.equalsIgnoreCase("VITAMIN_B12")){
                    return VITAMIN_B12;
                } else if(_name.equalsIgnoreCase("VITAMIN_C")){
                    return VITAMIN_C;
                } else if(_name.equalsIgnoreCase("VITAMIN_D3")){
                    return VITAMIN_D3;
                } else if(_name.equalsIgnoreCase("VITAMIN_E")){
                    return VITAMIN_E;
                } else if(_name.equalsIgnoreCase("MINERALS_TOTAL")){
                    return MINERALS_TOTAL;
                } else if(_name.equalsIgnoreCase("MINERAL_CR")){
                    return MINERAL_CR;
                } else if(_name.equalsIgnoreCase("MINERAL_CU")){
                    return MINERAL_CU;
                } else if(_name.equalsIgnoreCase("MINERAL_SE")){
                    return MINERAL_SE;
                } else if(_name.equalsIgnoreCase("MINERAL_MG")){
                    return MINERAL_MG;
                } else if(_name.equalsIgnoreCase("MINERAL_CA")){
                    return MINERAL_CA;
                } else if(_name.equalsIgnoreCase("MINERAL_K")){
                    return MINERAL_K;
                } else if(_name.equalsIgnoreCase("MINERAL_NA")){
                    return MINERAL_NA;
                } else if(_name.equalsIgnoreCase("MINERAL_FE")){
                    return MINERAL_FE;
                } else if(_name.equalsIgnoreCase("MINERAL_ZN")){
                    return MINERAL_ZN;
                } else if(_name.equalsIgnoreCase("MINERAL_J")){
                    return MINERAL_J;
                } else if(_name.equalsIgnoreCase("MINERAL_MN")){
                    return MINERAL_MN;
                } else if(_name.equalsIgnoreCase("MINERAL_P")){
                    return MINERAL_P;
                } else if(_name.equalsIgnoreCase("MINERAL_F")){
                    return MINERAL_F;
                } else if(_name.equalsIgnoreCase("MINERAL_MO")){
                    return MINERAL_MO;
                } else {
                    return UNKNOWN;
                }
        } else  {
            return UNKNOWN;
        }
    }

} // enum ElementaryNutrient
