package com.joymates.soma.http.shouqiaba.entity;

import com.joymates.soma.entity.BaseVO;

import java.io.Serializable;

/**
 * Project name somaMerchantApp
 * Created by byd on 2018/8/7 16:15
 * Package name com.joymates.soma.http.shouqiaba.entity
 * Class Description 收钱吧返回值
 */
public class BaseEntity<T> extends BaseVO implements Serializable {

    private String result_code;
    private String error_code;
    private String error_message;
    private SecBase<T> biz_response;

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public SecBase<T> getBiz_response() {
        return biz_response;
    }

    public void setBiz_response(SecBase<T> biz_response) {
        this.biz_response = biz_response;
    }
}
