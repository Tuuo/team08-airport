package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "DFME_GTLS_GATE")
@Data
public class Dflt_Gtls_Gate {
    private String gtno;
    @Id
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
