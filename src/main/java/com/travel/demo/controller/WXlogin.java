package com.travel.demo.controller;

import com.travel.demo.entity.Adjective;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;

@Controller
@Slf4j
public class WXlogin {

    public String appid="wxed6bed6e97ecb5e9";

    /**
     * 微信公众号网页授权登录
     * @param request
     * @param response
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/wxLoginss", method = RequestMethod.GET)
    public String wxLogin (HttpServletRequest request, HttpServletResponse response) throws ParseException, UnsupportedEncodingException {
        Adjective adjective = new Adjective();
        String redirect_uri = "https://localhost:8090/callBackss.do";
        String redirect_uriencode= URLEncoder.encode(redirect_uri, "UTF-8");
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" +appid
                +"&redirect_uri="+redirect_uriencode
                +"&response_type=code"
                +"&scope=snsapi_userinfo"
                +"&state=123#wechat_redirect";
        log.info("--forward重定向地址-------:" + url);
        return "redirect:"+url;
    }
}
