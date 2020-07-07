package com.mone.server.casemanagerframework.common.exception;

import com.mone.server.casemanagerframework.common.reselt.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description
 * @Classname ConfigException
 * @auther motao
 * @create 2020-07-07 11:11
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class ConfigException extends BaseGlobalException{

    private static final long serialVersionUID = 8952028631871769425L;

    private Integer errorCode;
    private String message;

    public ConfigException() {
        super();
    }

    public ConfigException(String message) {
        super(message);
        this.message = message;
    }

    public ConfigException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public ConfigException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.errorCode = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public ConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigException(Throwable cause) {
        super(cause);
    }
}
