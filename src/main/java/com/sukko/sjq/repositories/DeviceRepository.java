package com.sukko.sjq.repositories;

import com.sukko.sjq.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by jared on 15. 1. 8..
 */
public interface DeviceRepository extends JpaRepository<Device, String> {

    @Query("SELECT a FROM Device a WHERE a.deviceId = :deviceId ORDER BY a.lastAccess DESC")
    Device findByMyDevice(@Param("deviceId") String deviceId);

}