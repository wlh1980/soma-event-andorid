package com.joymates.soma.http;

/**
 * Project name somaMerchantApp
 * Created by byd on 2018/8/6 11:24
 * Package name com.joymates.soma.http
 * Class Description 商户产品下单
 */
public interface ShoppingURLConstants {

    /**
     * 获取产品列表
     */
    String PRODUCT_LIST = "/app/cproduct/list";

    /**
     * 获取产品列表
     */
    String GET_MERCHANT_PRODUCT_LIST = "/app/cproduct/getProductList/";

    /**
     * 根据产品id获取产品详情
     */
    String PRODUCT_DETAILS = "/app/cproduct/details/";

    /**
     * 根据产品id获取产品套餐详情
     */
    String PRODUCT_PACKAGE_DETAILS = "/app/cproduct/getPackagedetails/";

    /**
     * 创建订单
     */
    String ORDER_CREATE = "/app/corder/create";

    /**
     * 取消订单 stripe
     */
    String CANCEL_ORDER = "/app/stripe/refund";

    /**
     * 取消订单 收钱吧
     */
    String CANCEL_SQB_ORDER = "/app/corder/refundCallback";

    /**
     * 根据商户id查询商户营业时间
     */
    String MERCHANT_GET_BUSINESS_HOUR = "/app/merchant/getBusinessTime/";

    /**
     * 根据商户id查询等待时间
     */
    String MERCHANT_GET_ORDER_WAITING_TIME = "/app/corder/orderWaitingTime/";

    /* ===================================start 收钱吧 start==============================*/

    /**
     * 终端激活
     */
    String ACTIVE = "/terminal/activate";
    /**
     * 终端签到
     */
    String CHECKIN = "/terminal/checkin";
    /**
     * 付款
     */
    String PAY = "/upay/v2/pay";
    /**
     * 预下单
     */
    String PRECREATE = "/upay/v2/precreate";
    /**
     * 退款
     */
    String REFUND = "/upay/v2/refund";
    /**
     * 自动撤单
     */
    String CANCEL = "/upay/v2/cancel";
    /**
     * 手动撤单
     */
    String REVOKE = "/upay/v2/revoke";
    /**
     * 查询
     */
    String QUERY = "/upay/v2/query";

    /**
     * 服务端激活
     */
    String ACTIVE_WITH_SERVER = "/app/shouqianba/getActivation";

    /**
     * 服务端签到
     */
    String CHECKIN_WITH_SERVER = "/app/shouqianba/getCheckin";

    /* ===================================end 收钱吧 end==============================*/


    /* ===================================start N5 start==============================*/

    // 获取N5支付编号
    String FIND_INVOICE_NUMBER = "/app/n5/findInvoiceNumber/";

    // N5支付
    String N5_PAY = "/app/n5/pay";

    // N5取消订单
    String N5_REFUND = "/app/n5/refund";

    /* ===================================end N5 end==============================*/

}
