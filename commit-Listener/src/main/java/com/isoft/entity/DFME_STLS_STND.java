package com.isoft.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "DFME_STLS_STND")
@Data

public class DFME_STLS_STND {
    @Id
    private Integer id;
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
