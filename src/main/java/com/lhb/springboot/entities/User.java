package com.lhb.springboot.entities;

/**
 * 用户实体类
 * @Title: Provider
 * @Description: com.lhb.springboot.entities
 * @Auther: www.stbu.edu.cn
 * @Version: 1.0
 */
public class User {
    private int userUuid;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private int userLevel;

    @Override
    public String toString() {
        return "User{" +
                "userUuid=" + userUuid +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userLevel=" + userLevel +
                '}';
    }

    public int getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(int userUuid) {
        this.userUuid = userUuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

}
