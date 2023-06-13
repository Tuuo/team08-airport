package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_CKLS")
@Data
public class Dflt_Ckls {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long meta_id;
    @Id
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
}
