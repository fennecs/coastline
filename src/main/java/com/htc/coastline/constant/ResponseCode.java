package com.htc.coastline.constant;

public enum  ResponseCode {
    SUCCESS(10000, "调用成功"),

    EVEN_REQUEST(20001, "参数必须是偶数")
    ;
    private String msg;
    private int code;

    ResponseCode( int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
