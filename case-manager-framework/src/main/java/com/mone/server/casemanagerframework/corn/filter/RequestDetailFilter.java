package com.mone.server.casemanagerframework.corn.filter;


import com.mone.server.casemanagerframework.corn.bean.RequestDetail;
import com.mone.server.casemanagerframework.corn.util.IpUtil;
import com.mone.server.casemanagerframework.corn.util.RequestDetailThreadLocal;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description 请求详细信息拦截器
 * @Classname RequestDetailFilter
 * @auther motao
 * @create 2020-07-06 10:50
 */

@Slf4j
public class RequestDetailFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("RequestDetailFilter FilterConfig: " + filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 设置请求详细信息
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 请求IP
        String ip = IpUtil.getRequestIp(request);
        // 请求路径
        String path = request.getRequestURI();
        RequestDetail requestDetail = new RequestDetail()
                .setIp(ip)
                .setPath(path);
        // 设置请求详情信息
        RequestDetailThreadLocal.setRequestDetail(requestDetail);
        filterChain.doFilter(servletRequest, servletResponse);
        // 释放
        RequestDetailThreadLocal.remove();
    }

    @Override
    public void destroy() {
        log.info("RequestDetailFilter destroy");
    }
}
