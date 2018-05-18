package com.htc.coastline.constant;

public enum Directory {
    ORIGIN_DIRECTORY("origin/"),

    GRAY_DIRECTORY("gray/"),

    THRESHOLD_DIRECTORY("threshold/"),

    EDGE_DIRECTORY("edge/");

    private String value;

    public static final String PROCESS_IMAGES_HOME = System.getProperty("user.home").replace("\\", "/").concat("/CoastlineProcess/");

    Directory(String value) {
        this.value = value;
    }

    public String getValue() {
        return PROCESS_IMAGES_HOME.concat(value);
    }
}
