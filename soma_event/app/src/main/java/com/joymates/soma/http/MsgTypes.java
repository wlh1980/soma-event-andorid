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
     * ================== 优惠券 2000开始==================
     */

    int DISCOUNT_SAVE_SUCCESS = 2000;
    int DISCOUNT_SAVE_FAILED = 2001;


}
