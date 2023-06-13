package com.isoft.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "DFME_POKE")
@Data
public class DFME_POKE {
    @Id
    private Integer id;
    private Long meta_id;
    private Long flid;
    private String ffid;
    private String fide;
    private String fatt;
    private String stat;
    private String ista;
    private String pokt;
    private String msta;
    private String mist;
    private String mpok;


}
