package com.test.dao;

import com.test.entity.IpAddress;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class IpAddressDao {
    private int lastId;
    private static Map<Integer,IpAddress> ipAddressMap;
    static {
        ipAddressMap = new HashMap<Integer, IpAddress>();
    }

    public Collection<IpAddress> getAllIpAddress(){
        return this.ipAddressMap.values();
    }

    public IpAddress getIpAddressById(int id){
        return this.ipAddressMap.get(id);
    }
    public void postIpAddress(String ipAddress){

        if(ipAddressMap.isEmpty()) {
            lastId = 0;
        }else {
            lastId = ipAddressMap.size();
        }
        ipAddressMap.put(lastId,new IpAddress(lastId,ipAddress));
    }
}