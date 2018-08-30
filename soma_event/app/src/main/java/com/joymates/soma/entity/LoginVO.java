package com.joymates.soma.entity;

/**
 * Project name somaApp
 * Created by byd on 2018/6/19 14:24
 * Package name com.joymates.soma.entity
 * Class Description
 */
public class LoginVO extends BaseVO {

    private int roleId;//角色 10-商户管理员 11-商户经理 13-商户收银员
    private String expire; // 到期
    private String token; // 令牌

    private String username;//用户账号

    private String printingTime;//1-下单打印 2-扫码打印 3-接收打印

    private String countDown;//接单倒计时

    /**
     * 打印时间
     */
    public static final String PRINT_TIME_ONE = "1";//下单打印
    public static final String PRINT_TIME_TWO = "2";//扫码打印

    UserVO user;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public String getPrintingTime() {
        return printingTime;
    }

    public void setPrintingTime(String printingTime) {
        this.printingTime = printingTime;
    }

    public String getCountDown() {
        return countDown;
    }

    public void setCountDown(String countDown) {
        this.countDown = countDown;
    }
}
