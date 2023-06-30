package com.isoft.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "DFME_POKE")
@Data
public class DFME_POKE {
    @Id
    private Integer id;
    private Long meta_id;
    private Long flid;//航班标识标签
    private String ffid;//航班标识
    private String fide;//航班标识
    private String fatt;//航班属性
    private String stat;//航班发布状态
    private String ista;//航班状态
    private String pokt;//航班结束登机实际时间
    private String msta;//航班发布状态2
    private String mist;//内部航班状态2
    private String mpok;//航班结束登机实际时间


}
