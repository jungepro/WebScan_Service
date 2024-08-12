package com.pearadmin.common.exception.auth;

import org.springframework.security.core.AuthenticationException;

/**
 * Describe: 验 证 码 异 常 类
 */
public class CaptchaException extends AuthenticationException {

    /**
     * 验 证 码 异 常
     */
    public CaptchaException(String message) {
        super(message);
    }

}
