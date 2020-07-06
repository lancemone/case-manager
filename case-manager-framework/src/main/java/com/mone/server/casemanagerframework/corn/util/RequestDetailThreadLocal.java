package com.mone.server.casemanagerframework.corn.util;

import com.mone.server.casemanagerframework.corn.bean.RequestDetail;

/**
 * @Description 记录请求详情信息到当前线程中，可在任何地方获取
 * @Classname RequestDetailThreadLocal
 * @auther motao
 * @create 2020-07-06 10:48
 */
public class RequestDetailThreadLocal {

    private static ThreadLocal<RequestDetail> threadLocal = new ThreadLocal<>();

    /**
     * 设置请求信息到当前线程中
     *
     */
    public static void setRequestDetail(RequestDetail requestDetail) {
        threadLocal.set(requestDetail);
    }

    /**
     * 从当前线程中获取请求信息
     */
    public static RequestDetail getRequestDetail() {
        return threadLocal.get();
    }

    /**
     * 销毁
     */
    public static void remove() {
        threadLocal.remove();
    }
}
