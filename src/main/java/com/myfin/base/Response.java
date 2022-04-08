package com.myfin.base;

public class Response {
    /**
     * request success
     *
     */
    public static <T> Result<T> success(T data) {
        return result(ResponseStatusEnum.SUCCESS, data);
    }

    /**
     * System fail
     */
    public static <T> Result<T> fail(T data) {
        return result(ResponseStatusEnum.FAIL, data);
    }

    public static <T> Result<T> connectFail() {
        return result(ResponseStatusEnum.CONNECT_FAIL, null);
    }
    

    /**
     * 设置响应
     *
     * @param status 响应状态
     * @param data 要响应的数据
     * @param <T> 数据类型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> result(ResponseStatusEnum status, T data) {
        return result(status.getCode(), status.getMessage(), data);
    }

    /**
     * 设置响应
     *
     * @param code 响应状态
     * @param message 响应信息
     * @param data 要响应的数据
     * @param <T> 数据类型
     * @return {@link Result<T>}
     */
    public static <T> Result<T> result(String code, String message, T data) {
        return new Result<>(code, message, data);
    }
}
