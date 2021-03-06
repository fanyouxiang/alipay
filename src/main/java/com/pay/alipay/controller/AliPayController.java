package com.pay.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.pay.alipay.common.AliPayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanyouxiang
 * @version 1.0.0
 * @name AliPayController
 * @date 2020/6/29 13:50
 * @describe
 */

@Controller
@RestController
@RequestMapping("/pay")
public class AliPayController {

    /**
     * 支付接口
     *
     * @param orderId 订单id
     * @param amount  支付金额
     * @param product 商品名称
     * @param body    商品描述
     * @return
     * @throws AlipayApiException
     */
    //http://localhost:8080/pay/aliPay/123456744489/10000/大象/商品大象
    @GetMapping("/aliPay/{orderId}/{amount}/{product}/{body}")
    public String aliPay(@PathVariable String orderId,
                         @PathVariable String amount,
                         @PathVariable String product,
                         @PathVariable String body) throws AlipayApiException {

//获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl,
                AliPayConfig.app_id,
                AliPayConfig.merchant_private_key,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipay_public_key,
                AliPayConfig.sign_type);
//        page
        AlipayTradePagePayRequest alipayPageRequest = new AlipayTradePagePayRequest();
        alipayPageRequest.setReturnUrl(AliPayConfig.return_url);
        alipayPageRequest.setNotifyUrl(AliPayConfig.notify_url);

        //拼接参数
        alipayPageRequest.setBizContent("{\"out_trade_no\":\"" + orderId + "\","
                + "\"total_amount\":\"" + amount + "\","
                + "\"subject\":\"" + product + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        System.out.println("form:"+alipayClient.pageExecute(alipayPageRequest).getBody());
        //请求
        return alipayClient.pageExecute(alipayPageRequest).getBody();
    }

}
