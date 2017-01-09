package com.qauber.common.value;

import java.util.Random;

/**
 * Created by Alya on 1/8/2017.
 */
public enum BuildValue {
    Athletic("A"),
    Heavy("H"),
    Large("L"),
    Obese("O"),
    PotBelly("P"),
    Small("S"),
    Stocky("Y"),
    Thin("T");

    private String value;

    BuildValue(String value) {
        this.value = value;
    }

    public static BuildValue getRandomValue(){
        Random random = new Random();
        int length = values().length;
        return values()[random.nextInt(length)];
    }

    public String getValue() {
        return value;
    }
}
