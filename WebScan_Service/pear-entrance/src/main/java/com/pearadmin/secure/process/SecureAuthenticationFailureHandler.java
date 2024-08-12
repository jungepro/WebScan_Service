package com.pearadmin.secure.process;

import com.alibaba.fastjson.JSON;
import com.pearadmin.common.exception.auth.CaptchaException;
import com.pearadmin.common.tools.ServletUtil;
import com.pearadmin.common.web.domain.response.Result;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Describe: 自定义 Security 用户登录失败处理类
 */
@Component
public class SecureAuthenticationFailureHandler implements AuthenticationFailureHandler {



    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        Result result = Result.failure(500, "登录失败");

        if (e instanceof CaptchaException) {
            result.setMsg("验证码有误");
        }
        if (e instanceof UsernameNotFoundException) {
            result.setMsg("用户名不存在");
        }
        if (e instanceof LockedException) {
            result.setMsg("用户冻结");
        }
        if (e instanceof BadCredentialsException) {
            result.setMsg("账户密码不正确");
        }
        if (e instanceof DisabledException) {
            result.setMsg("用户未启用");
        }
        ServletUtil.write(JSON.toJSONString(result));
    }
}
