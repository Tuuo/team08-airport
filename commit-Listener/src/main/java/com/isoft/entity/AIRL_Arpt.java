package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_AIRL_ARPT")
@Data
public class AIRL_Arpt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer apno;//航站序号
    private String apcd;//航站三字码
    private String fptt;//计划起飞时间
    private String fett;//预计起飞时间
    private String frtt;//实际起飞时间
    private String fplt;//计划降落时间
    private String felt;//预计降落时间
    private String frlt;//实际降落时间
    private String apat;//航站属性
    private Integer airl_Id;
}
