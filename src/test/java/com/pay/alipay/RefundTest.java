package com.pay.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradeRefundApplyModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.pay.alipay.common.AliPayConfig;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author fanyouxiang
 * @version 1.0.0
 * @name RefundTest
 * @date 2020/6/29 15:04
 * @describe
 */
public class RefundTest {

    @Test
    public void refund() throws AlipayApiException {
        //正式环境支付宝网关，如果是沙箱环境需更改成https://openapi.alipaydev.com/gateway.do  https://openapi.alipay.com/gateway.do
        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl,
                AliPayConfig.app_id,
                AliPayConfig.merchant_private_key,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipay_public_key,
                AliPayConfig.sign_type);//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay

        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeRefundApplyModel model = new AlipayTradeRefundApplyModel();
        model.setOutTradeNo("6739920200629");
        model.setRefundAmount("0.01");
        model.setOutRequestNo(getRandomFileName());//"outRequestNo":"9872720200629"
        request.setBizModel(model);
        System.out.println("request:"+ JSON.toJSONString(request));
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        System.out.println("response:"+JSON.toJSONString(response));
    }

    /**
     * 生成随机数
     * @return
     */
    public static String getRandomFileName() {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
        return rannum + str;
    }
}
