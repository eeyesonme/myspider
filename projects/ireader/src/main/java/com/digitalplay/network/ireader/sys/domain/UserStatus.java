package com.digitalplay.network.ireader.sys.domain;

public enum UserStatus {

    normal("NORMAL"), blocked("BLOCKED");

    private final String info;

    private UserStatus(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
