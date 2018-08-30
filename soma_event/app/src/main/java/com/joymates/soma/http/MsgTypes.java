package com.joymates.soma.http;

/**
 * Project name somaApp
 * Created by byd on 2018/6/19 10:28
 * Package name com.joymates.soma.http
 * Class Description
 */
public interface MsgTypes {

    /**
     * ================== 登录注册 1000开始==================
     */

    int LOGIN_SUCCESS = 1020; // 用户登录
    int LOGIN_FAILED = 1021;


    /**
     * ================== 个人信息 2000开始==================
     */
    int GET_USER_INFO_SUCCESS = 2010; // 获取用户信息
    int GET_USER_INFO_FAILED = 2011;

    int UPDATE_USER_INFO_SUCCESS = 2020; // 更新用户信息
    int UPDATE_USER_INFO_FAILED = 2021;

    int UPDATE_PASSWORD_SUCCESS = 2030; // 更新用户密码
    int UPDATE_PASSWORD_FAILED = 2031;

    int MESSAGE_GET_UNREAD_MSG_COUNT_SUCCESS = 2040; // 未读消息
    int MESSAGE_GET_UNREAD_MSG_COUNT_FAILED = 2041;

    int UPLOAD_FILE_SUCCESS = 2050; // 未读消息
    int UPLOAD_FILE_FAILED = 2051;

    /**
     * ================== 分类信息 2500==================
     */

    int GET_CATEGORY_SUCCESS = 2500;
    int GET_CATEGORY_FAILED = 2501;

    int CATEGORY_SORTING_SUCCESS = 2510;
    int CATEGORY_SORTING_FAILED = 2511;

    int CATEGORY_UPDATE_STATYS_SUCCESS = 2520;
    int CATEGORY_UPDATE_STATYS_FAILED = 2521;
    /**
     * ================== 商户信息 3000开始==================
     */
    int MERCHANT_DELETE_SUCCESS = 3000;
    int MERCHANT_DELETE_FAILED = 3001;


    int MERCHANT_GET_INFO_SUCCESS = 3010;
    int MERCHANT_GET_INFO_FAILED = 3011;

    int MERCHANT_UPDATE_SUCCESS = 3020;
    int MERCHANT_UPDATE_FAILED = 3021;

    int MERCHANT_STATUS_UPDATE_SUCCESS = 3030;
    int MERCHANT_STATUS_UPDATE_FAILED = 3031;

    int MERCHANT_GET_MERCHANT_CATEGORY_SUCCESS = 3040;
    int MERCHANT_GET_MERCHANT_CATEGORY_FAILED = 3041;


    /**
     * ================== 产品信息 4000开始==================
     */
    int PRODUCT_DETAILS_SUCCESS = 4000;
    int PRODUCT_DETAILS_FAILED = 4001;

    int PRODUCT_LIST_SUCCESS = 4002;
    int PRODUCT_LIST_FAILED = 4003;

    int PRODUCT_PACKAGE_DETAILS_SUCCESS = 4004;
    int PRODUCT_PACKAGE_DETAILS_FAILED = 4005;

    int PRODUCT_UPDATE_SUCCESS = 4030;
    int PRODUCT_UPDATE_FAILED = 4031;

    int PRODUCT_SELLOUT_UPDATE_SUCCESS = 4040;
    int PRODUCT_SELLOUT_UPDATE_FAILED = 4041;

    int PRODUCT_SORTING_SUCCESS = 4050;
    int PRODUCT_SORTING_FAILED = 4051;

    /**
     * ================== 优惠券 5000开始==================
     */

    int GET_DISCOUNT_LIST_SUCCESS = 5000;
    int GET_DISCOUNT_LIST_FAILED = 5001;

    /**
     * ================== 订单 6000开始==================
     */


    int GET_ORDER_PROCESS_LIST_SUCCESS = 6010;
    int GET_ORDER_PROCESS_LIST_FAILED = 6011;

    int GET_ORDER_UNTREATED_LIST_SUCCESS = 6020;
    int GET_ORDER_UNTREATED_LIST_FAILED = 6021;

    int GET_ORDER_HISTORY_LIST_SUCCESS = 6025;
    int GET_ORDER_HISTORY_LIST_FAILED = 6026;

    int GET_ORDER_DETAILS_SUCCESS = 6030;
    int GET_ORDER_DETAILS_FAILED = 6031;

    int UPDATE_ORDER_STATUS_SUCCESS = 6040;
    int UPDATE_ORDER_STATUS_FAILED = 6041;

    int UPDATE_ORDER_STATUS_FINISH_SUCCESS = 6050;
    int UPDATE_ORDER_STATUS_FINISH_FAILED = 6051;

    int UPDATE_ORDER_STATUS_FOOD_SUCCESS = 6060;
    int UPDATE_ORDER_STATUS_FOOD_FAILED = 6061;

    int GET_CONSOLE_INFO_SUCCESS = 6070;
    int GET_CONSOLE_INFO_FAILED = 6071;

    int GET_HOME_PRODUCT_SUCCESS = 6080;
    int GET_HOME_PRODUCT_FAILED = 6081;

    int GET_HOME_YUYUE_ORDER_SUCCESS = 6090;
    int GET_HOME_YUYUE_ORDER_FAILED = 6091;

    /**
     * ================== 收藏 7000开始==================
     */

    int HAS_COLLECT_SUCCESS = 7000;
    int HAS_COLLECT_FAILED = 7001;

    int COLLECT_SUCCESS = 7002;
    int COLLECT_FAILED = 7003;

    int CANCEL_COLLECTION_SUCCESS = 7004;
    int CANCEL_COLLECTION_FAILED = 7005;

    int GET_COLLECTION_SUCCESS = 7006;
    int GET_COLLECTION_FAILED = 7007;

    /**
     * ================== 配置 8000开始==================
     */

    int CONFIG_GET_CONFIGS_SUCCESS = 8000;
    int CONFIG_GET_CONFIGS_FAILED = 8001;

}
