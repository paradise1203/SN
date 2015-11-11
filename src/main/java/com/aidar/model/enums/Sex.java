package com.aidar.model.enums;

public enum Sex {

    MALE,
    FEMALE;

    public static Sex getSex(Integer n) {
        for (Sex s : values()) {
            if (s.ordinal() == n) {
                return s;
            }
        }
        return null;
    }

}
