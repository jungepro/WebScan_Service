package com.pearadmin.common.config.proprety;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Describe: 系 统 权 限 配 置 类
 *
 */
@Data
@ConfigurationProperties("pear.security")
public class SecurityProperty {

    /**
     * 超级管理员不认证
     */
    private boolean superAuthOpen;

    /**
     * 不验证权限用户名
     */
    private String superAdmin;

    /**
     * 记住密码标识
     */
    private String rememberKey;

    /**
     * 开放接口列表
     */
    private String[] openApi;

    /**
     * 是否允许多账号在线
     */
    private Integer maximum = 1;

}
