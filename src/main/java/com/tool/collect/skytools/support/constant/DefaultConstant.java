package com.tool.collect.skytools.support.constant;

/**
 * @author yangran
 * @create 2018/9/14
 */
public class DefaultConstant {

    /**
     * token请求头名称
     */
    public static final String OAUTH_REQ_HEADER = "Authorization";

    /**
     * token分割符
     */
    public static final String OAUTH_TOKEN_SPLIT = "bearer ";

    /**
     * jwt签名
     */
    public static final String OAUTH_SIGN_KEY = "AimyMusic";

    /**
     * 系统配置
     */
    public enum SysConfigKey {
        AliOssPicBucket("ALI_BUCKET_PIC"),                                 // 阿里oss图片存储空间
        AliOssPicBucketDomain("ALI_BUCKET_PIC_DOMAIN");                    // 阿里oss图片存储空间域名

        private String val;

        SysConfigKey(String val) { this.val = val; }

        public String getVal() { return  val; }
    }

    /**
     * 短信模板
     */
    public enum SmsTemplate {
        Login("SMS_85650045");      //登录验证码模板

        private String val;

        SmsTemplate(String val) { this.val = val; }

        public String getVal() { return  val; }
    }
}
