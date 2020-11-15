package com.ronnie.config.security;

import com.ronnie.util.AesUtil;
import com.ronnie.util.ErrorUtil;
import com.ronnie.util.RsaUtil;
import com.ronnie.util.SysSettingUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

/**
 * 登录失败处理
 */
@Component
@Slf4j
public class LoginFailureHandlerConfig implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        String msg = "{\"code\":\"400\",\"msg\":\"用户名或密码错误\"}";

        //转json字符串并转成Object对象，设置到Result中并赋值给返回值o
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.print(msg);
        out.flush();
        out.close();
    }
}
