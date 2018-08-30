package com.joymates.soma.http;

/**
 * Project name somaMerchantApp
 * Created by byd on 2018/8/6 11:26
 * Package name com.joymates.soma.http
 * Class Description 商户产品下单
 */
public interface ShoppingMsgTypes {

    /**
     * ================== 商户信息 3000开始==================
     */
    int MERCHANT_GET_LIST_SUCCESS = 3000;
    int MERCHANT_GET_LIST_FAILED = 3001;

    int MERCHANT_HAS_CHILD_SUCCESS = 3002;
    int MERCHANT_HAS_CHILD_FAILED = 3003;

    int MERCHANT_CHILD_LIST_SUCCESS = 3004;
    int MERCHANT_CHILD_LIST_FAILED = 3005;

    int MERCHANT_GET_INFO_SUCCESS = 3006;
    int MERCHANT_GET_INFO_FAILED = 3007;

    int MERCHANT_GET_MERCHANT_CATEGORY_SUCCESS = 3008;
    int MERCHANT_GET_MERCHANT_CATEGORY_FAILED = 3009;

    int MERCHANT_GET_BUSINESS_HOUR_SUCCESS = 3010;
    int MERCHANT_GET_BUSINESS_HOUR_FAILED = 3011;

    int GET_ORDER_WAITING_TIME_SUCCESS = 3012;
    int GET_ORDER_WAITING_TIME_FAILED = 3013;

    int SEARCH_AREA_SUCCESS = 3014;
    int SEARCH_AREA_FAILED = 3015;

    /**
     * ================== 产品信息 4000开始==================
     */
    int PRODUCT_DETAILS_SUCCESS = 4000;
    int PRODUCT_DETAILS_FAILED = 4001;

    int PRODUCT_LIST_SUCCESS = 4002;
    int PRODUCT_LIST_FAILED = 4003;

    int PRODUCT_PACKAGE_DETAILS_SUCCESS = 4004;
    int PRODUCT_PACKAGE_DETAILS_FAILED = 4005;

    int GET_MERCHANT_PRODUCT_LIST_SUCCESS = 4006;
    int GET_MERCHANT_PRODUCT_LIST_FAILED = 4007;

    /**
     * ================== 订单 6000开始==================
     */

    int ORDER_CREATE_SUCCESS = 6000;
    int ORDER_CREATE_FAILED = 6001;

    int CANCEL_ORDER_SUCCESS = 6002;
    int CANCEL_ORDER_FAILED = 6003;

    int CANCEL_SQB_ORDER_SUCCESS = 6004;
    int CANCEL_SQB_ORDER_FAILED = 6005;

    /*
     * ================== 收钱吧支付 7000开始==================
     */
    int SQB_ACTIVE_SUCCESS = 7000;
    int SQB_ACTIVE_FAILED = 7001;

    int SQB_CHECKIN_SUCCESS = 7002;
    int SQB_CHECKIN_FAILED = 7003;

    int SQB_PAY_SUCCESS = 7004;
    int SQB_PAY_FAILED = 7005;

    int SQB_PRECREATE_SUCCESS = 7006;
    int SQB_PRECREATE_FAILED = 7007;

    int SQB_REFUND_SUCCESS = 7008;
    int SQB_REFUND_FAILED = 7009;

    int SQB_CANCEL_SUCCESS = 7010;
    int SQB_CANCEL_FAILED = 7011;

    int SQB_REVOKE_SUCCESS = 7012;
    int SQB_REVOKE_FAILED = 7013;

    int SQB_QUERY_SUCCESS = 7014;
    int SQB_QUERY_FAILED = 7015;

    int SQB_ACTIVE_WITH_SERVER_SUCCESS = 7016;
    int SQB_ACTIVE_WITH_SERVER_FAILED = 7017;

    int SQB_CHECKIN_WITH_SERVER_SUCCESS = 7018;
    int SQB_CHECKIN_WITH_SERVER_FAILED = 7019;

    /*
     * ================== N5支付 8000开始==================
     */
    int FIND_INVOICE_NUMBER_SUCCESS = 8000;
    int FIND_INVOICE_NUMBER_FAILED = 8001;

    int N5_PAY_SUCCESS = 8002;
    int N5_PAY_FAILED = 8003;

    int N5_REFUND_SUCCESS = 8004;
    int N5_REFUND_FAILED = 8005;
}
