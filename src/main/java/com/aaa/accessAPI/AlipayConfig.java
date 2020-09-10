package com.aaa.accessAPI;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2021000116668919";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCdi/UAOQVCV6acmmXti5OYhDrbWpW3fouhayQIe+Vaq7KjXYB/AhpCqK6Enx6SjyuGoKhESEbMbfidvjjL2d4mQ7lfCIv99tvWJeiggNf5bLDBe8Ud89gbncjTG9Dd+UdNnnMiwxqiwaWAkFpRPNJoIFFYyrHngUj8TJZ9WzmOvRgCAykAix8DFn3BjkW3uIsr3nU/T1UeVqF0oQ6yFbDtd4j7fhdSltSyLk+XWsSAmwKUOnGL2DNH1XF6wZ1P5rHbkalhVKnNYYYh5EzvywmZXKmSMx/4pEIgHbZNoFabKgCfsVW+Gq7bG19tqtU44scYRzRlI6Lrks8bkx8+PiO7AgMBAAECggEAbN8v8vR0jvEVYTlNYMfIumf+aGGD/ucDRQxOPVKpH2xxqXVO+/YPAauh1mJDdVJc6M8TGQS9cD46xX+TrkOjwduhOWwlmd5C8w0FYg1HssUKrNqEUHuXBxaVllWtlAfU32208PvU505cuaiH0YXvfSeAL5T7Nhlgv4GJqZ0l/F3VOO5IfWHaeZJX2L6selUH2ilnPZ4j6xpn3t9Gtc1mpWZhKA0kAJQHHbPnUBRh+TM/u4HOQiYuudSKLVYRt0k3VhbwXvcoXQlboGbuX0WwSAnpseE3kYMtUBA0KdvGdg1yW8hyJMIQee+n0in6j7K2KsXVPpiLD9P+qWEqAzuvqQKBgQDrHH3uOufDGfxggr/QlRHlbDb72yi5al36FCr31rEVVFBaC0+gIxQIMxBRx1KN3thoeXyJgXcCdMY8+yFqMq6irYmOKRfGlTAj6+0G/0Rrye1jUOfRnfnqIuJ1aKCMqLp5pVZeju+C4OVId9dmEGaHBIAFvJaOqKVE6QioWORFdwKBgQCri0p9vXfbhs9ptolgRBa7RzxWo5T9KGsc+jAuMjL7MLXHK9ZUg6NhzjVB5eutyPzkTq4upyVgMWwTuEqkTiAjwle53xIp2PQ8YSA7rdBM6Xmb3sxf7Ia0g9hK2S+EekpagImccqGO6LFz/0iou0gPjAxTGSP4opj8VRREQf403QKBgDFBfNiGGrvzG76UZd8q+97WtwY4ueVudVXJF99oaR0Q1uymZf4kmzPEjuyzF4aFY00v9nlQWEB5enaYHj4DdDa8qI7R6Rs/ciB0cun+XLVATq1567cso4j72fnC+6+8QaTukJOq2l7PAvoVsVi+otwygyewhNJKXqV7NMcgKGKtAoGAPkyq8/lwYwiVoSXKxGxV+RPI5QopnLsmE3MFNnHCtBkfm0LfZvgbyPRzwQf4TLf2qA+vEIBhgYrRXmQKr5sz7uiwpW9PEGWbZaY8Z5AbWyNbp/EFNj0XOs27KouvxyQGhtGxqGC1LcpyT9dBkw3ZANRy0WcK+kxK1TEs2BFDef0CgYA3mG3SC+5fP+QA1mXOKBHGZkIlzcYIZ39wUxj5eYSc4W8QTCa/K/hQIUwdJpnFsR3CsISNto8VEw9aUhLaz1tlDu4XEbwdLeYedxaBEKYdVkJru0d46eifou72/ox+ESMHddRiMpgSz4yrbdsHMk/0pDhzXH5W63oHZ4THpMGHsg==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjyvBY8esfN3zHCuWpWzGAKJRz2yIJ5zyou4eOs8D4B1ECHwbrNPSslbBq3TjvcB9tIts88mGkMCBvW8OdRj76m7XtTvdD7Ty6GJwSP3G/0pjo9paobyOua/a4fq6MvKhdsauTbbTFzYIk2/svv/uJU70T598MBXqtg6IoH6DZb6qySMMj/4irA2mLTtd0obKc9+JAn0dR4zNTraf325wpcvKwYmDXKcd8mqYTxRKbkOjxKBcZ5sJ1o+2a0rLV0IQEkjY0wgGE9A2h8nBuByw1QVMguKfDmImyV3wPXQKdYlvpihYg6j8njUlJ+HGxy8WSshJQW7GdbZuXyBehiQCkQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8888/sweet/basic_message/listAll";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url = "http://localhost:8888/sweet/basic_message/listAll";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
