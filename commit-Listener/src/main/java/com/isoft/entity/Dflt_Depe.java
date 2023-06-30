package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_DEPE")
@Data
public class Dflt_Depe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long meta_id;
    private String flid;//航班标识标签
    private String fatt;//航班属性
    private String ffid;//航班标识
    private String fide;//航班标识
    private String stat;//航班发布状态
    private String ista;//航班状态
    private String msta;//航班发布状态2
    private String mist;//内部航班状态2
    private String frtt;//实际起飞时间
}
