package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "DFME_BLLS_BELT")
@Data
public class BLLS_BELT {
    private Integer btno;
    @Id
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
