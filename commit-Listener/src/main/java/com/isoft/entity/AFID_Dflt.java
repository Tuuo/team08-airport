package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_AFID")
@Data
public class AFID_Dflt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long meta_id;
    private Long flid;//航班标识标签
    private String ffid;//航班标识
    private String fide;//航班标识
    private String afid;//关联航班ID

}
