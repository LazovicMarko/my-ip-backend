package com.test.service;

import com.test.dao.IpAddressDao;
import com.test.entity.IpAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class IpAddressService {

    @Autowired
    private IpAddressDao ipDao;

    public Collection<IpAddress> getAllIpAddress(){
        return this.ipDao.getAllIpAddress();
    }

    public void postIpAddress(String ipAddress) {
        this.ipDao.postIpAddress(ipAddress);
    }
}