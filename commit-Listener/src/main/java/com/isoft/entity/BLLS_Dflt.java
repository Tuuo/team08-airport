package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name = "DFME_BLLS")
@Data
public class BLLS_Dflt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long meta_id;
    private Long flid;
    private String ffid;
    private String fide;
    private String fatt;
}
