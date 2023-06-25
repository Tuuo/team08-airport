package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_CKLS_CNTR")
@Data
public class Dflt_Ckls_Cntr {
    @Id
    private Integer cntr_id;
    private Long meta_id;
    private Long flid;
    private String ffid;
    private String fide;
    private String fatt;
    private String fces;
    private String fcee;
    private String fcrs;
    private String fcre;
    private String mces;
    private String mcee;
    private String mcrs;
    private String mcre;
    private String fcdp;
    private String mcdp;
    private String ckno;
    private Long id;
    private String code;
    private String ckat;
    private String type;
    private String ccar;
    private String estr;
    private String eend;
    private String rstr;
    private String rend;
    private String btsc;
    private Long dflt_id;
}
