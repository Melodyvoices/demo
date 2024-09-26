package com.dosoar.email_security_demo.exception;

import java.io.Serializable;

/**
 * @date 2024/5/20 10:46
 */
public class ResponseCode implements Serializable {
    public static final ResponseCode SUCCESS = new ResponseCode("SUCCESS", "请求成功");
    public static final ResponseCode EXCEPTION_WITHOUT_INFO = new ResponseCode("EXCEPTION", "请求异常");
    public static final ResponseCode INVALID_PARAMETER_EXCEPTION = new ResponseCode("INVALID_PARAMETER_EXCEPTION", "请求参数异常");
    public static final ResponseCode INVALID_JSON_EXCEPTION = new ResponseCode("INVALID_JSON_EXCEPTION", "非法json参数异常");
    public static final ResponseCode GENERAL_EXCEPTION = new ResponseCode("GENERAL_EXCEPTION", "%s");
    public static final ResponseCode DATA_ACCESS_EXCEPTION = new ResponseCode("DATA_ACCESS_EXCEPTION", "数据访问异常");
    public static final ResponseCode SQL_SYNTAX_ERROR_EXCEPTION = new ResponseCode("SQL_SYNTAX_ERROR_EXCEPTION", "%s");
    public static final ResponseCode SQL_EXCEPTION = new ResponseCode("SQL_EXCEPTION", "%s");

    protected String code;
    protected String messageFormatter;


    /**
     * @deprecated
     * 只是为了序列化框架调用
     */
    @Deprecated
    public ResponseCode() {}
    protected ResponseCode(String code, String messageFormatter) {
        this.code = code;
        this.messageFormatter = messageFormatter;
    }


    public String getCode() {
        return code;
    }
    public String getMessageFormatter() {
        return messageFormatter;
    }
    public String generateErrorMessage(Object... args) {
        if (null == args || args.length == 0) {
            return messageFormatter;
        }
        return String.format(messageFormatter, args);
    }
}
