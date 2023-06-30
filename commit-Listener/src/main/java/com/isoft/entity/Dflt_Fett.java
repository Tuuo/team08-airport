package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_Fett")
@Data
public class Dflt_Fett {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Long meta_id;
    private String flid;//航班标识标签
    private String ffid;//航班标识
    private String fide;//航班标识
    private String fett;//预计起飞时间
    private String felt;//预计降落时间
}
