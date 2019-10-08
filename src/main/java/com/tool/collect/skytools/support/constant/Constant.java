package com.tool.collect.skytools.support.constant;

import java.util.Calendar;

/**
 * @author Gnoll
 * @create 2017-06-21 16:56
 **/
public class Constant {
    //小助手
    public static final Long OFFICIAL_ACCOUNT = 1L;
    //内容发布号
    public static final Long OFFICIAL_PUBLISHER = 2L;

    public static final String CHINA_CODE = "0086";

    public static final String LICENSE = "AimyMusic";

    public static final String APP_ROLE = "app";

    public static final Long GameMatchTimeOut = 30L;  //匹配超时时间，单位秒


    /*
     * 编码
     */
    public static final String UTF8 = "UTF-8";

    /**
     * JSON 资源
     */
    public static final String CONTENT_TYPE = "application/json; charset=utf-8";

    /**
     * 资源类型
     */
    public enum ResourceType {
        Directory,  // 目录
        Menu,       // 菜单
        Interface   // 接口
    }

    /**
     * 数据状态
     */
    public enum DataState {
        Invalid,    // 删除
        Disable,    // 无效
        Available   // 有效
    }

    /**
     * 是否
     */
    public enum YesNo {
        FALSE,      // 否
        TRUE        // 是
    }

    /**
     * 注册/登录方式  sms. qq wechat
     */
    public enum Platform {
        Mobile("sms"),     // 手机号
        Qq("qq"),         // qq号
        Wechat("wechat"),     // 微信号
        Weibo("weibo"),      // 微博
        Alipay("alipay");      // 支付宝

        private String val;

        Platform(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }


    }

    /**
     * 短信类型
     */
    public enum SmsType {
        Login,       // 登录
        bind             //
    }

    /**
     * 性别
     */
    public enum Gender {
        Nomal,      //未知
        Man,        //男
        Woman       //女
    }

    /**
     * 关注关系   0-关注  1-已关注 2-关注我 3-互相关注
     */
    public enum FollowRelationship {
        NotFollow,          //未关注
        Follow,             //已关注
        FollowMe,           //关注我
        MutualFollow,       //互相关注
        Friend              //扫码好友
    }

    public enum DiversType {
        Android,
        iOS
    }

    /**
     * 分享途径  0-私信 1-个人主页  2-微信 3-朋友圈 4-QQ 5-QQZone
     */
    public enum ShareWay {
        MidaFirends,            // 私信(咪哒好友)
        HomePage,               // 个人主页
        Wechart,                // 微信
        FriendsCircle,          // 朋友圈
        QQ,                     // QQ
        QQZone,                 // QQ空间
        weiBo                   // 微博
    }

    public enum PrivateMessageType {
        Official,       // 官方私信
        Gift,           // 礼物私信
        User            // 用户私信
    }

    public enum AtMessageType {
        Comment,          // 评论@
        Release,          // 发布@
        Share             // 分享@
    }

    public enum TradeType {
        Consume,    //出账
        Recharge    //入账
    }

    public enum ExpiresType {
        Days(Calendar.DATE),               // 天
        Week(Calendar.WEEK_OF_YEAR),       // 周
        Month(Calendar.MONTH),             // 月
        Year(Calendar.YEAR);               // 年
        private int type;

        ExpiresType(int type) {
            this.type = type;
        }

        public int get() {
            return type;
        }
    }



    // 退款记录状态
    public enum RefundState {
        Refunding,   // 退款中
        RefundFail,  // 退款失败
        Refunded     // 已退款
    }

    /**
     * 用户设置类型（可扩展）
     */
    public enum UserSettingType {
        PayPopUp,         // 支付弹窗
        NotFollow,       // 未关注的私信消息
        FollowAndFriend,    // 我关注与好友的消息
        ShowLocation      // 展示地理位置(APP中的清除定位就是关掉这个设置)
    }

    /**
     * 认证分类
     */
    public enum AuthenticationClass {
        USER,               // 用户
        ORGANIZATION        // 机构
    }

    /**
     * 实名认证状态
     */
    public enum AuthenticationStatus {
        UnAuthorized,       // 未认证
        InAuthentication,   // 认证中
        Authenticated,      // 已认证
    }

    /**
     * 审核状态
     */
    public enum AuditStatus {
        Pending,               // 待审核
        Passed,                // 已通过
        NotPass                // 未通过
    }

    public enum TradeStatus {
        UnFinished,            // 未完成
        Finished,              // 交易完成
        Fail,                  // 交易失败
        Refunding,             // 退款中
        Refunded,              // 退款完成
        RefundError            // 退款异常
    }

    //mq标签
    public enum MqTags {
        AimyMusicTestTag("TAG_TEST");

        private String val;

        MqTags(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    // banner
    public enum BannerType {
        User("用户"),                // 用户
        URL("链接"),                 // url
        Topic("专题");               // 专题

        private String val;

        BannerType(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    //重复请求时间间隔
    public enum DelayTime {
        Thirty(2000L),    // 2s
        Sixty(3000L),     // 3s
        Ninety(4000L);    // 4s

        private Long val;

        DelayTime(Long val) {
            this.val = val;
        }

        public Long getVal() {
            return val;
        }
    }

    public enum UserLevel {
        Ordinary,           // 普通会员
        Golden,             // 黄金会员
        Diamond,            // 钻石会员
        Extreme             // 至尊会员
    }

    public enum CommentPraiseType {
        Add,        // 点赞
        Cancel      // 取消点赞
    }

    /**
     * 系统配置key
     */
    public enum SysConfigKey {
        NearDistanceM("NEAR_DISTANCE_M"),                       //附近的人的距离(米)
        DecorationFileVersion("DECORATION_FILE_VERSION"),       //装饰文件版本
        RegionFilePath("REGION_FILE_PATH"),                     //区域文件路径
        RegionFileVersion("REGION_FILE_VERSION"),               //区域文件版本
        InviteGameExpireTime("INVITE_GAME_EXPIRE_TIME"),        //游戏邀请超时时间
        SoulMatchExpireTime("SOUL_MATCH_EXPIRE_TIME"),          //心电感应匹配超时时间
        DefaultAvatarUrl("DEFAULT_AVATAR_URL"),                 // 默认头像
        TestPhones("TEST_PHONES"),                              // 测试手机号:多个用,分隔
        QiniuFileBucket("QINIU_BUCKET_FILE"),                   // 文件存储空间
        QiniuMediaBucket("QINIU_BUCKET_MEDIA"),                 // 音视频存储空间
        QiniuPicBucket("QINIU_BUCKET_PIC"),                     // 图片存储空间
        QiniuFileBucketDomain("QINIU_BUCKET_FILE_DOMAIN"),      // 文件存储空间
        QiniuMediaBucketDomain("QINIU_BUCKET_MEDIA_DOMAIN"),    // 音视频存储空间
        QiniuPicBucketDomain("QINIU_BUCKET_PIC_DOMAIN"),        // 图片存储空间
        VersionUpdate("VERSION_NUPDATE");                       // app是否需要更新

        private String val;

        SysConfigKey(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    /**
     * 文件上传状态
     */
    public enum FileUploadState {
        IN,         // 进行中
        SUCCESS,    // 上传成功
        FAIL        // 上传失败
    }


    /**
     * 举报类型中文描述
     */
    public enum ReportTypeDesc {
        Video("MV"),                 // 举报视频
        Audio("歌曲"),                 // 举报音频
        User("用户"),                  // 举报用户
        Comment("评论"),               // 举报评论
        PrivateLetter("私信"),          // 举报私信
        Share("动态");          // 举报动态

        private String val;

        ReportTypeDesc(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    /**
     * 好友验证消息状态
     */
    public enum FriendMsgState {
        Application,    // 申请中
        Refused,        // 已拒绝
        Through,        // 已通过
        Expired         // 已过期
    }

    /**
     * 官方账号
     */
    public enum OfficialAccount {
        MidaHelper("咪哒小助手"),      // 咪哒小助手
        Mida("咪哒");                 //  咪哒
        private String val;

        OfficialAccount(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    /**
     * 封号类型
     */
    public enum BannedType {
        Other,          //其他原因
        report          //举报
    }

    /**
     * 举报原因
     */
    public enum ReportReasonType {
        FakeAd("虚假广告"),
        PornographicVulgar("色情低俗"),
        PoliticalSensitive("政治敏感"),
        LifeAttack("人身攻击"),
        Embezzle("盗用抄袭"),
        Other("其他");

        private String val;

        ReportReasonType(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    /**
     * 推送通知的来源类型，目前只有运营后台推送
     */
    public enum PushOriginType {
        Cms            //运营后台推送
    }

    /**
     * 操作类型
     */
    public enum OperationType {
        Add,        // 增
        Delete,     // 删
        Update,     // 改
        Query       // 查
    }

    /**
     * 敏感词库类型
     */
    public enum SenWordsLibType {
        All,            //全量词库
        Query           //查询词库
    }

    /**
     * 排序规则
     */
    public enum OrderRule {
        ASC,        //升序
        DESC        //降序
    }

    /**
     * 热门评论数
     */
    public enum HotCommentSize {
        Two(2),
        Three(3),
        Five(5),
        Ten(10),
        Twenty(20);
        private int val;

        HotCommentSize(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }


    public enum QiniuBucketType {
        FileBucket,             // 七牛文件存储空间
        MediaBucket,            // 七牛音视频存储空间
        PicBucket               // 七牛图片存储空间
    }

    /**
     * 文件存储空间
     */
    public enum BucketType {
        FileBucket,             // 文件存储空间
        MediaBucket,            // 音视频存储空间
        PicBucket               // 图片存储空间
    }

    public enum OssPlatform {
        Qiniu("qiniu"),          // 七牛oss
        Ali("ali");            // 阿里oss

        private String val;

        OssPlatform(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    /**
     * 日期类型枚举
     */
    public enum DateType {
        Day("%Y-%m-%d"),      //天
        Week("%Y-%u"),       //周
        Month("%Y-%m");      //月

        private String val;

        DateType(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    public enum ShareLinkType {
        Works,          // 作品
        User            // 用户
    }

    /**
     * 动态类型 0-文本 1-图片 2-音频  3-视频
     */
    public enum FeedType {
        TEXT,       //文本
        PIC,        //图片
        AUDIO,      //录音
        VIDEO       //视频
    }

    /**
     * 融云用户状态
     */
    public enum RongcloudUserStatus {
        Online(0),         //在线状态
        Offline(1),        //离线状态  已经断开与融云服务器的连接，异常断网情况下离线状态会延迟 5 分钟同步
        Logout(2);         //登出
        private Integer val;

        RongcloudUserStatus(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }
    }

    /**
     * 视频截帧参数，在视频url地址后加截帧参数可以获取指定时间的帧缩略图
     * 例如：http://devmedia.aimymusic.com/011b425985518dccc18bc5f9f9a0cd8c.mp4?vframe/jpg/offset/0
     */
    public enum VideoSnapshotParam {
        Qiniu("vframe/jpg/offset/0"),
        Ali("x-oss-process=video/snapshot,t_1,f_jpg");
        private String val;

        VideoSnapshotParam(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }

    }

    /**
     * 数量限制枚举
     */
    public enum NumberLimit {
        MallRecommendGoodsNum(10),      //商城推荐商品数量
        SingleUploadPhotosNum(9),       //单次上传相片限制
        ChartMatchOftenGameNum(3),      //聊天页心电匹配小卡片游戏限制
        GenderUpdateNum(1),             //性别修改次数限制
        PhotoNum(200),                  //相片数量限制
        UserPagePhotoNum(4);            //用户主页相片限制

        private int limit;

        NumberLimit(int limit) {
            this.limit = limit;
        }

        public int getLimit() {
            return limit;
        }
    }

    /**
     * 普通mq队列
     */
    public enum MqQueue {
        InventoryChangeQueue("inventory.change"),   //物品库存增减
        StatusNotifyQueue("ucenter.game.status"),     //通知用户游戏状态变化
        SocialGameOverQueue("social.game.over.queue"),   //社交服务监听游戏完成
        BigDataMissionQueue("big.data.mission.queue"),     //大数据平台转发任务消息
        BigDataSocialGiftGivingQueue("big.data.social.gift.giving.queue");     //大数据平台转发赠送礼物消息

        private String val;

        MqQueue(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    /**
     * 延迟队列
     */
    public enum DelayQueue {
        Delayed_Room_Sync("delayed.room.sync");     //游戏房间成员数同步

        private String val;

        DelayQueue(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    /**
     * 评论消息类型枚举
     */
    public enum CommentMsgType {
        Feed(0),
        Comment(1);
        private Integer val;

        CommentMsgType(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }
    }

    /**
     * 用户推荐签名类型
     */
    public enum RecommendBioType {
        General(0),          //通用
        Man(1),             //男
        Woman(2);          //女
        private Integer val;

        RecommendBioType(Integer val) {
            this.val = val;
        }
        public Integer getVal() {
            return val;
        }
    }

    /**
     * 游戏房间通知事件类型
     */
    public enum GameRoomEventType {
        Create(0),      //创建房间
        Notify(1),      //加入房间
        Quit(2),        //退出房间
        Destroy(3);     //销毁房间

        private int val;

        GameRoomEventType(Integer val) { this.val = val; }

        public Integer getVal() { return val;}
    }

    /**
     * 游戏状态
     */
    public enum GameState {
        Idle(0),        //空闲
        Playing(1);     //游戏中

        private int val;

        GameState(Integer val) { this.val = val; }

        public Integer getVal() { return val;}

    }

    /**
     * 游戏类型
     */
    public enum  GamePlayType {
        FIGHT(0),       //对战游戏，计算段位
        NOTFIGHT(1);    //非对战游戏

        private int val;

        GamePlayType(Integer val) { this.val = val; }

        public Integer getVal() { return val;}
    }

    /**
     * 游戏结果
     */
    public enum GameResult {
        NoSettlement(-1),   //未结算
        Lose(0),    //输
        Win(1),     //赢
        Flat(2);    //平

        private int val;

        GameResult(Integer val) { this.val = val; }

        public Integer getVal() { return val;}
    }

    /**
     * 游戏记录状态
     */
    public enum GameRecordStatus {
        Begin(1),   //开始游戏
        End(2);     //结束游戏

        private int val;

        GameRecordStatus(Integer val) { this.val = val; }

        public Integer getVal() { return val;}
    }

    /**
     * 游戏房间类型
     */
    public enum GameRoomType {
        Match(0),       //匹配类
        Invite(1);      //邀请类

        private int val;

        GameRoomType(Integer val) { this.val = val; }

        public Integer getVal() { return val;}
    }

    /**
     * 游戏分数比较类型
     */
    public enum GameCompareType {
        MIN("MIN"),     //比小
        MAX("MAX");     //比大

        private String val;

        GameCompareType(String val) { this.val = val; }

        public String getVal() { return val;}
    }

    public enum FeedbeackType{
        app; //软件反馈
    }

    public enum ReportType{
        User, //用户
        Feed,  //动态
        Comment; //评论

    }

    /**
     * 聊天页消息提示类型  0-纯文字  1-心动  2-关注
     */
    public enum MsgPromptType{
        Text(0),                        //纯文字
        Flipped(1),                     //心动
        Follow(2),                      //关注
        ReceiveGifts(3),                //收礼
        GivingGifts(4);                 //送礼

        private int val;

        MsgPromptType(Integer val) { this.val = val; }

        public Integer getVal() { return val;}
    }

    /**
     * 游戏邀请状态  0-发送邀请  1-接受邀请 2-拒绝邀请 3-邀请超时 4-邀请失效
     */
    public enum GameInviteStatus {
        SendInvitation(0),                 //发送邀请
        AcceptInvitation(1),                //接受邀请
        RejectInvitation(2),                //拒绝邀请
        TimeoutInvitation(3),               //邀请超时
        InvalidInvitation(4);               //邀请已失效

        private int val;

        GameInviteStatus(Integer val) { this.val = val; }

        public Integer getVal() { return val;}

    }

    /**
     * kafka 主题
     */
    public enum KafkaTopic {
        TEST("test"),     // 测试主题
        LEQUAN_LOG("lequanlog");     // 测试主题

        private String val;

        KafkaTopic(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }


    }

    /**
     * 商品类型
     */
    public enum SalesType{
        DiamondPack(0),
        Goods(1);

        private int val;

        SalesType(Integer val) { this.val = val; }

        public Integer getVal() { return val;}
    }

    /**
     * mq库存变更监听-库存类型
     */
    public enum InventoryType{
        Goods(0),              //物品
        Diamond(1);            //星钻

        private int val;

        InventoryType(Integer val) { this.val = val; }

        public Integer getVal() { return val;}
    }

    /**
     * mq库存变更监听-变更来源
     */
    public enum InventorySource{
        Purchase,                //rmb购买
        InApp               //app内变更

    }

    /**
     * 时长单位  0-局游戏,1-秒,2-分,3-小时,4-天,5-周,6-月,7-季,8-半年,9-年
     * 产品设定的最大单位为天  比如一年:会设置为365天  --2018-12-13
     */
    public enum DurationUnit{
        Game("局游戏"),
        Second("秒"),
        Minute("分"),
        Hour("小时"),
        Day("天"),
        Week("周"),
        Month("月"),
        Season("季"),
        HalfOfYear("半年"),
        Year("年");

        private String val;

        DurationUnit(String val) { this.val = val; }

        public String getVal() { return val;}
    }

    /**
     * 物品类型
     */
    public enum GoodsType{
        Membership(0),      //会员
        GameItem(1),        //游戏道具
        Gift(2),            //礼物
        Buff(3),            //增益状态
        SignInCard(4),      //补签卡
        SoulMatchNumber(5); //匹配次数
        private int val;

        GoodsType(Integer val) { this.val = val; }

        public Integer getVal() { return val;}
    }

    /**
     * 装饰类型 请勿更改枚举名字,app使用枚举名字标记不同的装饰类型
     */
    public enum DecoType{
        ChatBubble,         //聊天气泡
        AvatarFrame,        //头像挂件
        GameDeco,           //游戏装扮
        GameEmoticon        //游戏对战表情

        /*private int val;

        DecoType(Integer val) { this.val = val; }

        public Integer getVal() { return val;}*/

    }

    /**
     * buff类型
     */
    public enum BuffType{
        Decoration,
        Goods
    }

    /**
     * 周期
     */
    public enum Period{
        None,
        Game,
        Day
    }

    //资产安全状态
    public enum SecurityState {
        Normal(0),         // 正常
        Error(1);           // 异常

        private int val;

        SecurityState(Integer val) { this.val = val; }

        public Integer getVal() { return val;}
    }

    //变化类型
    public enum ChangeType{
        Increase(0),       //增加
        Decrease(1);        //减少
        private int val;

        ChangeType(Integer val) { this.val = val; }

        public Integer getVal() { return val;}
    }

    //增加类型
    public enum IncreaseType{
        Purchase(0),       //rmb购买
        Exchange(1),       //星钻兑换
        Reward(2);          //奖励赠送
        private int val;

        IncreaseType(Integer val) { this.val = val; }

        public Integer getVal() { return val;}
    }

    //奖励类型
    public enum RewardType{
        Diamond,       //星钻
        Goods           //物品
    }

    //获取途径类型
    public enum AccessType{
        Free(0),                        //免费
        Shop(1),                        //商城(星钻)购买
        MemberRight(2),                 //会员权益
        SigninReward(3),                //签到奖励
        SeasonReward(4),                //赛季奖励
        AchievementReward(5);           //成就奖励


        private int val;

        AccessType(Integer val) { this.val = val; }

        public Integer getVal() { return val;}
    }

    //获取途径类型描述  0-免费 1-星钻购买 2-会员专享 3-签到奖励 4-赛季奖励 5-特殊成就
    public enum AccessTypeDesc{
        Free("免费"),                            //免费
        Shop("星钻购买"),                        //商城(星钻)购买
        MemberRight("会员专享"),                 //会员权益
        SigninReward("签到奖励"),                //签到奖励
        SeasonReward("赛季奖励"),                //赛季奖励
        AchievementReward("特殊成就");           //成就奖励

        private String val;

        AccessTypeDesc(String val) { this.val = val; }

        public String getVal() { return val;}
    }


    //支付平台 1-微信支付 2-支付宝  3-苹果内购
    public enum TradePlatform{
        WechatPay(1),      //微信支付
        Alipay(2),      //支付宝
        AppleIAP(3);    //苹果内购

        private Integer val;

        TradePlatform(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }
    }

    /**
     * 订单状态  0-待支付 1-超时关闭 2-支付成功  3-订单完成 4-退款中 5-已退款 6-退款异常
     */
    public enum OrderState {
        WaitBuyerPay(0),   // 等待支付
        OrderClosed(1),    // 未支付,超时关闭
        OrderSuccess(2),   // 支付成功
        OrderFinished(3),   // 订单完成
        OrderRefunding(4),   // 退款中
        OrderRefunded(5),     // 已退款
        OrderRefundError(6);   // 退款异常

        private Integer val;

        OrderState(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }
    }

    /**
     * 登录途径
     */
    public enum LoginWay{
        PHONE,      //手机
        QQ,         //QQ
        WECHAT      //微信
    }

    /**
     * mq事件处理状态
     */
    public enum MqEventDealState{
        WaitingDeal(0),            //待处理
        HaveDeal(1) ;               //已处理
        private Integer val;

        MqEventDealState(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }
    }

    /**
     * 用户分值类型
     */
    public enum ScoreType{
        ACTIVE,         //活跃值
        POPULARITY,     //人气值
        WEALTH          //豪气值
    }

    /**
     * 消息内容的类型
     */
    public enum MsgType{
        Text(0),               //纯文字
        TextLink(1),           //文字链接
        PicText(2);             //图文

        private Integer val;

        MsgType(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }
    }

    /**
     * 资产类型
     */
    public enum AssetType{
        Diamond(0);            //星钻

        private Integer val;

        AssetType(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }
    }

    /**
     * 商城支付渠道
     */
    public enum MallPayChannel{
        Diamond(0);
        private Integer val;

        MallPayChannel(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }
    }

    /**
     * 补签道具类型
     */
    public enum ResignItemType{
        MemberRight(0),
        ResignCard(1);
        private Integer val;

        ResignItemType(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }
    }

    public enum SignInType{
        SignIn,
        MendSignIn

    }

    public enum ChannelType{
        Official, // 官网
        Myapp, //应用宝
        Huawe  //华为

    }

}
