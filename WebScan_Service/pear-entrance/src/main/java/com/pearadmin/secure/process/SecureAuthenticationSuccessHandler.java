package com.pearadmin.secure.process;

import com.alibaba.fastjson.JSON;
import com.pearadmin.common.tools.SecurityUtil;
import com.pearadmin.common.tools.SequenceUtil;
import com.pearadmin.common.tools.ServletUtil;
import com.pearadmin.common.web.domain.response.Result;
import com.pearadmin.system.domain.SysUser;
import com.pearadmin.system.service.ISysUserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Describe: 自定义 Security 用户未登陆处理类
 *
 */
@Component
public class SecureAuthenticationSuccessHandler implements AuthenticationSuccessHandler {



    @Resource
    private ISysUserService sysUserService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(((SysUser) SecurityUtil.currentUser()).getUserId());
        sysUser.setLastTime(LocalDateTime.now());
        sysUserService.update(sysUser);

        SysUser currentUser = (SysUser) authentication.getPrincipal();
        currentUser.setLastTime(LocalDateTime.now());
        request.getSession().setAttribute("currentUser", authentication.getPrincipal());
        Result result = Result.success("登录成功");
        ServletUtil.write(JSON.toJSONString(result));
    }
}
