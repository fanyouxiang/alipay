package com.pay.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeBatchRefundQueryModel;
import com.alipay.api.domain.AlipayTradeFastpayRefundQueryModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.pay.alipay.common.AliPayConfig;
import org.junit.jupiter.api.Test;

/**
 * @author fanyouxiang
 * @version 1.0.0
 * @name QueryRefundTest
 * @date 2020/6/29 15:29
 * @describe
 */
public class QueryRefundTest {

    @Test
    public void QueryRefund() throws AlipayApiException {
        //正式环境支付宝网关，如果是沙箱环境需更改成https://openapi.alipaydev.com/gateway.do  https://openapi.alipay.com/gateway.do
        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl,
                AliPayConfig.app_id,
                AliPayConfig.merchant_private_key,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipay_public_key,
                AliPayConfig.sign_type);//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay

        AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
        AlipayTradeFastpayRefundQueryModel model = new AlipayTradeFastpayRefundQueryModel();
        model.setOutTradeNo("6739920200629");//支付流水号
        model.setOutRequestNo("9872720200629");//退款请求流水号
        request.setBizModel(model);
        System.out.println("request:"+ JSON.toJSONString(request));
        AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);
        System.out.println("response:"+JSON.toJSONString(response));//支付宝流水号:2020062922001485110508101206
    }
}
