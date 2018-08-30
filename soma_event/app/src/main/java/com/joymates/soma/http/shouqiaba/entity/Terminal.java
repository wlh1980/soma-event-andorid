package com.joymates.soma.http.shouqiaba.entity;

import java.io.Serializable;

/**
 * Project name somaMerchantApp
 * Created by byd on 2018/8/7 16:18
 * Package name com.joymates.soma.http.shouqiaba.entity
 * Class Description
 */
public class Terminal implements Serializable {

    /**
     * terminal_sn : 10298371039
     * terminal_key : 68d499beda5f72116592f5c527465656
     */

    private String terminal_sn;
    private String terminal_key;

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
}
