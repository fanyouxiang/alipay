package com.pay.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeCloseModel;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.pay.alipay.common.AliPayConfig;
import org.junit.jupiter.api.Test;

/**
 * @author fanyouxiang
 * @version 1.0.0
 * @name CloseTest
 * @date 2020/6/29 15:43
 * @describe
 */
public class CloseTest {

    @Test
    public void close() throws AlipayApiException {
        //正式环境支付宝网关，如果是沙箱环境需更改成https://openapi.alipaydev.com/gateway.do  https://openapi.alipay.com/gateway.do
        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl,
                AliPayConfig.app_id,
                AliPayConfig.merchant_private_key,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipay_public_key,
                AliPayConfig.sign_type);//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay

        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        AlipayTradeCloseModel model = new AlipayTradeCloseModel();
//        model.setOutTradeNo("9926520200629");
        model.setTradeNo("2020062922001485110508101033");
        request.setBizModel(model);
        System.out.println("request:"+ JSON.toJSONString(request));
        AlipayTradeCloseResponse response = alipayClient.execute(request);
        System.out.println("response:"+JSON.toJSONString(response));

    }
}
