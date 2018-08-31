package com.joymates.soma.http.business;

import android.content.Context;
import android.os.Handler;

import com.alibaba.fastjson.JSON;
import com.joymates.common.http.HttpRequest;
import com.joymates.soma.entity.BaseVO;
import com.joymates.soma.entity.LoginVO;
import com.joymates.soma.entity.SaveDiscount;
import com.joymates.soma.http.MsgTypes;
import com.joymates.soma.http.URLConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Project name somaApp
 * Created by byd on 2018/6/19 10:51
 * Package name com.joymates.soma.http.business
 * Class Description
 */
public class LoginBusiness {


    /**
     * 登录
     *
     * @param context
     * @param handler
     * @param username 帐号
     * @param password 密码
     */
    public static void login(final Context context, Handler handler, String username, String password) {

        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);

        String json = JSON.toJSONString(map);

        HttpRequest.post(context, handler, URLConstants.BASE_URL + URLConstants.LOGIN_PHONE,
                json,
                LoginVO.class, HttpRequest.REQUEST_TYPE_CLASS,
                MsgTypes.LOGIN_SUCCESS,
                MsgTypes.LOGIN_FAILED, true);
    }


    /**
     * 发放优惠券
     *
     * @param context
     * @param handler
     */
    public static void saveDiscount(final Context context, Handler handler) {

        HttpRequest.post(context, handler, URLConstants.BASE_URL + URLConstants.DISCOUNT_SAVE,
                "",
                SaveDiscount.class, HttpRequest.REQUEST_TYPE_CLASS,
                MsgTypes.DISCOUNT_SAVE_SUCCESS,
                MsgTypes.DISCOUNT_SAVE_FAILED, false);
    }

}
