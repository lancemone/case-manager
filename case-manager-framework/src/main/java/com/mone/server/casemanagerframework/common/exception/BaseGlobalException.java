package com.mone.server.casemanagerframework.common.exception;

import com.mone.server.casemanagerframework.common.reselt.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 自定义异常
 * @Classname BaseGlobalException
 * @auther motao
 * @create 2020-07-06 14:32
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseGlobalException extends RuntimeException{

    private Integer errorCode;
    private String message;

    public BaseGlobalException() {
        super();
    }

    public BaseGlobalException(String message) {
        super(message);
        this.message = message;
    }

    public BaseGlobalException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public BaseGlobalException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.errorCode = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public BaseGlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseGlobalException(Throwable cause) {
        super(cause);
    }
}
