package com.pearadmin.common.web.session;


/**
 */
public class HttpSessionContextHolder {

    public static HttpSessionContext currentSessionContext() {
        return HttpSessionContext.getInstance();
    }

}
