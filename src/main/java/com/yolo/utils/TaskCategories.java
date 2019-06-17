package com.yolo.utils;


public enum TaskCategories {
    MEETING("MEETING"),
    PROJECT("PROJECT"),
    SHOPPING("SHOPPING"),
    LESSON("LESSON"),
    OUTDOOR("OUTDOOR");
    private String value;

    TaskCategories(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
