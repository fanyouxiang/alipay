package com.pay.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.pay.alipay.common.AliPayConfig;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * @author fanyouxiang
 * @version 1.0.0
 * @name AppPayTest
 * @date 2020/6/29 14:28
 * @describe
 */
public class AppPayTest {

    @Test
    public void pay() throws AlipayApiException{
        //正式环境支付宝网关，如果是沙箱环境需更改成https://openapi.alipaydev.com/gateway.do  https://openapi.alipay.com/gateway.do
        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl,
                AliPayConfig.app_id,
                AliPayConfig.merchant_private_key,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipay_public_key,
                AliPayConfig.sign_type);//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay

        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("我是生成二维码测试数据");
        model.setSubject("App支付测试Java");
        //请保证OutTradeNo值每次保证唯一
        model.setOutTradeNo(getRandomFileName());
        model.setTimeoutExpress("30m");
        model.setTotalAmount("0.01");
        model.setProductCode("QUICK_MSECURITY_PAY");
        ExtendParams extendParams = new ExtendParams();
        extendParams.setSysServiceProviderId("2088831965271840");
        model.setExtendParams(extendParams);
        request.setBizModel(model);
        //这里和普通的接口调用不同，使用的是sdkExecute
        System.out.println("request:"+ JSON.toJSONString(request));
        AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
        System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
        int width=500;//定义二维码的长宽
        int height=500;
        String formt="png";//图片格式
        //获得app支付生成的签名参数并赋值用于生成二维码
        String content=response.getBody();
        //定义二维码的参数
        HashMap<EncodeHintType,Object> hints=new HashMap<EncodeHintType,Object>();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");//二维码的编码格式
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//二维码的纠错等级,纠错等级越高,则存储的信息越少,一般是指定M级
        hints.put(EncodeHintType.MARGIN,2);//设置二维码周围的空白内容
        //生成二维码
        try {
            BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
            Path file=new File("C:\\Users\\HP\\Desktop\\apppayqrcode.png").toPath();//将指定的二维码图片生成在指定的路径
            MatrixToImageWriter.writeToPath(bitMatrix,formt,file);
            System.out.println("生成成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
