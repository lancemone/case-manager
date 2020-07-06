package com.mone.server.casemanagerframework.common.exception;

import com.mone.server.casemanagerframework.common.reselt.ResultCode;

/**
 * @Description 业务异常
 * @Classname BusinessException
 * @auther motao
 * @create 2020-07-06 14:32
 */
public class BusinessException extends BaseGlobalException{

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer errorCode, String message) {
        super(errorCode, message);
    }

    public BusinessException(ResultCode resultCode) {
        super(resultCode);
    }
}
