package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_AIRL")
@Data
public class AIRL_Dflt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long meta_id;
    private Long flid;//航班标识标签
    private String fide;//航班标识
    private String ffid;//航班标识
}
