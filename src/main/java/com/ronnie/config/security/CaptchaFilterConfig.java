package com.ronnie.config.security;

import com.ronnie.common.pojo.ParameterRequestWrapper;
import com.ronnie.util.AesUtil;
import com.ronnie.util.ErrorUtil;
import com.ronnie.util.RsaUtil;
import com.ronnie.util.SysSettingUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * 校验账号、密码前，先进行验证码处理，需要在这里进行登录解密操作
 */
@Component
@Slf4j
public class CaptchaFilterConfig implements Filter {

    @Value("${captcha.enable}")
    private Boolean captchaEnable;

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        /*
            注：详情可在SessionManagementFilter中进行断点调试查看
            security框架会在session的attribute存储登录信息，先从session.getAttribute(this.springSecurityContextKey)中获取登录用户信息
            ，如果没有，再从本地上下文SecurityContextHolder.getContext().getAuthentication()获取，因此想要强制用户下线得进行如下操作

            另外，虽然重启了服务，sessionRegistry.getAllSessions()为空，但之前的用户session未过期同样能访问系统，也是这个原因
         */
        SessionInformation sessionInformation = sessionRegistry.getSessionInformation(session.getId());
        if(sessionInformation == null && session.getAttribute("SPRING_SECURITY_CONTEXT") != null){
            //直接输出js脚本跳转强制用户下线
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("<script type='text/javascript'>window.location.href = '" + contextPath + "/logout'</script>");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
