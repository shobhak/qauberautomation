package com.qauber.common.value;

import java.util.Random;

/**
 * Created by Alya on 1/8/2017.
 */
public enum SuspectTypeValue {
    RP("R/P"),
    Suspect("Suspect"),
    Victim("Victim"),
    Witness("Witness"),
    Other("Other");

    private String value;

    SuspectTypeValue(String value) {
        this.value = value;
    }

    public static SuspectTypeValue getRandomValue() {
        Random random = new Random();
        int length = values().length;
        return values()[random.nextInt(length)];
    }

    public String getValue() {
        return value;
    }
}
