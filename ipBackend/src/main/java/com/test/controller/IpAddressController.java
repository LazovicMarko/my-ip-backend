package com.test.controller;

import com.test.entity.IpAddress;
import com.test.service.IpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@RestController
@RequestMapping("/addresses")
public class IpAddressController {

    @Autowired
    private IpAddressService ipAddressService;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Collection<IpAddress> getAllIpAddress(){
        return ipAddressService.getAllIpAddress();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void postIpAddress(){
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        ipAddressService.postIpAddress(remoteAddr);

    }
}