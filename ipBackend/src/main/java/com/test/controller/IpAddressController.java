package com.test.controller;

import com.test.entity.IpAddress;
import com.test.service.IPAddressValidator;
import com.test.service.IpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/addresses")
public class IpAddressController {

    @Autowired
    private IpAddressService ipAddressService;

    @Autowired
    private IPAddressValidator validator;

    @RequestMapping(value = "/remote",method = RequestMethod.GET)
    public Collection<IpAddress> getAllRemoteIpAddress(){
        return ipAddressService.getAllIpAddress();
    }

    @RequestMapping(value = "/remote", method = RequestMethod.POST)
    public void postIpAddress(){
        ipAddressService.postIpAddress(ipAddressService.getIpAddress());
    }
    @RequestMapping(value = "/local",method = RequestMethod.GET)
    public Collection<IpAddress> getAllIpAddress(){
        return ipAddressService.getAllLocalIpAddress();
    }
    @RequestMapping(value = "/local", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postLocalIpAddress(@RequestBody IpAddress ipAddress) {
        if(validator.validate(ipAddress.getIpAddress())) {
            ipAddressService.postLocalIpAddress(ipAddress);
        }
    }
}