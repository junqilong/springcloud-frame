package com.tcl.mibc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求访问路由过滤器
 * @author linglong.he
 * @date 2019-06-17 13:34
 **/
@Component
public class AccessFilter extends ZuulFilter{

    private final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 路由器的类型：
     * pre：在请求路由之前被调用
     * route：将请求路由到微服务
     * post：在路由到微服务以后执行
     * error：发生错误执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }


    /**
     * 是否要执行过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("AccessFilter info {},{}",request.getMethod(),request.getRequestURI().toString());

        //这里可以进行身份验证，记录调用信息等
        //if(){}

        //不进行路由
        //ctx.setSendZuulResponse(false);
//        ctx.setResponseStatusCode(400);
//        ctx.setResponseBody("");
//        ctx.set("");
        return null;
    }
}
