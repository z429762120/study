package com.tool.collect.skytools.support.constant;

/**
 * 缓存常量类，命令空间常量，配置常量
 *
 * @author Gnoll
 * @create 2017-06-22 10:31
 **/
public class CacheConstant {

    public static final String NS_APP_USER = "AIMY_APP_USER";                           // 用户
    public static final String NS_APP_SMS_CODE = "AIMY_APP_SMS_CODE";                   // 短信验证码

    public static final String NS_GAME_MATCH_POOL_LOCK = "AIMY_GAME_MATCH_POOL_LOCK";   // 游戏匹配池锁

    public static final String NS_GAME_MATCH_POOL = "AIMY_GAME_MATCH_POOL";   // 游戏匹配池命名空间，用于存储游戏对应匹配池分数段key<分数，分数对应匹配用户key>

    public static final String NS_GAME_MATCH_SCORE_PERSON = "AIMY_GAME_MATCH_SCORE_PERSON"; //游戏分数对应匹配用户<匹配时间戳，对应正在匹配的用户>

    public static final String NS_GAME_MULTI_ROOM = "AIMY_GAME_MULTI_ROOM"; //多人游戏房间资源分配

    public static final String NS_GAME_MULTI_REAL_ROOM = "AIMY_GAME_MULTI_REAL_ROOM"; //多人游戏房间资源分配

    public static final String NS_GAME_SERVER_RESOURCES = "AIMY_GAME_SERVER_RESOURCES"; //游戏服务器资源

    public static final String NS_GAME_ROOM_LIFE_CYCLE = "AIMY_GAME_ROOM_LIFE_CYCLE"; //游戏房间生命周期

    public static final String NS_GAME_CHAT_PREPARE = "AIMY_GAME_CHAT_PREPARE"; //聊天页游戏准备

    public static final String NS_GAME_DAILY_SCORE = "AIMY_GAME_DAILY_SCORE"; //玩家每日累计游戏得分分数

    public static final String NS_GAME_ROOM = "AIMY_GAME_ROOM";     //游戏服务器房间

    public static final String NS_GAME_INVITE = "AIMY_GAME_INVITE";     //游戏邀请

    public static final String NS_GAME_TYPE = "AIMY_GAME_TYPE";     //游戏类型

    public static final String NS_GAME_PLAYING = "AIMY_GAME_PLAYING";     //正在游戏的人数

    public static final String NS_GAME_DAN_SCORE = "AIMY_GAME_DAN_SCORE";     //游戏段位分数

    public static final String NS_GAME_TIPS = "AIMY_GAME_TIPS";     //游戏提示

    public static final String NS_GAME_PLAYER_ESCAPE = "AIMY_GAME_PLAYER_ESCAPE";     //玩家逃跑记录

    public static final String NS_APP_LATEST_VERSION = "AIMY_APP_LATEST_VERSION";  // 最新平台版本

    public static final String NS_APP_MARKET = "AIMY_APP_MARKET";  // 平台版本应用市场

    public static final String NS_APP_FORCEUPDATE_VERSION = "AIMY_APP_FORCEUPDATE_VERSION";  // 强制更新的平台版本号

    public static final String NS_APP_SYSCONFIG = "AIMY_SYSCONFIG";             // 系统配置

    public static final String NS_APP_ZODIAC = "AIMY_APP_ZODIAC"; //星座

    public static final String NS_APP_FOLLOW_RED_DOT = "AIMY_APP_FOLLOW_RED_DOT"; //关注新好友红点

    public static final String NS_APP_FOLLOW_RED_USER = "AIMY_APP_FOLLOW_RED_USER"; //关注关系新好友

    /***************************************2018-04-03*云存储*******************************************************/
    public static final String NS_APP_QINIU_BUCKET_NAME = "AIMY_APP_QINIU_BUCKET_NAME";         // 七牛云存储空间
    public static final String NS_APP_QINIU_BUCKET_DOMAIN = "AIMY_APP_QINIU_BUCKET_DOMAINE";     // 七牛云存储空间路径
    public static final String NS_APP_QINIU_UPTOKEN = "AIMY_APP_QINIU_UPTOKEN";     // 七牛云存储空间上传临时token
    public static final String NS_APP_WATER_MARK = "AIMY_APP_WATER_MARK";     // 咪哒水印图片缓存

    public static final String NS_APP_ALI_UPTOKEN = "AIMY_APP_ALI_UPTOKEN";         // 阿里云存储临时凭证
    public static final String NS_APP_BASE_UPTOKEN = "AIMY_APP_BASE_UPTOKEN";         // 云存储临时凭证基本信息缓存

    /***************************************2018-04-20*微信*******************************************************/
    public static final String NS_APP_WECHAT = "AIMY_APP_WECHAT";     // 微信全局access_token

    public static final String NS_APP_IP = "AIMY_APP_IP_DETAIL";     // IP地址详情

    public static final String NS_APP_KEFU_AOTU_REPLY = "AIMY_APP_KEFU_AOTU_REPLY";     // 客服自动回复

    /****************************************社交相关reids缓存*************************************************/
    public static final String NS_APP_SOCIAL_LAUDS_LOCK = "AIMY_APP_SOCIAL_LAUDS_LOCK";             //比心、取消比心 缓存锁
    public static final String NS_APP_SOCIAL_RECOMMEND_TOPIC = "AIMY_APP_SOCIAL_RECOMMEND_TOPIC";       //推荐话题
    public static final String NS_APP_SOCIAL_TOPIC_DETAILS = "AIMY_APP_SOCIAL_TOPIC_DETAILS";       //话题详情
    public static final String NS_APP_SOCIAL_COMMENT_NUM = "AIMY_APP_SOCIAL_COMMENT_NUM";               //评论数量缓存
    public static final String NS_APP_SOCIAL_LAUDS = "AIMY_APP_SOCIAL_LAUD";                            //比心关系缓存
    public static final String NS_APP_SOCIAL_FEED_DETAILS = "AIMY_APP_SOCIAL_FEED_DETAILS";             //动态详情缓存
    public static final String NS_APP_SOCIAL_FEED_RECOMMEND_CF = "AIMY_APP_SOCIAL_RECOMMEND_CF";             //动态推荐列表CF
    public static final String NS_APP_SOCIAL_FEED_RECOMMEND_CMS = "AIMY_APP_SOCIAL_RECOMMEND_CMS";             //动态推荐列表运营后台

    public static final String NS_APP_SOCIAL_USER_LIKE_SETTING = "AIMY_APP_SOCIAL_USER_LIKE_SETTING";   //用户偏好设置

    public static final String NS_APP_RECOMMEND_BIO = "AIMY_APP_RECOMMEND_BIO";             //用户推荐签名

    public static final String NS_APP_DEMAND = "AIMY_APP_DEMAND"; //约玩相关缓存

    public static final String NS_APP_USER_INTIMACY = "AIMY_APP_USER_INTIMACY";  //用户亲密度缓存

    public static final String NS_APP_USER_INTIMACY_SUBSECTION ="AIMY_APP_USER_INTIMACY_SUBSECTION"; //亲密度段位缓存
    public static final String NS_APP_USER_HEADER = "AIMY_APP_USER_HEADER";  //用户请求头信息缓存

    public static final String NS_APP_USER_MEMBER = "AIMY_APP_USER_MEMBER";  //会员缓存

    public static final String NS_APP_USER_ASSET = "AIMY_APP_USER_ASSET";  //用户资产
    public static final String NS_APP_USER_DIAMOND_ASSET = "AIMY_APP_USER_DIAMOND_ASSET";  //用户星钻资产

    public static final String NS_APP_USER_GOODS_INVENTORY = "AIMY_APP_USER_GOODS_INVENTORY";  //用户物品库存
    public static final String NS_APP_USER_BUFF_INVENTORY = "AIMY_APP_USER_BUFF_INVENTORY";  //用户buff库存

    public static final String NS_APP_MISSION_CONFIG = "AIMY_APP_MISSION_CONFIG";  //任务配置缓存
    public static final String NS_APP_INVENTORY_CHANGE_EVENT = "AIMY_APP_INVENTORY_CHANGE_EVENT";  //库存变更事件

    public static final String NS_APP_USER_DECORATION_SETTING = "AIMY_APP_USER_DECORATION_SETTING";  //用户装扮设置

    public static final String NS_APP_USER_SCORE = "AIMY_APP_USER_SCORE";  //用户分值（活跃值、人气值、豪气值）缓存
    public static final String NS_APP_LABEL = "AIMY_APP_LABEL";  //称号标签缓存

    /****************************************支付订单缓存*************************************************/
    public static final String NS_APP_PAY_ORDER_LOCK = "AIMY_PAY_ORDER_LOCK";   // 订单锁
    public static final String NS_APP_DIAMOND_ORDER_LOCK = "AIMY_DIAMOND_ORDER_LOCK";   // 星钻订单锁

    public static final String NS_APP_SIGN_IN = "AIMY_APP_SIGN_IN";   //签到缓存

    public static final String NS_APP_CLEAR_LOCATION = "AIMY_APP_CLEAR_LOCATION";  //清除位置的缓存





}
