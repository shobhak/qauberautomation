package com.qauber.common.value;

import java.util.Random;

/**
 * Created by Alya on 1/7/2017.
 */
public enum SexValue {
    Male("M"),
    Female("F"),
    Uni("U");

    private String value;

    SexValue(String value) {
        this.value = value;
    }

    public static SexValue getRandomValue(){
        Random random = new Random();
        int length = values().length;
        return values()[random.nextInt(length)];
    }

    public static SexValue getByValue(String value){
        for (SexValue sex : values()){
            if (sex.getValue().equals(value)){
                return sex;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
