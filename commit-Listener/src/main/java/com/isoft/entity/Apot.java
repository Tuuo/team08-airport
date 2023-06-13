package com.isoft.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "BASE_APUE")
@Data
public class Apot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long meta_id;
    private String code;
    private String frcd;
    private String apat;
    private String cnnm;
    private String ennm;
    private String aiso;
    private String apsn;

}
