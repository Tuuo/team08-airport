package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_CFCE")
@Data
public class Dflt_Cfce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long meta_id;
    private String flid;//航班标识标签
    private String ffid;//航班标识
    private String fide;//航班标识
    private String cftp;//机型代码
    private String cfno;//机号代码
}
