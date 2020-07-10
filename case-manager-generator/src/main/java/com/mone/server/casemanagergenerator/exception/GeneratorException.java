package com.mone.server.casemanagergenerator.exception;

import com.mone.server.casemanagerframework.common.exception.BaseGlobalException;
import com.mone.server.casemanagerframework.common.reselt.ResultCode;

/**
 * @Description 代码生成异常
 * @Classname GeneratorException
 * @auther motao
 * @create 2020-06-30 17:59
 */
public class GeneratorException extends BaseGlobalException {

    private Integer errorCode;
    private String message;

    public GeneratorException() {
        super();
    }

    public GeneratorException(String message) {
        super(message);
    }

    public GeneratorException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public GeneratorException(ResultCode apiCode) {
        super(apiCode);
    }
}
