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

    public static <T> Result<T> duplicateKey() {
        return result(ResponseStatusEnum.DUPLICATE_KEY, null);
    }

    /**
     * set response
     *
     * @param status response status
     * @param data response data
     * @param <T> response type
     * @return {@link Result<T>}
     */
    public static <T> Result<T> result(ResponseStatusEnum status, T data) {
        return result(status.getCode(), status.getMessage(), data);
    }

    /**
     * set response
     *
     * @param code response status
     * @param message response info
     * @param data response data
     * @param <T> response type
     * @return {@link Result<T>}
     */
    public static <T> Result<T> result(String code, String message, T data) {
        return new Result<>(code, message, data);
    }
}
