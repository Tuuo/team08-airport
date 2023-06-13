package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "DFME_AIRL")
@Data
public class AIRL_Dflt {

    private Integer id;
    private Long meta_id;
    @Id
    private Long flid;
    private String fide;
    private String ffid;
}
