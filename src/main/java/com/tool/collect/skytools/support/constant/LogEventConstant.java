package com.tool.collect.skytools.support.constant;

/**
 * Created by yanhb on 2018/11/24.
 * 打点事件
 */
public class LogEventConstant {
    protected static final String UNDERLINE = "_";
    protected static final String COLON = ":";

    /**
     * 获取用户header缓存Key
     * @param userId
     * @return
     */
    public static String headerCacheKey(Long userId){
        StringBuilder sb = new StringBuilder(CacheConstant.NS_APP_USER_HEADER)
                .append(COLON)
                .append(UNDERLINE)
                .append(userId);
        return sb.toString();
    }
    /**
     * 事件类型
     */
    public enum EventType {
        APP("1-1-1"),             //客户端自己操作没有交互的事件的数据
        SERVER("1-2-1");          //客户端与服务端有数据交互的事件的数据

        private String value;

        EventType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    /**
     *  上报到数据平台事件
     */
    public enum Event {
        EVENT_GAME_MATCHING,        //游戏匹配成功
        EVENT_USING_PROPS,          //游戏使用道具
        EVENT_GAME_FINISH,          //游戏完成
        EVENT_GIFT_GIVING,          //给好友送礼
        EVENT_FEED_LAUD,            //点击动态比心
        EVENT_FEED,                 //发布动态
        EVENT_FEED_PIC,             //发布动态-图片
        EVENT_FEED_AUDIO,           //发布动态-录音
        EVENT_FEED_VIDEO,           //发布动态-视频
        EVENT_FEED_CONTENT,         //发布动态-纯文字
        EVENT_RECHARGE_DIAMOND,     //充值星钻
        EVENT_RECHARGE_ASSOCIATOR,  //充值会员
        EVENT_BUY_GOODS,            //购买商品
        EVENT_USER_LOGIN,           //用户登录
        EVENT_USER_REGISTER,        //用户注册
        EVENT_USER_ACTIVE,          //活跃值
        EVENT_USER_POPULARITY,      //人气值
        EVENT_USER_HEROISM,         //豪气值
        EVENT_USER_INTIMACY,        //亲密度
        EVENT_USER_FOLLOW,          //关注
        EVENT_USER_SHIELDING,       //屏蔽
        EVENT_USER_SIGNIN,          //签到
        EVENT_USER_SIGNIN_REWARD,   //签到领取奖励
        EVENT_USER_GAME_DAN         //用户游戏段位变化事件
    }

    /**
     * 事件编号
     */
    public enum EventId {
        EVENT_GAME_MATCHING("1-2-1-1"),             //游戏匹配成功
        EVENT_USING_PROPS("1-2-1-2"),               //游戏使用道具
        EVENT_GAME_FINISH("1-2-1-3"),               //游戏完成
        EVENT_GIFT_GIVING("1-2-1-4"),               //给好友送礼
        EVENT_FEED_LAUD("1-2-1-5"),                 //点击动态比心
        EVENT_FEED(" "),                            //发布动态
        EVENT_FEED_PIC("1-2-6"),                    //发布动态-图片
        EVENT_FEED_AUDIO("1-2-7"),                  //发布动态-录音
        EVENT_FEED_VIDEO("1-2-8"),                  //发布动态-视频
        EVENT_FEED_CONTENT("1-2-12"),               //发布动态-纯文字
        EVENT_RECHARGE_DIAMOND("1-2-1-6"),          //充值星钻
        EVENT_RECHARGE_ASSOCIATOR("1-2-1-7"),       //充值会员
        EVENT_BUY_GOODS("1-2-1-8"),                 //购买商品
        EVENT_USER_LOGIN("1-2-1-9"),                //用户登录
        EVENT_USER_REGISTER("1-2-1-10"),            //用户注册
        EVENT_USER_ACTIVE("1-2-1-11"),              //活跃值
        EVENT_USER_POPULARITY("1-2-1-12"),          //人气值
        EVENT_USER_HEROISM("1-2-1-13"),             //豪气值
        EVENT_USER_INTIMACY("1-2-1-14"),            //亲密度
        EVENT_USER_FOLLOW("1-2-1-15"),              //关注
        EVENT_USER_SHIELDING("1-2-1-16"),           //屏蔽
        EVENT_USER_SIGNIN("1-2-1-17"),              //签到
        EVENT_USER_SIGNIN_REWARD("1-2-1-18"),       //签到领取奖励
        EVENT_USER_GAME_DAN("1-2-1-19");            //用户游戏段位变化事件

        private String value;

        EventId(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 事件页面
     */
    public enum EventPage {
        EVENT_GAME_MATCHING("游戏页"),           //游戏匹配成功
        EVENT_USING_PROPS("游戏页"),             //游戏使用道具
        EVENT_GAME_FINISH("游戏页"),             //游戏完成
        EVENT_GIFT_GIVING("聊天页"),             //给好友送礼
        EVENT_FEED_LAUD("广场页"),               //点击动态比心
        EVENT_FEED("发布动态页"),                //发布动态
        EVENT_FEED_PIC("发布动态页"),            //发布动态-图片
        EVENT_FEED_AUDIO("发布动态页"),          //发布动态-录音
        EVENT_FEED_VIDEO("发布动态页"),          //发布动态-视频
        EVENT_FEED_CONTENT("发布动态页"),        //发布动态-纯文字
        EVENT_RECHARGE_DIAMOND("充值页"),        //充值星钻
        EVENT_RECHARGE_ASSOCIATOR("充值页"),     //充值会员
        EVENT_BUY_GOODS("充值页"),               //购买商品
        EVENT_USER_LOGIN("登录-注册页"),         //用户登录
        EVENT_USER_REGISTER("登录-注册页"),      //用户注册
        EVENT_USER_ACTIVE("个人详情页"),         //活跃值
        EVENT_USER_POPULARITY("个人详情页"),     //人气值
        EVENT_USER_HEROISM("个人详情页"),        //豪气值
        EVENT_USER_INTIMACY("个人详情页"),       //亲密度
        EVENT_USER_FOLLOW("他人主页"),           //关注
        EVENT_USER_SHIELDING("他人主页"),        //屏蔽
        EVENT_USER_SIGNIN("签到"),               //签到
        EVENT_USER_SIGNIN_REWARD("奖励"),        //签到领取奖励
        EVENT_USER_GAME_DAN("奖励");            //用户游戏段位变化事件

        private String value;

        EventPage(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static String makeEventType(LogEventConstant.Event event){
        String eventType = null;
//        switch (event){
//            case EVENT_GAME_MATCHING:        //游戏匹配成功
//            case EVENT_USING_PROPS:          //游戏使用道具
//            case EVENT_GAME_FINISH:          //游戏完成
//            case EVENT_GIFT_GIVING:          //给好友送礼
//            case EVENT_FEED_LAUD:            //点击动态比心
//            case EVENT_FEED:                 //发布动态
//            case EVENT_FEED_PIC:             //发布动态-图片
//            case EVENT_FEED_AUDIO:           //发布动态-录音
//            case EVENT_FEED_VIDEO:           //发布动态-视频
//            case EVENT_FEED_CONTENT:         //发布动态-纯文本
//            case EVENT_RECHARGE_DIAMOND:     //充值星钻
//            case EVENT_RECHARGE_ASSOCIATOR:  //充值会员
//            case EVENT_BUY_GOODS:        //星钻消费道具
//                eventType = EventType.SERVER.getValue();
//                break;
//            case EVENT_USER_ACTIVE:          //活跃值
//            case EVENT_USER_POPULARITY:      //人气值
//            case EVENT_USER_HEROISM:         //豪气值
//            case EVENT_USER_INTIMACY:        //亲密度
//                eventType = EventType.SERVER_DATA.getValue();
//                break;
//        }
        return EventType.SERVER.getValue();
    }
}
