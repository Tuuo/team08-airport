package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFOE_DFIE")
@Data
public class Dflt_Dfie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long meta_id;
    private Long flid;
    private String afid;
    private String ffid;
    private String fide;
    private String test;
    private String awcd;
    private String flno;
    private String fexd;
    private String fimd;
    private String flio;
    private String fltk;
    private String fatt;
    private String patt;
    private String mfid;
    private String mffi;
    private String cftp;
    private String cfno;
    private String stat;
    private String abst;
    private String abrs;
    private String ista;
    private String iast;
    private String iars;
    private String msta;
    private String mabs;
    private String mabr;
    private String mist;
    private String mias;
    private String miar;
    private String bort;
    private String mbor;
    private String tbrt;
    private String mtbr;
    private String lbdt;
    private String mlbd;
    private String pokt;
    private String mpok;
    private String apot;
    private String dett;
    private String drtt;
    private String delt;
    private String drlt;
    private String vip;
    private String sflg;
    private String past;
    private String gtls;
    private String blls;
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
    private String chls;
    private String stls;
    private String nmcd;
    private String jmcd;
    private String fldt;
    private String lldt;
    private String cont;
    private String prox;

}
