package com.mone.server.casemanagerframework.common.exception;

import com.mone.server.casemanagerframework.common.reselt.ResultCode;

/**
 * @Description
 * @Classname ParamErrorException
 * @auther taomo
 * @create 2020/7/11 11:46 上午
 */

public class ParamErrorException extends BaseGlobalException{

    public ParamErrorException() {
    }

    public ParamErrorException(String message) {
        super(message);
    }

    public ParamErrorException(Integer code, String message) {
        super(code, message);
    }

    public ParamErrorException(ResultCode resultCode) {
        super(resultCode);
    }
}
