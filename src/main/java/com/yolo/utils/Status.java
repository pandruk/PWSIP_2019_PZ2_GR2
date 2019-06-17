package com.yolo.utils;


public enum Status {
    ACTIVE("ACTIVE"), PASSIVE("PASSIVE");
    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
