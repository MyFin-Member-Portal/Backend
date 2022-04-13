package com.myfin.base;

public enum ResponseStatusEnum implements ValueEnum<String> {
    /**
     * 请求的响应错误码
     */

    SUCCESS("200", "Success"), 
    FAIL("A100", "Bad request"), 
    CONNECT_FAIL("C102", "连接数据库失败");

    private String code;
    private String message;

    ResponseStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getValue() {
        return code;
    }
}