package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_BLLS_BELT")
@Data
public class BLLS_BELT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer belt_id;
    private Integer btno;
    private Long meta_id;
    private Long id;
    private String code;
    private String btat;
    private String estr;
    private String eend;
    private String rstr;
    private String rend;
    private String btsc;
    private String exno;
    private Long blls_id;
}
