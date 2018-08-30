package com.joymates.soma.http.shouqiaba.entity;

import com.joymates.soma.http.URLConstants;

/**
 * Project name somaMerchantApp
 * Created by byd on 2018/8/7 17:16
 * Package name com.joymates.soma.http.shouqiaba.entity
 * Class Description
 */
public interface SQBConstants {

    String VENDOR_SN = "91800450";
    String VENDOR_KEY = "9c15bc687826436fb73f162d136e283d";
    String APP_ID = "2018080700000894"; // b扫c // 官网c扫b 2018080700000895 // 微信公众号支付 2018080700000896
    String CODE = "13306913";// 测试激活码

    String TERMINAL = "TERMINAL"; // 终端
    String SN = "SN"; // 收钱吧终端ID
    String KEY = "KEY"; // 收钱吧终端密钥
    String TIMESTAMP = "TIMESTAMP"; // 时间戳

    String PAY_SUCCESS = "PAY_SUCCESS"; // 支付成功
    String PAY_IN_PROGRESS = "PAY_IN_PROGRESS"; // 交易进行中
    String PAY_FAIL = "PAY_FAIL"; // 交易失败
    String PAID = "PAID"; // 订单支付成功最终状态
    String CREATED = "CREATED"; // 交易进行中订单最终状态
    String PAY_CANCELED = "PAY_CANCELED"; // 交易失败订单最终状态

    String CANCEL_SUCCESS = "CANCEL_SUCCESS"; // 手动撤单成功
    String CANCEL_ERROR = "CANCEL_ERROR"; // 手动撤单失败
    String CANCELED = "CANCELED"; // 撤单成功

    String SUCCESS = "SUCCESS"; // 请求成功

    String NOTIFY_URL = URLConstants.BASE_URL + "/app/corder/paymentCallback"; // 支付成功回调地址

}
