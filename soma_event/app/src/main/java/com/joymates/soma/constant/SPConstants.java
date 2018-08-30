package com.joymates.soma.constant;

/**
 * ProjectName：somaMerchantApp
 * PackageName：com.joymates.soma.constant
 * ClassDescribe：sharePreferences缓存常量
 * CreaterBy：SongGang
 * CreateDate：2018/7/11 15:06
 * Remark：
 */
public interface SPConstants {

    /**
     * 登录记住密码
     */
    String KEY_LOGIN_ACCOUNT = "loginAccount";//账号
    String KEY_LOGIN_PASSWORD = "loginPassword";//密码

    /**
     * 是否自动登录
     */
//    String KEY_LOGIN_IS_KEEP_LOGIN = "loginIskeepLogin";//是否自动登录
    String KEY_KEEP_LOGIN_ROLEID = "keepLoginRoleId";//用户角色
//    String VALUE_KEEP_LOGIN = "keep";//自动登录
//    String VALUE_NOT_KEEP_LOGIN = "notKeep";//不自动登录


    /**
     * 订单小票的打印方式
     */
    String KEY_SELECT_PRINT_WAY = "printWayKey";//打印方式
    String VALUE_PRINT_WAY_CLOUD = "cloudPrint";//云打印
    String VALUE_PRINT_WAY_BLUETOOTH = "blueToothPrint";//蓝牙打印


    /**
     * 打印小票时间
     */
    String KEY_PRINTING_TIME = "printTimeKey";//打印时间
    String VALUE_PRINT_TIME_ONE = "1";//下单打印
    String VALUE_PRINT_TIME_TWO = "2";//扫码打印
    String VALUE_PRINT_TIME_THREE = "3";//接收打印

    /**
     * 自动接单倒计时
     */
    String KEY_AUTO_ACCEPT_TIMER="autoAcceptTimerKey";

}
