package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "DFME_LBDE")
@Data
public class DFME_LBDE {
        @Id
        private Integer id;
        private Long meta_id;
        private Long flid;
        private String ffid;
        private String fide;
        private String fatt;
        private String stat;
        private String ista;
        private String lbdt;
        private String msta;
        private String mist;
        private String mlbd;

}



