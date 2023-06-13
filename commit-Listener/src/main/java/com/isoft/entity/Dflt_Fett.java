package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_Fett")
@Data
public class Dflt_Fett {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Long meta_id;
    private String flid;
    private String ffid;
    private String fide;
    private String fett;
    private String felt;
}
