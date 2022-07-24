package com.springboot.first.app;

import java.util.List;

public class UserRatting {
    public UserRatting() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Ratting> getUserRatting() {
        return userRatting;
    }

    public void setUserRatting(List<Ratting> userRatting) {
        this.userRatting = userRatting;
    }

    private String userId;
    private List<Ratting> userRatting;

    public UserRatting(String userId, List<Ratting> userRatting) {
        this.userId = userId;
        this.userRatting = userRatting;
    }


}