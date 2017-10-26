package com.sukko.sjq.scheduler;

import com.sukko.sjq.models.*;
import com.sukko.sjq.repositories.*;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

/**
 * Created by sukko on 2017. 10. 8..
 */
public class PushJob implements Job {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("\n\n--------------------------job Start---------------------------\n\n");

        List<Device> deviceList = deviceRepository.findAll();
        for (Device device : deviceList) {
            log.info(device.toString());
        }

        log.info("\n\n--------------------------job End---------------------------\n\n");
    }

}