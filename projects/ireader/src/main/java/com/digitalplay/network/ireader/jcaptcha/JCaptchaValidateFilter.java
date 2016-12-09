package com.digitalplay.network.ireader.jcaptcha;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.digitalplay.network.ireader.common.exception.JCaptchaCodeNotMatchException;

/**
 * 验证码过滤器
 * <p>User: Zhang Kaitao
 * <p>Date: 13-3-22 下午4:01
 * <p>Version: 1.0
 */
public class JCaptchaValidateFilter extends AccessControlFilter {

    private boolean jcaptchaEnabled = true;

    private String jcaptchaParam = "jcaptchaCode";

    private String jcapatchaErrorUrl;

    /**
     * 是否开启jcaptcha
     *
     * @param jcaptchaEbabled
     */
    public void setJcaptchaEnabled(boolean jcaptchaEbabled) {
        this.jcaptchaEnabled = jcaptchaEbabled;
    }

    /**
     * 前台传入的验证码
     *
     * @param jcaptchaParam
     */
    public void setJcaptchaParam(String jcaptchaParam) {
        this.jcaptchaParam = jcaptchaParam;
    }

    public void setJcapatchaErrorUrl(String jcapatchaErrorUrl) {
        this.jcapatchaErrorUrl = jcapatchaErrorUrl;
    }

    public String getJcapatchaErrorUrl() {
        return jcapatchaErrorUrl;
    }

    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        request.setAttribute("jcaptchaEnabled", jcaptchaEnabled);
        return super.onPreHandle(request, response, mappedValue);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //验证码禁用 或不是表单提交 允许访问
        if (jcaptchaEnabled == false || !"post".equals(httpServletRequest.getMethod().toLowerCase())) {
            return true;
        }
        return JCaptcha.validateResponse(httpServletRequest, httpServletRequest.getParameter(jcaptchaParam));
    }


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    	request.setAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, new JCaptchaCodeNotMatchException());
//    	redirectToLogin(request, response);
        return true;
    }
    
//    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
//        WebUtils.issueRedirect(request, response, getJcapatchaErrorUrl());
//    }

}
