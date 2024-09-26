package com.dosoar.email_security_demo.exception;

/**
 * 业务级异常基类
 */
public class BusinessException extends PlatformException {
    private static final long serialVersionUID = -9113297076948617320L;


    public BusinessException(ResponseCode responseCode) {
        super(responseCode);
    }


    public BusinessException(ResponseCode responseCode, Throwable e) {
        super(responseCode, e);
    }


    public BusinessException(ResponseCode responseCode, Object... errorMessageParams) {
        super(responseCode, errorMessageParams);
    }


    public BusinessException(ResponseCode responseCode, Throwable e, Object... errorMessageParams) {
        super(responseCode, e, errorMessageParams);
    }


}
