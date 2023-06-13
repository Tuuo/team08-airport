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
    private String flid;
    private String ffid;
    private String fide;
    private String fatt;
    private String abst;
    private String iast;
    private String abrs;
    private String iars;
    private String mabs;
    private String mabr;
    private String mias;
    private String miar;
    private String fett;
}
