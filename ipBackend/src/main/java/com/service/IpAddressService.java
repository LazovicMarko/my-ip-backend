package com.service;

import com.dao.IpAddressDao;
import com.entity.IpAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Service
public class IpAddressService {

    @Autowired
    private IpAddressDao ipDao;

    @Autowired
    private HttpServletRequest request;

    public Collection<IpAddress> getAllIpAddress(){

        return this.ipDao.getAllIpAddress();
    }

    public void postIpAddress(String ipAddress) {
        this.ipDao.postIpAddress(ipAddress);
    }

    public Collection<IpAddress> getAllLocalIpAddress() {
        return this.ipDao.getAllLocalIpAddress();
    }

    public void postLocalIpAddress(IpAddress ipAddress){
        this.ipDao.postLocalIpAddress(ipAddress);
    }

    public String getIpAddress(){
        String remoteAddreess = "";
        if (request != null) {
            remoteAddreess = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddreess == null || "".equals(remoteAddreess)) {
                remoteAddreess = request.getRemoteAddr();
            }
        }
        return remoteAddreess;
    }
}