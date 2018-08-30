package com.joymates.soma.entity;

import java.io.Serializable;

/**
 * ProjectName：somaMerchantApp
 * PackageName：com.joymates.soma.entity
 * ClassDescribe：
 * CreaterBy：SongGang
 * CreateDate：2018/7/25 9:16
 * Remark：
 */
public class UserVO implements Serializable {


    /**
     * userId : 8
     * username : strong-001
     * password : 0ef8604a8d27d9466ba8135279527125c2fbefa88382f9bf0bd4e0d967074b9d
     * salt : Nf8mtUb0SEJBMN3dclOn
     * email : test001@163.com
     * mobile : 13100000000
     * status : 1
     * roleIdList : null
     * createUserId : 7
     * createTime : 2018-07-23 17:26:46
     * merchantId : 3
     * type : 3
     * childList : null
     */

    private int userId;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private int status;
    private Object roleIdList;
    private int createUserId;
    private String createTime;
    private int merchantId;
    private String type;
    private Object childList;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(Object roleIdList) {
        this.roleIdList = roleIdList;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getChildList() {
        return childList;
    }

    public void setChildList(Object childList) {
        this.childList = childList;
    }
}
