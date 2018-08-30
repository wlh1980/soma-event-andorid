package com.joymates.soma.entity;

import java.io.Serializable;

/**
 * Project name somaApp
 * Created by byd on 2018/6/19 9:36
 * Package name com.joymates.soma.entity
 * Class Description
 */
public class BaseVO implements Serializable {

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
