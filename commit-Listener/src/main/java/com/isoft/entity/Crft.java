package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "BASE_CFUE")
@Data
public class Crft {
    @Id
    private Long id;
    private Long meta_id;
    private String code;
    private String cftp;
    private String awcd;
    private Integer stnm;
    private Integer rstn;
    private String cfsa;
    private Float ttwc;
    private Float mxlw;
    private Float rllw;

}
