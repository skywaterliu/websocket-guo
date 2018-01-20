package com.mafei.job.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by jms on 2017/10/15.
 * 设备
 */
public class Device {
    private String id;

    @JSONField(name="device_name")
    private String deviceName;

    @JSONField(name="msg_id")
    private Integer msgId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }
}
