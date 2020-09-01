package com.pay.alipay.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lzp
 * @date 2020/7/9 9:18
 * @name ResultInformController
 * @describe 微信支付结果通知地址
 */
@Slf4j
@RestController
public class WeChatResultInformController {

    @RequestMapping(value = "/resultInform", method = RequestMethod.POST)
    public String resultInform(HttpServletResponse response, HttpServletRequest request) throws IOException {
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        log.info("pay-------------------->微信支付通知----start----");
        // 获取微信调用我们notify_url的返回信息
        String result = new String(outSteam.toByteArray(), "utf-8");
        log.info("-------------------->微信支付通知\n[{}]", result);
        return "成功";
    }
}
