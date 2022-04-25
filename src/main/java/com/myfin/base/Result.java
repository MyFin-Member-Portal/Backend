package com.myfin.base;

import java.io.Serializable;

/**
 * @author Zihang Gao
 */
public class Result<T> implements Serializable {
    /**
     * the message that need to return
     */
    private String message;

    /**
     *  status code
     */
    private String code;
    /**
     * error message
     */
    private T data;

    public Result(String code, String message, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public Result(ResponseStatusEnum enumResult,T data){
        this.code = enumResult.getCode();
        this.message = enumResult.getMessage();
        this.data = data;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
