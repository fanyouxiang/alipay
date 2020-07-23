package com.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.pay.alipay.common.AliPayConfig;
import org.junit.Test;

/**
 * @author fanyouxiang
 * @version 1.0.0
 * @name BillQueryTest
 * @date 2020/7/23 17:11
 * @describe
 */
public class BillQueryTest {
    /**
     * 测试
     */
    @Test
    public   void   billQuery ()   throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl,
                AliPayConfig.app_id,
                AliPayConfig.merchant_private_key,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipay_public_key,
                AliPayConfig.sign_type);//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayDataDataserviceBillDownloadurlQueryRequest request =  new  AlipayDataDataserviceBillDownloadurlQueryRequest();
        request.setBizContent( "{"  +
                "\"bill_type\":\"trade\","  +
                "\"bill_date\":\"2018-04-05\""  +
                "}" );
        AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
        if (response.isSuccess()){
            System.out.println( "调用成功" );
            System.out.println( "下载地址："  + response.getBillDownloadUrl());
        }  else  {
            System.out.println( "调用失败" );
        }
    }
}
