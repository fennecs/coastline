package com.htc.coastline.constant;

public enum Directory {
    ORIGIN_DIRECTORY("classpath:static/images/origin/"),

    GRAY_DIRECTORY("classpath:static/images/gray/"),

    THRESHOLD_DIRECTORY("classpath:static/images/threshold/"),

    EDGE_DIRECTORY("classpath:static/images/edge/");

    private String value;

    Directory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
