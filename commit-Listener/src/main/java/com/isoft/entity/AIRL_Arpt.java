package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_AIRL_ARPT")
@Data
public class AIRL_Arpt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long meta_id;
    private Integer apno;
    private String apcd;
    private String fptt;
    private String fett;
    private String frtt;
    private String fplt;
    private String felt;
    private String frlt;
    private String apat;
    private Integer airl_Id;
}
