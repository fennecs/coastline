package com.htc.coastline.entity;

import com.htc.coastline.constant.ResponseCode;

public class Response<T>  {
    private String message;
    private T module;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getModule() {
        return module;
    }

    public void setModule(T module) {
        this.module = module;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static <T> Response<T> success(T module){
        return get(ResponseCode.SUCCESS, module);
    }

    public static <T> Response<T> error(ResponseCode responseCode){
        return get(responseCode, null);
    }

    public static <T> Response<T> error(ResponseCode responseCode, T module){
        return get(responseCode, module);
    }

    public static <T> Response<T> get(ResponseCode responseCode, T module){
        Response<T> response = new Response<>();
        response.setModule(module);
        response.setCode(responseCode.getCode());
        response.setMessage(responseCode.getMsg());
        return response;
    }

}
