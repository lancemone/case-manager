package com.mone.server.casemanagerstart.aop;

import com.mone.server.casemanagerframework.aop.BaseLogAop;
import com.mone.server.casemanagerframework.aop.bean.OperationLogInfo;
import com.mone.server.casemanagerframework.aop.bean.RequestInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Classname Aop
 * @auther motao
 * @create 2020-07-07 10:07
 */

@Slf4j
@Aspect
@Component
@ConditionalOnProperty(value = {"case-manager.aop.log.enable"}, matchIfMissing = true)
public class Aop extends BaseLogAop {

//    private static final String POINTCUT =
//            "execution（public * com.mone.server..*.controller..*.*(..)）";

    //创建Pointcut表示式，表示所有controller请求
    @Pointcut("execution(* com.mone.server..*.controller..*.*(..))")
    private void controllerAspect() {
    }


    /**
     * 环绕通知
     * 方法执行前打印请求参数信息
     * 方法执行后打印响应结果信息
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "controllerAspect()")
    @Override
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return super.handle(joinPoint);
    }

    /**
     * 异常通知方法
     *
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "exception")
    @Override
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        super.handleAfterThrowing(exception);
    }

    /**
     * 设置请求ID
     *
     * @param requestInfo
     */
    @Override
    protected void setRequestId(RequestInfo requestInfo) {
        super.handleRequestId(requestInfo);
    }

    /**
     * 获取请求信息对象
     *
     * @param requestInfo
     */
    @Override
    protected void getRequestInfo(RequestInfo requestInfo) {
        // 处理请求参数日志
        super.handleRequestInfo(requestInfo);
    }

    /**
     * 获取响应结果对象
     *
     * @param result
     */
    @Override
    protected void getResponseResult(Object result) {
        // 处理响应结果日志
        super.handleResponseResult(result);
    }

    /**
     * 请求响应处理完成之后的回调方法
     *
     * @param requestInfo
     * @param operationLogInfo
     * @param result
     * @param exception
     */
    @Override
    protected void finish(RequestInfo requestInfo, OperationLogInfo operationLogInfo, Object result, Exception exception) {
        // 异步保存操作日志
        super.saveSysOperationLog(requestInfo, operationLogInfo, result, exception);
        // 异步保存登录日志
        super.saveSysLoginLog(requestInfo, operationLogInfo, result, exception);
    }
}
