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
    private Long meta_id; //消息序号
    private String code;//机场三字代码
    private String frcd;//机场四字代码
    private String apat;
    private String cnnm;
    private String ennm;
    private String aiso;
    private String apsn;

}
