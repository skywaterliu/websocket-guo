package com.mafei.job.web;

import com.skytech.ark.security.meta.Account;
import com.skytech.ark.security.web.AccountHelper;
import com.skytech.ark.security.web.UrlSecurity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: airsun
 * Date: 8/17/13
 * Time: 11:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestfulSecurityInterceptor implements HandlerInterceptor {

    private String[] whiteList;
    private static final String BEST_MATCH_PATTERN = "org.springframework.web.servlet.HandlerMapping.bestMatchingPattern";
    private static final String LOGIN_ACCOUNT_SESSIONKEY = "AuthenticatedAccount";

    private static final Logger logger = LoggerFactory.getLogger(RestfulSecurityInterceptor.class);

    @Resource
    private AccountHelper accountHelper;

    @Resource
    private UrlSecurity urlSecurity;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        logger.debug(httpServletRequest.getRequestURI());
        String servletPath = httpServletRequest.getServletPath().replaceFirst("/","");

        httpServletResponse.addHeader("Cache-Control", "no-cache");
        httpServletResponse.addHeader("Pragma", "no-cache");
        httpServletResponse.addDateHeader("Expires", 1L);

        for (String whitePath : whiteList) {
            if (servletPath.equals(whitePath)) {
                return true;
            }
        }
        /**
         * @todo 这个pattern的获得属于spring mvc的实现
         */
        String bestMatchPattern = httpServletRequest.getAttribute(BEST_MATCH_PATTERN).toString();
        logger.debug("[BEST MATCH] " + bestMatchPattern);

        //set current logined user account to thread
        Account account = (Account) httpServletRequest.getSession(true).getAttribute(LOGIN_ACCOUNT_SESSIONKEY);
        if (account != null) {
            accountHelper.setCurrent(account);
        }else{
            //验证用户登录
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setWhiteList(String[] whiteList) {
        this.whiteList = whiteList;
    }
}
