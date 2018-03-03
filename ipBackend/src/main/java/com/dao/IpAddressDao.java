package com.dao;

import com.entity.IpAddress;
import com.repository.IpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class IpAddressDao {
    @Autowired
    private IpRepository ipRepository;


    public Collection<IpAddress> getAllIpAddress(){
        return (Collection<IpAddress>) this.ipRepository.findAll();
    }

    public void postIpAddress(String ipAddress){
        ipRepository.save(new IpAddress(ipAddress));
    }

    public Collection<IpAddress> getAllLocalIpAddress() {
        return (Collection<IpAddress>) this.ipRepository.findAll();
    }
    public void postLocalIpAddress(IpAddress ipAddress) {
        ipRepository.save(ipAddress);
    }

}