package com.joymates.soma.http;

/**
 * ProjectName：TuanLeApp
 * PackageName：com.joymates.tuanle.common
 * ClassDescribe：
 * CreaterBy：SongGang
 * CreateDate：2017/12/28 21:02
 * Remark：
 */
public interface ResultCode {

    int CODE_SUCCESS = 0;
    int CODE_ONE = 1;
    int CODE_TWO = 2;

    String CODE_200 = "200";
    String CODE_400 = "400";

    int CODE_201 = 201;
    int CODE_202 = 202;
    int CODE_301 = 301;

    int CODE_204 = 204;

    int CODE_650 = 650;

    int CODE_652 = 652;

    int CODE_401 = 401;//token失效，请重新登录
}
