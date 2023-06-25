package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_GTLS_GATE")
@Data
public class Dflt_Gtls_Gate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gate_ID;
    private Long meta_id;
    private Long flid;
    private String ffid;
    private String fide;
    private String fatt;
    private String gtno;
    private Long id;
    private String code;
    private String gtat;
    private String estr;
    private String eend;
    private String rstr;
    private String rend;
    private String btsc;
    private Long dflt_id;
}
