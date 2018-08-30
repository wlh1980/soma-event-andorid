package com.joymates.soma.http;

import com.joymates.soma.BuildConfig;

/**
 * Project name somaApp
 * Created by byd on 2018/6/19 9:38
 * Package name com.joymates.soma.http
 * Class Description
 */
public interface URLConstants {

    /**
     * ================== BASEURL服务器IP ==================
     */

    String BASE_URL = BuildConfig.API_SERVER_URL;// 服务地址

    /**
     * ================== 登录注册==================
     */

    /**
     * 手机登录
     */
    String LOGIN_PHONE = "/pos/sys/login";

    /**
     * ================== 用户信息==================
     */


    /**
     * 上传文件
     */
//    String UPLOAD_URL = "/sys/oss/upload";
    String UPLOAD_URL = "/oss/upload";

    /**
     * ================== 分类==================
     */

    /**
     * 获取分类信息列表
     */
    String GET_CATEGORY = "/pos/category/list";

    /**
     * 产品分类排序
     */
    String CATEGORY_SORTING = "/pos/category/sorting";

    /**
     * 修改产品分类对象状态
     */
    String CATEGORY_UPDATE_STATYS = "/pos/category/statusUpdate";

    /**
     * ================== 商户==================
     */

    /**
     * 删除商户对象
     */
    String MERCHANT_DELETE = "/pos/merchant/delete";

    /**
     * 根据id获取商户信息对象
     */
    String MERCHANT_GET_INFO = "/pos/merchant/info/";

    /**
     * 修改商户对象信息
     */
    String MERCHANT_UPDATE = "/pos/merchant/update";
    /**
     * 修改商户对象状态
     */
    String MERCHANT_STATUS_UPDATE = "/pos/merchant/statusUpdate";

    /**
     * 根据商户id查询商户下所有分类
     */
    String MERCHANT_GET_MERCHANT_CATEGORY = "/app/ccategory/getMerchantCategory/";


    /**
     * ==================产品==================
     */

    /**
     * 根据产品id获取产品详情
     */
    String PRODUCT_DETAILS = "/pos/app/product/info/";

    /**
     * 根据产品id获取产品套餐详情
     */
    String PRODUCT_PACKAGE_DETAILS = "/app/cproduct/getPackagedetails/";

    /**
     * 获取产品信息列表
     */
    String PRODUCT_LIST = "/pos/app/product/list";

    /**
     * 编辑产品对象
     */
    String PRODUCT_UPDATE = "/pos/app/product/update";

    /**
     * 修改产品售完状态
     */
    String PRODUCT_SELLOUT_UPDATE = "/pos/app/product/sellOutUpdate";


    String PRODUCT_SORTING = "/pos/app/product/sorting";

    /**
     * ==================优惠券==================
     */

    /**
     * 获取优惠券列表
     */
        String GET_DISCOUNT_LIST = "/pos/discount/list";

    /**
     * ==================订单==================
     */


    /**
     * 处理中订单信息列表
     */
    String GET_ORDER_PROCESS_LIST = "/pos/order/orderManage";

    /**
     * 未处理订单信息列表
     */
    String GET_ORDER_UNTREATED_LIST = "/pos/order/orderManage";

    /**
     * 查看订单详情
     */
    String GET_ORDER_DETAILS = "/pos/order/info/";

    /**
     * 修改订单状态为接收
     */
    String UPDATE_ORDER_STATUS = "/pos/order/statusUpdate";

    /**
     * 修改订单状态为完成
     */
    String UPDATE_ORDER_STATUS_FINISH = "/pos/order/statusUpdateByFinish";

    /**
     * 修改订单状态为取餐
     */
    String UPDATE_ORDER_STATUS_FOOD = "/pos/order/statusUpdateByFood";


    /**
     * 获取控制台对象信息
     */
    String GET_CONSOLE_INFO = "/pos/order/list";

    /**
     * 获取产品销量信息
     */
    String GET_HOME_PRODUCT = "/pos/order/productList";

    String GET_HOME_YUYUE_ORDER = "/pos/order/orderList";

    /**
     * ==================收藏==================
     */

    /**
     * 判断某一商户是否被用户收藏
     */
    String HAS_COLLECT = "/app/ccollection/hasCollect";

    /**
     * 用户收藏商户
     */
    String COLLECT = "/app/ccollection/collect";

    /**
     * 用户收藏商户
     */
    String CANCEL_COLLECTION = "/app/ccollection/cancelCollection";

    /**
     * 获取用户的收藏列表
     */
    String GET_COLLECTION = "/app/ccollection/getCollection";


    /**
     * ==================收藏==================
     */

    String CONFIG_GET_CONFIGS = "/app/csysconfig/find/";
}
