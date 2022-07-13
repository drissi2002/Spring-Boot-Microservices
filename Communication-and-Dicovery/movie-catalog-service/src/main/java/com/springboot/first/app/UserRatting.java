package com.springboot.first.app;

import com.springboot.first.app.Ratting;

import java.util.List;

public class UserRatting {
    private List<Ratting> userRatting;

    public List<Ratting> getUserRatting() {
        return userRatting;
    }

    public void setUserRatting(List<Ratting> userRatting) {
        this.userRatting = userRatting;
    }
}