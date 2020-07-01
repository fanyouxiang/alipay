package com.pay.alipay;

import org.junit.jupiter.api.Test;

import java.net.URLDecoder;

/**
 * @author fanyouxiang
 * @version 1.0.0
 * @name UrlDecodeTest
 * @date 2020/6/29 15:01
 * @describe
 */
public class UrlDecodeTest {

    @Test
    public void decode(){
        String str = "alipay_sdk=alipay-sdk-java-4.10.29.ALL&app_id=2016102500756468&biz_content=%7B%22body%22%3A%22%E6%88%91%E6%98%AF%E7%94%9F%E6%88%90%E4%BA%8C%E7%BB%B4%E7%A0%81%E6%B5%8B%E8%AF%95%E6%95%B0%E6%8D%AE%22%2C%22out_trade_no%22%3A%226739920200629%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22App%E6%94%AF%E4%BB%98%E6%B5%8B%E8%AF%95Java%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=%E5%95%86%E6%88%B7%E5%A4%96%E7%BD%91%E5%8F%AF%E4%BB%A5%E8%AE%BF%E9%97%AE%E7%9A%84%E5%BC%82%E6%AD%A5%E5%9C%B0%E5%9D%80&sign=ghafYFo1%2BAfnnKOdDZ39lVPK1LjQ91tmJRPl4gpCtvu3PqJRM2hfbFLXdMAYKA2Q%2FOjHZiVv2Ro6bBgEfcuaFxSe3yNxOPsMPxmR%2B1mrVcuyhSwjmjlLvnRvriIP4kiZBxEOKh6xPuRHBx2SHfoi7cL5ToKeGW5RVCORgWH3tkSmI745X93Lrc2NSKaJUnCrZ2wrk6qHXOZETSrF7Xi1wFMkqFlliBUX%2FzsGLeSCpKo5pkD3%2BkxwdFCAx2aGVivQH0si1Kx8qlsoa18EdmbTgx0IWTk36Y24MUYMhy043o2dj6cCLK0z%2BtxETh%2FjqDyzF7ju0EHzLpuxpUuZl4gUpg%3D%3D&sign_type=RSA2&time";
        System.out.println(URLDecoder.decode(str));
    }
}
