package com.test.controller;

import com.test.entity.IpAddress;
import com.test.service.IpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/ipAddressS")
public class IpAddressController {

    @Autowired
    private IpAddressService ipAddressService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<IpAddress> getAllIpAddress(){
        return ipAddressService.getAllIpAddress();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public IpAddress getIpAddressById(@PathVariable("id") int id){
        return ipAddressService.getIpAddressById(id);
    }
    @RequestMapping(value = "/{ip}", method = RequestMethod.POST)
    public void postIpAddress(@PathVariable("ip") String ipAddress){
        ipAddressService.postIpAddress(ipAddress);
    }
}