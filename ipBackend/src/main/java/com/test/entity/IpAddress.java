package com.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IpAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String ipAddress;
    private String service;

    public IpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        this.service = "default";
    }

    public IpAddress(String ipAddress, String service) {
        this.ipAddress = ipAddress;
        this.service = service;
    }

    public IpAddress() {
        this.ipAddress = null;
        this.service = null;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getId() {
        return id;
    }

}