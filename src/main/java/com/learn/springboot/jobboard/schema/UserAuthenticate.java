package com.learn.springboot.jobboard.schema;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

@Document(collection = "UserCredentials")
public class UserAuthenticate {
    @Id
    private String id;
    @Field("userId")
    private String userId;
    @Field("userLogIn")
    private String userLogin;
    @Field("password")
    private String password;
    @Field("accountType")
    private String accountType;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserLogin() {
        return userLogin;
    }
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    @Override
    public String toString() {
        return "UserAuthenticate{id=" + id + ", userId=" + userId + ", userLogin=" + userLogin + ", password="+ password + ", accountType=" + accountType + "}";
    }
}
