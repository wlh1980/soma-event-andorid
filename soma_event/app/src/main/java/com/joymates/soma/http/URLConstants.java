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
     * ==================优惠券==================
     */

    /**
     * 发放优惠券码
     */
    String DISCOUNT_SAVE = "/pos/discouncustomer/save";

}
