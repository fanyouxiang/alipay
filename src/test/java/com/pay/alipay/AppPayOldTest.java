package com.pay.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.pay.alipay.common.AliPayConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fanyouxiang
 * @version 1.0.0
 * @name AppPayOldTest
 * @date 2020/6/29 14:17
 * @describe
 */
public class AppPayOldTest {

    @Test
    public void pay() throws AlipayApiException, UnsupportedEncodingException {
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl,
                AliPayConfig.app_id,
                AliPayConfig.merchant_private_key,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipay_public_key,
                AliPayConfig.sign_type);

        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        /**
         * 组装报文
         */
        Map<String, Object> paramMapSend = new HashMap<String, Object>();
        paramMapSend.put("total_amount", "9");
        paramMapSend.put("product_code", "QUICK_MSECURITY_PAY");
        paramMapSend.put("body", "商品水杯");
        paramMapSend.put("subject", "商品");
        paramMapSend.put("out_trade_no", "12888885222555");
        paramMapSend.put("timeout_express","9m");//订单失效时间
//        Map<String, String> merchantMap = new HashMap<String, String>();
//        merchantMap.put("merchant_id", "2088102180986401");//受理商户编号
//        paramMapSend.put("sub_merchant", merchantMap);
        request.setBizContent(JSON.toJSONString(paramMapSend));
        System.out.println("request:"+JSON.toJSONString(request));
        AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
        if(response.isSuccess()){
            System.out.println("outTradeNo:"+response.getOutTradeNo());
            System.out.println("merchantOrderNo:"+response.getMerchantOrderNo());
            System.out.println("sellerId:"+response.getSellerId());
            System.out.println("totalAmount:"+response.getTotalAmount());
            System.out.println("tradeNo:"+response.getTradeNo());
            System.out.println("msg:"+response.getMsg());
            System.out.println("code:"+response.getCode());
            System.out.println("body:"+ response.getBody());
        } else {
            System.out.println("调用失败");
        }
        System.out.println("=======================================结束");
    }
}
