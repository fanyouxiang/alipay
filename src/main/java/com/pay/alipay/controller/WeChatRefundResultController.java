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
 * @Author huo
 * @Description 退款通知
 * @Date 14:23 2020/7/13
 **/
@Slf4j
@RestController
public class WeChatRefundResultController {

    /**
     * @param request
     * @param response
     * @return void
     * @Author huo
     * @Description 退款结果通知
     * @Date 16:57 2020/7/13
     **/
    @RequestMapping(value = "/refundResultNotice", method = RequestMethod.POST)
    public String refundResultNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        log.info("refund-------------------->微信退款通知----start----");
        // 获取微信调用我们notify_url的返回信息
        String result = new String(outSteam.toByteArray(), "utf-8");
        log.info("-------------------->微信退款通知\n[{}]", result);
        return "成功";
    }
}
