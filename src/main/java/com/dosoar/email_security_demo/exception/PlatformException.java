package com.dosoar.email_security_demo.exception;

/**
 * 平台级异常基类
 */
public class PlatformException extends RuntimeException {
    private static final long serialVersionUID = 4482113391177005660L;

    /** 内部错误码 */
    private ResponseCode responseCode;

    /** 异常参数 */
    private Object[] errorMessageParams;

    /** 异常信息 */
    private String errorMessage;

    private Object extraData;


    public PlatformException() {
        super("");
        setResponseCode(ResponseCode.EXCEPTION_WITHOUT_INFO);
    }

    public PlatformException(final Throwable cause) {
        super(cause);
        setResponseCode(ResponseCode.EXCEPTION_WITHOUT_INFO);
    }


    public PlatformException(ResponseCode responseCode) {
        super(responseCode.getMessageFormatter());

        this.responseCode = responseCode;
        this.errorMessage = responseCode.getMessageFormatter();
    }
    public PlatformException(ResponseCode responseCode, Object... errorMessageParams) {
        super(responseCode.generateErrorMessage(errorMessageParams));

        this.responseCode = responseCode;
        this.errorMessageParams = errorMessageParams;
        this.errorMessage = responseCode.generateErrorMessage(errorMessageParams);
    }


    public PlatformException(ResponseCode responseCode, Throwable e) {
        super(responseCode.getMessageFormatter(), e);

        this.responseCode = responseCode;
        this.errorMessage = responseCode.getMessageFormatter();
    }
    public PlatformException(ResponseCode responseCode, Throwable e, Object... errorMessageParams) {
        super(responseCode.generateErrorMessage(errorMessageParams), e);

        this.responseCode = responseCode;
        this.errorMessageParams = errorMessageParams;
        this.errorMessage = responseCode.generateErrorMessage(errorMessageParams);
    }



    public ResponseCode getResponseCode() {
        return responseCode;
    }
    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public Object[] getErrorMessageParams() {
        return errorMessageParams;
    }
    public void setErrorMessageParams(Object[] errorMessageParams) {
        this.errorMessageParams = errorMessageParams;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getExtraData() {
        return extraData;
    }
    public void setExtraData(Object extraData) {
        this.extraData = extraData;
    }

    @Override
    public String toString() {
        return String.format("%s :%s:%s", getClass().getName(), responseCode.getCode(), errorMessage == null ? ""
                : errorMessage);
    }
}
