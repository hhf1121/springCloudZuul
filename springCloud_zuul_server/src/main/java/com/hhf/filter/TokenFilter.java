package com.hhf.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 网关过滤器
 * 继承zuulFilter
 * @author hhf
 *
 */

@Component
public class TokenFilter extends ZuulFilter{

	
	//过滤器拦截业务逻辑代码
	@Override
	public Object run() throws ZuulException {
		//拦截所有请求、判断参数是否有token信息
		//1.获取上下文：
		RequestContext currentContext = RequestContext.getCurrentContext();
		//2.获取request
		HttpServletRequest request = currentContext.getRequest();
		//3.获取token信息，一般从请求头中获取(此处没有在请求头中获取)
		String token = request.getParameter("token");
		if(StringUtils.isEmpty(token)){
			currentContext.setSendZuulResponse(false);
			currentContext.setResponseBody("token is null");
			currentContext.setResponseStatusCode(401);
			return null;
		}
		return null;
	}

	//判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效。
	//如果return false，则不拦截
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	//过滤器执行的顺序：多个过滤器执行顺序
	@Override
	public int filterOrder() {
		return 0;
	}

	
	//过滤器类型:pre 请求之前执行
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
