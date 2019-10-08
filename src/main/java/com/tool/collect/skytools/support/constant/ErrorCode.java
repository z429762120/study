package com.tool.collect.skytools.support.constant;

/**
 * 异常代码
 *
 * @author Gnoll
 * @create 2017-06-19 18:52
 **/
public enum ErrorCode {
    /**
     * 支付异常
     */
    PaymentError(508),
    /**
     * 超过资源上限
     */
    OverLimit(507),

    /********************华丽的分隔符***********************/

    /**
     * 获取临时上传凭证失败
     */
    GetStsUptokenFail(506),

    /**
     * 获取缓存锁异常
     */
    CacheLockError(504),
    /**
     * 服务端HTTP请求错误
     */
    HttpRequestError(503),
    /**
     * json反序列化失败
     */
    JsonDeserializer(502),
    /**
     * json序列化失败
     */
    JsonSerializer(501),
    /**
     * 订单已完成
     */
    PayOrderFinished(492),
    /**
     * 订单已关闭或超时
     */
    PayOrderTimeOut(491),
    /**
     * 订单已支付
     */
    PayOrderPaid(490),
    /**
     * 融云IMAPi异常
     */
    RongCloudIMApi(459),
    /**
     * 微信已被绑定
     */
    WechatAlreadyBound(458),
    /**
     * 支付宝已被绑定
     */
    AlipayAlreadyBound(457),

    /**
     * qq已被绑定
     */
    QqAlreadyBound(455),
    /**
     * 微信API异常
     */
    WechatApi(454),
    /**
     * 阿里云支付异常
     */
    AlipayApi(453),

    /**
     * qqAPI异常
     */
    QqApi(451),

    /**
     * 请求太频繁
     */
    RequestTooOften(429),
    /**
     * 友盟openApi异常
     */
    UmengOpenApi(418),

    /**
     * App版本过低
     */
    AppVersion(405),
    /**
     * 资源未找到
     */
    ResourceNotFound(404),

    /**
     * 不能修改性别
     */
    UpdateGenderFailure(364),
    /**
     * 没有签到不能补签
     */
    NotSignIn(352),
    /**
     * 已经达到最大补签
     */
    ToDayAlreadyMendSignInMax(351),
    /**
     * 今天已经签到
     */
    ToDayAlreadySignIn(350),
    /**
     * 没有使用权限
     */
    NoPermissionToUse(342),
    /**
     * 未绑定手机号
     */
    NotBoundPhone(341),

    /**
     * 绑定冲突
     */
    BindingConflict(338),
    /**
     * 资产异常
     */
    AssetError(337),

    /**
     * 接口限流
     */
    RateLimiter(336),
    /**
     * 分布式锁处理中
     */
    InProgress(335),
    /**
     * 禁止游戏匹配
     */
    BanGameMatch(327),
    /**
     * 库存不足
     */
    InventoryNotEnough(326),
    /**
     * 账户余额不足
     */
    AccountBalanceNotEnough(325),
    /**
     * 已被屏蔽，操作失败
     */
    ShieldingException(324),
    /**
     * 游戏邀请异常
     */
    GameInviteException(323),
    /**
     * 游戏匹配异常
     */
    GameMatchException(322),
    /**
     * 数据异常
     */
    DataException(321),

    /**
     * 内容解析失败
     */
    ContentResolveFail(319),
    /**
     * 用户处于离线状态
     */
    UserOffLine(315),
    /**
     * 用户不存在
     */
    UserNotExists(314),

    /**
     * 短信验证码发送次数超过时段限制
     */
    SmsCodeOverLimit(312),
    /**
     * 短信验证码发送失败
     */
    SmsCodeSendFailed(311),
    /**
     * 短信验证码发送过于频繁
     */
    SmsCodeTooOften(310),

    /**
     * 手机号冲突
     */
    PhoneNumberConflict(308),

    /**
     * 用户被封号
     */
    UserBanned(307),

    /**
     * 请求头Divers格式错误
     */
    DiversHeader(306),
    /**
     * 没有权限
     */
    AUTH(305),
    /**
     * 短信验证码错误
     */
    SmsCodeCheck(304),
    /**
     * 需要注册
     */
    NeedRegister(303),
    /**
     * 未登录
     */
    NotLogin(302),
    /**
     * 请求冲突或数据库唯一冲突
     */
    Conflict(301),
    /**
     * 提交的参数有异常
     */
    Parameter(300),
    /**
     * ok
     */
    OK(200),
    /**
     * 服务器异常
     */
    Server(500);
    private static final String PREFIX = "{com.aimymusic.appserver.exception.";
    private static final String SUFFIX = ".message}";
    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public String getTemplate() {
        return PREFIX + code + SUFFIX;
    }
}
