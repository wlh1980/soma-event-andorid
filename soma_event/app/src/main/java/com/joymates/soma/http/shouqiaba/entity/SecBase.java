package com.joymates.soma.http.shouqiaba.entity;

import java.io.Serializable;

/**
 * Project name somaMerchantApp
 * Created by byd on 2018/8/7 16:44
 * Package name com.joymates.soma.http.shouqiaba.entity
 * Class Description
 */
public class SecBase<T> implements Serializable {
    private String result_code;
    private String error_code;
    private String error_message;
    private String terminal_sn;
    private String terminal_key;
    private T data;

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

    public String getTerminal_sn() {
        return terminal_sn;
    }

    public void setTerminal_sn(String terminal_sn) {
        this.terminal_sn = terminal_sn;
    }

    public String getTerminal_key() {
        return terminal_key;
    }

    public void setTerminal_key(String terminal_key) {
        this.terminal_key = terminal_key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
