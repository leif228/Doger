package com.dog.doger.app.business.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceVo implements Serializable {
    private String ip;
    private String port;
    private String fzwno;
}
