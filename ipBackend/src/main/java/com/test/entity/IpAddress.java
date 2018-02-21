package com.test.entity;

public class IpAddress {private int id;
    private String ipAddress;

    public IpAddress(int id, String ipAddress) {
        this.id = id;
        this.ipAddress = ipAddress;
    }

    public IpAddress() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}