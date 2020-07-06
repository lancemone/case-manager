package com.mone.server.casemanagerframework.common.reselt;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description REST API 返回结果封装
 * @Classname ApiResult
 * @auther taomo
 * @create 2020/7/4 2:43 下午
 */

@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = 8004487252556526569L;

    /**
     * 响应码
     */
    private int code;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    public ApiResult() {time = new Date(); }

    public static ApiResult<Boolean> result(boolean flag) {
        if (flag){
            return ok();
        }
        return fail();
    }

    public static ApiResult<Boolean> result(ResultCode resultCode){
        return result(resultCode,null);
    }

    public static <T> ApiResult<T> result(ResultCode resultCode,T data){
        return result(resultCode,null,data);
    }

    public static <T> ApiResult<T> result(ResultCode resultCode,String message,T data){
        boolean success = false;
        if (resultCode.getCode() == ResultCode.SUCCESS.getCode()){
            success = true;
        }
        String apiMessage = resultCode.getMessage();
        if (StringUtils.isNotBlank(apiMessage)){
            message = apiMessage;
        }
        ApiResult<T> build = (ApiResult<T>) ApiResult.builder()
                .code(resultCode.getCode())
                .message(message)
                .data(data)
                .success(success)
                .time(new Date())
                .build();
        return build;
    }

    public static ApiResult<Boolean> ok(){
        return ok(null);
    }

    public static <T> ApiResult<T> ok(T data){
        return result(ResultCode.SUCCESS,data);
    }

    public static <T> ApiResult<T> ok(T data,String message){
        return result(ResultCode.SUCCESS,message,data);
    }

    public static ApiResult<Map<String,Object>> okMap(String key, Object value){
        Map<String,Object> map = new HashMap<>(1);
        map.put(key,value);
        return ok(map);
    }

    public static ApiResult<Boolean> fail(ResultCode resultCode){
        return result(resultCode,null);
    }

    public static ApiResult<String> fail(String message){
        return result(ResultCode.FAIL,message,null);

    }

    public static <T> ApiResult<T> fail(ResultCode resultCode,T data){
        if (ResultCode.SUCCESS == resultCode){
            throw new RuntimeException("失败结果状态码不能为" + ResultCode.SUCCESS.getCode());
        }
        return result(resultCode,data);

    }

    public static  ApiResult<String> fail(Integer errorCode,String message){
        return new ApiResult<String>()
                .setSuccess(false)
                .setCode(errorCode)
                .setMessage(message);
    }

    public static ApiResult<Map<String,Object>> fail(String key,Object value){
        Map<String,Object> map = new HashMap<>(1);
        map.put(key,value);
        return result(ResultCode.FAIL,map);
    }

    public static ApiResult<Boolean> fail() {
        return fail(ResultCode.FAIL);
    }
}
