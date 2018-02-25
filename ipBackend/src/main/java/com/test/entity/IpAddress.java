package com.test.entity;

public class IpAddress {private int id;
    private String ipAddress;

    public IpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public IpAddress() {
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}