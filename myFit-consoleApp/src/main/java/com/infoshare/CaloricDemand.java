package com.infoshare;

import com.infoshare.Utils.UserDataBase;


public class CaloricDemand {
    UserDataBase userDataBase = new UserDataBase();
    UserLoginData userLoginData = new UserLoginData();
    private double PPM;
    private double CPM;
    private int weight;
    private int height;
    private int age;
    private String gender;
    private String levelOfPrivateActivity;
    private String levelOfJobActivity;


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
