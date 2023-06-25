package com.isoft.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_STLS_STND")
@Data

public class DFME_STLS_STND {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long meta_id;
    private Long flid;
    private String ffid;
    private String fide;
    private String fatt;
    private Integer stls_id;
    private String stno;
    private String code;
    private String estr;
    private String eend;
    private String rstr;
    private String rend;
    private String cssi;
    private String btsc;

}
