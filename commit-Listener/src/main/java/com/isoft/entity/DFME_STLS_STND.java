package com.isoft.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_STLS_STND")
@Data

public class DFME_STLS_STND {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long meta_id;
    private Long flid;//航班标识标签
    private String ffid;//航班标识
    private String fide;//航班标识
    private String fatt;//航班属性
    private Integer stls_id;
    private String stno;//机位序号
    private String code;//机位编号，如果有<STND>则M
    private String estr;//预计开始使用时间，如果有<STND>则M
    private String eend;//预计结束使用时间，如果有<STND>则M
    private String rstr;//实际开始使用时间，如果有<STND>则M
    private String rend;//实际结束时间，如果有<STND>则M
    private String cssi;//当前停放机位b标示，如果有<STND>则M
    private String btsc;//资源所属楼号，如果有<STND>则M

}
