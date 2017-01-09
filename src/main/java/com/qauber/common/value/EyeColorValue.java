package com.qauber.common.value;

import java.util.Random;

/**
 * Created by Alya on 1/8/2017.
 */
public enum EyeColorValue {
    Black("BLK"),
    Blue("BLU"),
    Brown("BRO"),
    Gray("GRY"),
    Green("GRN"),
    Hazel("HAZ"),
    Multicolor("MUL"),
    Unknown("XXX");

    private String value;

    EyeColorValue(String value) {
        this.value = value;
    }

    public static EyeColorValue getRandomValue(){
        Random random = new Random();
        int length = values().length;
        return values()[random.nextInt(length)];
    }

    public String getValue() {
        return value;
    }
}
