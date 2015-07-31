package cn.yrm.ss.user.domain;

import java.io.Serializable;

/**
 * 
 * @author Yuanruomu
 */
public class AuthUser implements Serializable {

    private static final long serialVersionUID = -1147928681455704400L;

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 登录账户名
     */
    private String userName;
    /**
     * 用户密码(已加密)
     */
    private String password;
    /**
     * 手机号码
     */
    private Long phone;
    /**
     * 用户状态
     */
    private Integer state;
    /**
     * 上次登录时间
     */
    private Long lastLogin;
    /**
     * 登录密码错误次数
     */
    private Integer loginErrNum;
    /**
     * 上次密码错误时间
     */
    private Long loginErrTime;
    /**
     * 是否管理员
     */
    private Boolean isAdmin;
    /**
     * 创建时间
     */
    private Long createAt;
    /**
     * 更新时间
     */
    private Long updateAt;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getLoginErrNum() {
        return loginErrNum;
    }

    public void setLoginErrNum(Integer loginErrNum) {
        this.loginErrNum = loginErrNum;
    }

    public Long getLoginErrTime() {
        return loginErrTime;
    }

    public void setLoginErrTime(Long loginErrTime) {
        this.loginErrTime = loginErrTime;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

}
