package com.pay.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.pay.alipay.common.AliPayConfig;
import org.junit.jupiter.api.Test;

/**
 * @author fanyouxiang
 * @version 1.0.0
 * @name QueryTest
 * @date 2020/6/29 14:55
 * @describe
 */
public class QueryTest {

    @Test
    public void query() throws AlipayApiException {
        //正式环境支付宝网关，如果是沙箱环境需更改成https://openapi.alipaydev.com/gateway.do  https://openapi.alipay.com/gateway.do
        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl,
                AliPayConfig.app_id,
                AliPayConfig.merchant_private_key,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipay_public_key,
                AliPayConfig.sign_type);//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay

        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeQueryModel model = new AlipayTradeQueryModel();
        model.setOutTradeNo("9926520200629");
        request.setBizModel(model);
        System.out.println("request:"+ JSON.toJSONString(request));
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        System.out.println(JSON.toJSONString(response));//"trade_no\":\"2020062922001485110508101206\
    }
}
