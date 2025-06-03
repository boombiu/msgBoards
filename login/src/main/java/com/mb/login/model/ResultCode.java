package com.mb.login.model;

import lombok.Data;

@Data
public class ResultCode {
    // 成功状态码
    public static final Integer SUCCESS = 200;
    public static final String SUCCESS_MSG = "操作成功";

    // 失败状态码
    public static final Integer FAILED = 500;
    public static final String FAILED_MSG = "操作失败";

    // 参数验证失败
    public static final Integer VALIDATE_FAILED = 404;
    public static final String VALIDATE_FAILED_MSG = "参数检验失败";

    // 未登录或token过期
    public static final Integer UNAUTHORIZED = 401;
    public static final String UNAUTHORIZED_MSG = "暂未登录或token已经过期";

    // 无权限
    public static final Integer FORBIDDEN = 403;
    public static final String FORBIDDEN_MSG = "没有相关权限";

    // 用户相关错误码
    public static final Integer USER_NOT_EXIST = 1001;
    public static final String USER_NOT_EXIST_MSG = "用户不存在";
    
    public static final Integer USERNAME_OR_PASSWORD_ERROR = 1002;
    public static final String USERNAME_OR_PASSWORD_ERROR_MSG = "用户名或密码错误";
    
    public static final Integer USER_ALREADY_EXIST = 1003;
    public static final String USER_ALREADY_EXIST_MSG = "用户已存在";
    
    public static final Integer PASSWORD_ERROR = 1004;
    public static final String PASSWORD_ERROR_MSG = "密码错误";

    private Integer code;
    private String msg;
    private Object data;

    public ResultCode() {
    }

    public ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultCode(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功返回结果
     */
    public static ResultCode success() {
        return new ResultCode(SUCCESS, SUCCESS_MSG);
    }

    /**
     * 成功返回结果
     * @param data 获取的数据
     */
    public static ResultCode success(Object data) {
        return new ResultCode(SUCCESS, SUCCESS_MSG, data);
    }

    /**
     * 失败返回结果
     */
    public static ResultCode failed() {
        return new ResultCode(FAILED, FAILED_MSG);
    }

    /**
     * 失败返回结果
     * @param msg 提示信息
     */
    public static ResultCode failed(String msg) {
        return new ResultCode(FAILED, msg);
    }

    /**
     * 参数验证失败返回结果
     */
    public static ResultCode validateFailed() {
        return new ResultCode(VALIDATE_FAILED, VALIDATE_FAILED_MSG);
    }

    /**
     * 未登录返回结果
     */
    public static ResultCode unauthorized() {
        return new ResultCode(UNAUTHORIZED, UNAUTHORIZED_MSG);
    }

    /**
     * 未授权返回结果
     */
    public static ResultCode forbidden() {
        return new ResultCode(FORBIDDEN, FORBIDDEN_MSG);
    }
}
