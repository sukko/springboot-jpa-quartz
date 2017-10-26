package com.sukko.sjq.controllers;

import com.sukko.sjq.models.*;
import com.sukko.sjq.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private DeviceRepository deviceRepository;

    @RequestMapping("/member/addDevice")
    public Device addDevice(@RequestParam(value="deviceId") String deviceId, @RequestParam(value="token", defaultValue = "") String token, @RequestParam(value="platform") String platform) {
        Device device = null;

        try {
            device = deviceRepository.findOne(deviceId);
            if (device != null && device.getDeviceId() != null && !device.getDeviceId().equals("")) {
                if (!token.equals("")) {
                    device.setToken(token);
                }
                device.setPlatform(platform);

            } else {
                device = new Device();
                device.setDeviceId(deviceId);
                device.setPlatform(platform);
                device.setSeqNo(deviceRepository.count() + 1);
                device.setToken(token);
            }
            device.setLastAccess(System.currentTimeMillis());

            deviceRepository.save(device);

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return device;
    }

    @RequestMapping("/member/deviceList")
    public List<Device> deviceList() {
        List<Device> device = null;

        try {
            device = deviceRepository.findAll();

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return device;
    }


}