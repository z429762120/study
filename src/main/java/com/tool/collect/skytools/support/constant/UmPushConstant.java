package com.tool.collect.skytools.support.constant;

/**
 * @author yangran
 * @create 2017/9/26
 */
public class UmPushConstant {
    //友盟推送消息的前缀
    public static final String REDIRECT_URL_PREFIX = "aimyunion://redirect/";
    //友盟推送重定向url参数分隔符
    public static final String PARAM_DILIMITER = "?";
    public enum PushMode {
        devMode("DEV"),   //测试模式
        prodMode("PROD");    //生产模式

        private String val;

        PushMode(String val) { this.val = val;}

        public String getVal(){ return val; }
    }

    /**
     * 推送类型
     */
    public enum PushType {
        MESSAGE("MESSAGE"),        // 消息
        NOTICE("NOTICE");          // 通知

        private String val;

        PushType(String val){ this.val = val; }

        public String getVal(){ return val; }
    }

    /**
     * 推送通知后跳转页面
     */
    public enum RedirectPage {
        ChatPage,      //聊天页
        MyMessagePage,      //我的消息页
        Popularity,     //人气值弹窗
        Wealth          //豪气值弹窗
    }

}
