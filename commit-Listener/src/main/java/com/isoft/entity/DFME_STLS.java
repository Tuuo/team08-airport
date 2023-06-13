package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "DFME_STLS")
@Data
public class DFME_STLS {
    @Id
    private Integer id;
    private Long meta_id;
    private Long flid;
    private String ffid;
    private String fide;
    private String fatt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMeta_id() {
        return meta_id;
    }

    public void setMeta_id(Long meta_id) {
        this.meta_id = meta_id;
    }

    public Long getFlid() {
        return flid;
    }

    public void setFlid(Long flid) {
        this.flid = flid;
    }

    public String getFfid() {
        return ffid;
    }

    public void setFfid(String ffid) {
        this.ffid = ffid;
    }

    public String getFide() {
        return fide;
    }

    public void setFide(String fide) {
        this.fide = fide;
    }

    public String getFatt() {
        return fatt;
    }

    public void setFatt(String fatt) {
        this.fatt = fatt;
    }
}
