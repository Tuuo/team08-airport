package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "DFME_AFID")
@Data
public class AFID_Dflt {
    @Id
    private Integer id;
    private Long meta_id;
    private Long flid;
    private String ffid;
    private String fide;
    private String afid;

}
