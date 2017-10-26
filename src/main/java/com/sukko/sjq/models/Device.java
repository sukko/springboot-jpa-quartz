package com.sukko.sjq.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Device {

    @Id
    private String deviceId;

    @Column
    private String token;

    @Column
    private String platform;

    @Column
    private Long lastAccess;

    @Column
    private Long seqNo;

    public Device() {
    }

    public Device(String deviceId) {
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Long lastAccess) {
        this.lastAccess = lastAccess;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Long getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Long seqNo) {
        this.seqNo = seqNo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                ", token='" + token + '\'' +
                ", platform='" + platform + '\'' +
                ", lastAccess=" + lastAccess +
                ", seqNo=" + seqNo +
                '}';
    }
}
