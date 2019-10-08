package com.tool.collect.skytools.support.constant;

/**
 * @author yangran
 * @create 2018/5/12
 */
public class RongCloudConstants {
    public static final String AppKey = "App-Key";
    public static final String Nonce = "Nonce";
    public static final String Timestamp = "Timestamp";
    public static final String Signature = "Signature";

    /**
     * 用户自定义消息类型
     */
    public enum ObjectNameType {
        MSG_TYPE_RY_TXT("RC:TxtMsg"),                       //融云自带文本消息
        MSG_TYPE_RY_VC("RC:VcMsg"),                         //融云自带语音消息
        MSG_TYPE_RY_IMG("RC:ImgMsg"),                       //融云自带图片消息
        MSG_TYPE_GAME("MD:GameMessage"),                    //自定义消息类型 游戏
        MSG_TYPE_MATCH_GAME("MD:MatchGameMessage"),         //自定义消息类型 游戏匹配
        MSG_TYPE_SYS("MD:ChatSysMessage"),                  //自定义消息类型 系统消息
        MSG_TYPE_USER("MD:ChatUserMessage"),                //自定义消息类型 用户消息
        MSG_TYPE_PROMPT("MD:ChatPromptMessage"),            //自定义消息类型 提示消息
        MSG_TYPE_RESOLVE_USERINFO("MD:ChatUserInfoMessage"),//自定义消息类型 解析为用户信息卡片
        //MSG_TYPE_RESOLVE_MATCH("MD:ChatMatchMessage"),      //自定义消息类型 解析为游戏匹配卡片
        MSG_TYPE_SOUL_MATCH("MD:SoulMatchMessage"),      //自定义消息类型 心电匹配消息
        MSG_TYPE_ADD_INTIMACY("MD:AddIntimacyMessage"),  //自定义消息 增加亲密度消息
        MSG_TYPE_GIFT("MD:ChatGiftMessage"),                //自定义消息类型 礼物
        MSG_TYPE_FOLLOW_RED_DOT("MD:FollowRedDotMessage"),         //自定义消息类型 关注红点变更消息
        MSG_TYPE_NEW_GAME_SEASON("MD:NewGameSeasonNotify"),         //自定义消息类型 新赛季通知
        MSG_TYPE_PURCHASE_SUCCESS("MD:PurchaseSuccess"),         //自定义消息类型 支付成功

        MSG_TYPE_GAME_STATUS_TEMP("MD:ChatGameStatusMessageTemp");//自定义消息 聊天页游戏邀请状态变更 (临时,可能会更换为其他mq控件)

        private String val;

        ObjectNameType(String val){ this.val = val; }

        public String getVal(){ return val; }
    }

    /**
     * 消息通知类型
     */
    public enum MsgNoticeType {
        gift(1),        //礼物
        praise(2),      //点赞
        comment(3),     //评论
        at(4);          //at

        private int val;

        MsgNoticeType(int val) { this.val = val;}

        public int getVal() { return  val;}
    }

    /**
     *  会话类型
     */
    public enum ChannelType {
        PERSON("PERSON"),//二人会话
        PERSONS("PERSONS"),//讨论组会话
        GROUP("GROUP"),//群组会话
        TEMPGROUP("TEMPGROUP"),//聊天室会话
        CUSTOMERSERVICE("CUSTOMERSERVICE"),//客服会话
        NOTIFY("NOTIFY"),//系统通知
        MC("MC"),//应用公众服务
        MP("MP"),//公众服务
        SYSTEM("SYSTEM");//系统会话

        private String val;

        ChannelType(String val){ this.val = val; }

        public String getVal(){ return val; }
    }
}
