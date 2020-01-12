package com.ttk.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component // 注入spring容器中
public class LoginFilter extends ZuulFilter {

	Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 返回值：
	 * pre：在请求路由之前执行
	 * route：在请求路由时调用
	 * post：请求路由之后调用， 也就是在route和errror过滤器之后调用
	 * error：处理请求发生错误时调用
	 * **/
	@Override
	public String filterType() {
		return "pre";
	}

	// 排序优先级，返回int类型，数字越小，优先级越高
	@Override
	public int filterOrder() {
		return 1;
	}

	// 是否开启过滤器，true为开启，false为不开启
	@Override
	public boolean shouldFilter() {
		return true;
	}

	// 自定义过滤逻辑
	@Override
	public Object run() throws ZuulException {
		// 获取当前请求上下文
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		String token = request.getParameter("token");
		if (token == null) {
			logger.warn("请先登录系统。。。");
			// 拒绝访问微服务
			currentContext.setSendZuulResponse(false);
			// 设置返回状态码
			currentContext.setResponseStatusCode(200);
			try {
				currentContext.getResponse().getWriter().write("token is empty...");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		logger.warn("ok");
		return null;
	}
}
