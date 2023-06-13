package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_CKLS_CNTR")
@Data
public class Dflt_Ckls_Cntr {
    private String ckno;
    @Id
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
