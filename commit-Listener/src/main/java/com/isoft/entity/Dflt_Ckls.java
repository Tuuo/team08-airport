package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_CKLS")
@Data
public class Dflt_Ckls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long meta_id;
    private Long flid;//航班标识标签
    private String ffid;//航班标识
    private String fide;//航班标识
    private String fatt;//航班属性
    private String fces;//航班旅客值机预计开始时间1
    private String fcee;//航班旅客值机预计结束时间1
    private String fcrs;//航班旅客值机实际开始时间1
    private String fcre;//航班旅客值机实际结束时间1
    private String mces;//航班旅客值机预计开始时间2
    private String mcee;//航班旅客值机预计结束时间2
    private String mcrs;//航班旅客值机实际开始时间2
    private String mcre;//航班旅客值机实际结束时间2
    private String fcdp;//值机柜台及值机柜台区域显示1
    private String mcdp;//值机柜台及值机柜台区域显示2
}
