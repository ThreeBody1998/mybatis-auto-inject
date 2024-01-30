package com.demo.enums;

/**
 *  Http请求结果枚举类
 */
public enum HttpResultEnum {

    /**
     * 成功编号 200
     */
    SUCCESS(200,"操作成功"),
    /**
     * token无效 300
     */
    TOKEN_IS_EMPTY(300,"token为空"),
    /**
     * token无效 301
     */
    TOKEN_IS_INVALID(301,"token无效"),
    /**
     * token已过期 302
     */
    TOKEN_IS_EXPIRED(302,"token已过期"),
    /**
     * 参数为空 400
     */
    PARAM_IS_NULL(400,"参数为空"),

    /**
     * 参数不合法 401
     */
    PARAM_NOT_VALID(401,"参数不合法"),
    /**
     * 参数错误 402
     */
    PARAM_IS_ERROR(402,"参数错误"),
    /**
     * 操作不合法 402
     */
    OPERATE_VALID(403,"操作不合法"),
    /**
     * 权限不足 403
     */
    AUTHORITY_NOT_VALID(404,"权限不足"),

    /**
     * 请求方法错误，注意GET，POST等区分
     */
    REQUEST_METHOD_ERROR(405,"请求方法错误"),
    /**
     * 未知异常 500
     */
    SERVER_ERROR(500,"服务器异常"),
    /**
     * 新增失败 501
     */
    INSERT_FAIL(501,"新增失败"),
    /**
     * 删除失败 502
     */
    DELETE_FAIL(502,"删除失败"),

    /**
     * 修改失败 503
     */
    UPDATE_FAIL(503,"修改失败"),
    /**
     * 文件上传失败 504
     */
    FILE_UPLOAD_FAIL(504,"文件上传失败"),
    /**
     * IO异常 505
     */
    IO_EXCEPTION(505,"IO异常"),;




    /**
     * 根据code获取枚举
     * @param code  编号
     * @return
     */
    public static HttpResultEnum getHttpResultEnumByCode(Integer code){
        for(HttpResultEnum httpResultEnum:HttpResultEnum.values()){
            if(httpResultEnum.getCode().equals(code)){
                return httpResultEnum;
            }
        }
        return null;
    }

    private final Integer code;

    private final String msg;

    HttpResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
