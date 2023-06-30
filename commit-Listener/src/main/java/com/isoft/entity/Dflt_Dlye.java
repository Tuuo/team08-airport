package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_DLYE")
@Data
public class Dflt_Dlye {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long meta_id;
    private String flid;//航班标识标签
    private String ffid;//航班标识
    private String fide;//航班标识
    private String fatt;//航班属性
    private String abst;//航班发布不正常状态
    private String iast;//内部航班不正常状态
    private String abrs;//航班发布不正常原因
    private String iars;//内部航班不正常原因
    private String mabs;//航班发布不正常状态2
    private String mabr;//航班发布不正常原因
    private String mias;//内部航班不正常状态2
    private String miar;//内部航班不正常原因2
    private String fett;//预计起飞时间
}
