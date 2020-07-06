package com.mone.server.casemanagerframework.corn.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description 拦截器需要获取的请求详细信息
 * @Classname RequestDetail
 * @auther motao
 * @create 2020-07-06 10:46
 */

@Data
@Accessors(chain = true)
public class RequestDetail {

    /**
     * 请求ip地址
     */
    private String ip;

    /**
     * 请求路径
     */
    private String path;
}
