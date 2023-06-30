package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFME_CKLS_CNTR")
@Data
public class Dflt_Ckls_Cntr {
    @Id
    private Integer cntr_id;
    private Long meta_id;
    private Long flid;//航班标识标签
    private String ffid;//航班标识
    private String fide;//航班标识
    private String fatt;//航班属性
    private String fces;//航班旅客值机预计开始时间1
    private String fcee;//航班旅客值机预计结束时间1
    private String fcrs;//航班旅客值机实际开始时间1
    private String fcre;//航班旅客值机实际结束时间1
    private String mces;//航班旅客值机预计开始时间2
    private String mcee;//航班旅客值机预计结束时间2
    private String mcrs;//航班旅客值机实际开始时间2
    private String mcre;//航班旅客值机实际结束时间2
    private String fcdp;//值机柜台及值机柜台区域显示1
    private String mcdp;//值机柜台及值机柜台区域显示2
    private String ckno;//值机柜台序号
    private Long id;//值机柜台唯一标识
    private String code;//值机柜台编号
    private String ckat;//值机柜台属性
    private String type;//柜台类型
    private String ccar;//值机柜台所属值机岛号标签
    private String estr;//预计开始使用时间
    private String eend;//预计结束使用时间
    private String rstr;//实际开始使用时间
    private String rend;//实际结束使用时间
    private String btsc;//资源所属楼号
    private Long dflt_id;
}
