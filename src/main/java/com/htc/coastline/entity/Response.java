package com.htc.coastline.entity;

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
        Response<T> response = new Response<>();
        response.setModule(module);
        response.setCode(10000);
        response.setMessage("success");
        return response;
    }
}
