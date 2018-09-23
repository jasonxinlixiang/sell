package com.imooc.handler;

import com.imooc.config.ProjectUrl;
import com.imooc.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrl projectUrlConfig;

    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        String returnUrl = "https://open.weixin.qq.com/connect/qrconnect?appid=wx6ad144e54af67d87&redirect_uri=http%3A%2F%2Fsell.springboot.cn%2Fsell%2Fqr%2F" +
                "oTgZpwcDx4xfGs9XtQeMmN0miMbw&response_type=code&scope=snsapi_login&state=http://demosell.natapp1.cc/sell/wechat/qrUserInfo";
        return new ModelAndView("redirect:" + returnUrl);
    }
}
