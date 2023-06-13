package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFOE_DFIE_ARPT")
@Data
public class Dflt_Dfie_Arpt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String apno;
    private String apcd;
    private String fptt;
    private String fett;
    private String frtt;
    private String fplt;
    private String felt;
    private String frlt;
    private String apat;
    private Long dflt_id;
}
