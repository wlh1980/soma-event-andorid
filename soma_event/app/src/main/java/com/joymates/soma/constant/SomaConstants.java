package com.joymates.soma.constant;

/**
 * ProjectName：somaMerchantApp
 * PackageName：com.joymates.soma.constant
 * ClassDescribe：
 * CreaterBy：SongGang
 * CreateDate：2018/7/13 9:38
 * Remark：
 */
public interface SomaConstants {

    /**
     * 用户角色
     */
    int ROLE_STYTEM_MANAGER = 2;//系统管理员
    int ROLE_MARKET_PERSONNEL = 3;//市场人员
    int ROLE_MERCHANT_MANAGER = 10;//商户管理员
    int ROLE_MERCHANT_DIRECTOR = 11;//商户经理
    int ROLE_MERCHANT_CASHIER = 13;//商户收银员
    int ROLE_MERCHANT_TEST = 15;//测试

    /**
     * 货币符号
     */
    String CURRENCY_SINGAPORE = "S$"; // 新加坡货币符号
    String CURRENCY_DOLLAR = "$"; // 美元


    /**
     * 配置信息
     */
    String MERCHANT_UNIT_PRICE_KEY = "MERCHANT_UNIT_PRICE_KEY";//平均客单价配置信息
    String MERCHANT_TAX_FEE_KEY = "MERCHANT_TAX_FEE_KEY";//税费配置信息
    String MERCHANT_SERVICE_FEE_KEY = "MERCHANT_SERVICE_FEE_KEY";//服务费配置信息
    String PRODUCT_DISCOUNT_KEY = "PRODUCT_DISCOUNT_KEY";//产品折扣配置信息
    String MERCHANT_TAX_FEE_NAME_KEY = "MERCHANT_TAX_FEE_NAME_KEY";//税费名称配置信息
    String MERCHANT_CURRENCY_SYMBOL_KEY = "MERCHANT_CURRENCY_SYMBOL_KEY";//货币符号配置信息
    String MERCHANT_LEVEL = "MERCHANT_LEVEL";//标签配置信息


    /**
     * 控制台
     */
    String CONSOLE_TODAY = "1";//当天
    String CONSOLE_YESTERDAY = "2";//昨天
    String CONSOLE_THIS_WEEK = "3";//本周
    String CONSOLE_LAST_WEEK = "4";//上周
    String CONSOLE_THIS_MONTH = "5";//本月
    String CONSOLE_LAST_MONTH = "6";//上月
    String CONSOLE_CUSTOM_RANGE = "7";//自定义


    /**
     * 就餐类型
     */
    String DINING_TYPE_EAT = "eat";//就餐
    String DINING_TYPE_PACKED = "packed";//打包
    String DINING_TYPE_ORDER = "order";//预约

}
