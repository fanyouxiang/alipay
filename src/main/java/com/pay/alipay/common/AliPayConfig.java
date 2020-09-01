package com.pay.alipay.common;

/**
 * @author fanyouxiang
 * @version 1.0.0
 * @name AliPayConfig
 * @date 2020/6/29 13:47
 * @describe
 */
public class AliPayConfig {

    // [沙箱环境]应用ID,您的APPID，收款账号既是你的APPID对应支付宝账号
    public static String app_id = "2016102500756468";

    // [沙箱环境]商户私钥，你的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCNjEWCI77Y5PlTdll8+x13bE9d5UYTiip/UiunrTlFFreJuSkX6xetIU7IO+6QO/n3/RCE+Ir4QiEmISOloesNh+b7giM04VaecCeOO0l4JnhDE0d0g1GQcySWXbPNJ3WFE/Tq+l47TDzXxPtz6dSmz4my/eqjMFw1CxbGM0jInDePCtm4Y3YcjFYz5tiZx9HQef4DGRYkxuKQB/K+RMxCBmNZiUT1fJSJ+EV5La9TBKhcWBn6WM1bBBxnFInDyTmh+rNRx8lqZV0uNCQv/hJabovyuEq57K6cUwoF/8RDTTFMpPqLL461HosJWKMD1YP2IUbRWqavTWA8MWep0QcvAgMBAAECggEAM866hiZ1LMep5f10RYVXxKUU64YGPxKb+Vvm9Ik3Y+0rojHuM33tfYWqYylkaNA67qRmTnT10GXL4jvQ40e/U4WBal64ahtr67ObFrjmbB6Qd+Rvi9qgmOE76/lB3P3rSpkCVJrssIF353WGn2dfWOqvOJ8tKSuDJDr5y/NrWVkgXmJk+sx2b1oNNDBVGnTwNLaZ2XvHZQg+xYNaSZzcOypxi+6QTG4seKoIcay2NjwiP0urb0LnMYiWC+W9s+XUilrSRTwb2uUIAJXiu8MNQAVI77g2XCPPyFvqDyD06NmFJ7b3EMxPJamM83fybvHVFktfYPFIhSI0dx6qDv+v6QKBgQDMU0jCEzO6ik0loVZrrcz4dpLo2Uf8wT+Caeu7cZaWxpS4FrN15Ia+88GC331xO3Myddqz9Q1wVLacpwVxYqGWpCrRGQtTQ+F7xE25GTM/3pwdGy2W04uc5To6VvZufvOKLSjapp83upICTqnSQU2tyrpjIxHw0kzql10bXd6NzQKBgQCxWJDNmQab+N4ukv76bhZVjNglWkCYdPtrUJiNWhKmI+l920IGZygXiJcpyOFeeQvxbenVXffYvCclkBloub26tCLjJkeLPToy9IwKZoHP1g1FSIz/GB8iuawWKgPRJH5jKIioCHj9MRPlmcUnaR/rK+uCOjFX7j2gq/UEkhxM6wKBgQCDiUIXnmD4v7v2c6y82UBQ25SrzeUn9Ag8no+hNfipy+FFuWeCh8GvACEdbV7GHG2GmJRYsXMbU43TvzojykkYP0tJHQRLcDGiibc3Z9+0SEzb9/kbVchVEsSvdfhjHdsOow/f4tAxAiyoy5dLwbqOHSpsU9Fi5R+bDiJkUcPKKQKBgBrHbNYezUiwA5y0xZu7E9RHODwrrKVYxL4npWFywG4l7hP7D7U3zm3/ShQdKSrCzHLgTfbSAaLQhni9kZims2eF297A4Py9ehRHqP3JDMD9aXOUyPWcBtePgdS282yZPhxq+nelD9/rkT2SQpr43MD+GMnJT7ofV17zmEPgbDWRAoGAalkh+1WiFBv1y2NvLV+EGW9TBLvhVHh0b0R34A3AlpFmwmwrriiPLDPFriWB4IEW398wYKvZOhPROi8TwWb7CxdHCGKLHh9VMmp1KKNfMXe4bWOUK/yaVk+UYy8gbLxALBJQPER5uYHHY/qQDiz3QbhFO/7/Q2G5BYWOLMTDgzQ=";

    // [沙箱环境]支付宝公钥
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApI3HN/uKLHwoAQYjSG6wgfo22QxtJ2i++n34ZX7nhlOu98lBjgr6nFs18wwjIy6nwMdQ1om4UJuhIk7ESnJGvT+Gv9YNkcAtU7dmhuGAcaV1t9SU4IFLDRo6OYmtReW3gNJUnPG8jevOWtc4+3FlGuser0XXm/rTOuog3K4SYUwDsuQDr9xa9GD8IfkPbQfxTlld6RWXmUJczAdZIkC67VZy2rysKMjvSyjs8idALs7DErkm//rO5KVLx6nYF1M0glRTk7JnHAUSTKrreTLKKGt498mDbH2kJh9QqQSnTgikSi+bjf+57C3ZPX7yUjW7mD7z0HMAMQ9qkhgRxnZKvQIDAQAB";

    // [沙箱环境]服务器异步通知页面路径
    public static String notify_url="http://ngrok.sscai.club/alipay/aliPayNotify_url";

    // [沙箱环境]页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String return_url ="《支付成功跳转页面》";
    public static String return_url ="http://123.56.71.178:20202/test";
    // [沙箱环境]
    public static String gatewayUrl ="https://openapi.alipaydev.com/gateway.do";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";
}
