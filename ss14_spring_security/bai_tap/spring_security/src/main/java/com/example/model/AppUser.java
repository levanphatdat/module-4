package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "app_user", uniqueConstraints = {
        @UniqueConstraint(name = "app_user_uk", columnNames = "user_name")})
public class AppUser {
    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "user_name", length = 36, nullable = false)
    private String userName;
    @Column(name = "password", length = 128, nullable = false)
    private String password;
    @Column(name = "enable", length = 1, nullable = false)
    private boolean enable;

    public AppUser() {
    }

    public AppUser(Long userId, String userName, String password, boolean enable) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.enable = enable;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
