package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_FRTT")
@Data
public class Dflt_Frtt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long meta_id;
    private String flid;
    private String ffid;
    private String fide;
    private String frtt;
    private String frlt;
}
