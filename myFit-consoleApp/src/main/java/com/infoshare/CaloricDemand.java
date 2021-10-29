package com.infoshare;

import com.infoshare.Utils.UserDataBase;


public class CaloricDemand {
    private double PPM;
    private double CPM;
    private int weight = 84;
    private int height = 189;
    private int age = 24;
    private String gender = "male";
    private String levelOfJobActivity = "low";
    private String levelOfPrivateActivity = "medium";


    public double calculatePPM (){
        if (gender.equals("male")){
            PPM = (double) (10 * weight) + (6.25 * height) - (5 * age) + 5;
        } else {
            PPM = (double) (10 * weight) + (6.25 * height) - (5 * age) - 161;
        }
        return PPM;
    }

    public double calculateCPM (){
        if (levelOfPrivateActivity.equals("low") && levelOfJobActivity.equals("low")){
            CPM = PPM * 1.5;
        } else if ((levelOfPrivateActivity.equals("low") && levelOfJobActivity.equals("medium")) ||
                (levelOfPrivateActivity.equals("medium") && levelOfJobActivity.equals("low")) ){
            CPM = PPM * 1.7;
        } else if ((levelOfPrivateActivity.equals("low") && levelOfJobActivity.equals("high")) ||
                (levelOfPrivateActivity.equals("high") && levelOfJobActivity.equals("low"))){
            CPM = PPM * 1.9;
        } else if (levelOfPrivateActivity.equals("medium") && levelOfJobActivity.equals("medium")){
            CPM = PPM * 2;
        } else if (levelOfPrivateActivity.equals("high") && levelOfJobActivity.equals("high")){
            CPM = PPM * 2.2;
        }
        return CPM;
    }

}
