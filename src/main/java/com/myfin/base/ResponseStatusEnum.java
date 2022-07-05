package com.myfin.base;

/**
 * @author Zihang Gao
 */

public enum ResponseStatusEnum implements ValueEnum<String> {
    /**
     * response error code
     */

    SUCCESS("200", "Success"), 
    FAIL("A100", "Bad request"),
    DUPLICATE_KEY("A101", "User exist"), 
    CONNECT_FAIL("C100", "failed to connect database");

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