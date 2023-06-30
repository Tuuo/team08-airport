package com.isoft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DFOE_DFDL_ARPT")
@Data
public class Dflt_Dfdl_Arpt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long meta_id;
    private Long flid;
    private String afid;//失联航班ID
    private String ffid;//航班标识
    private String fide;//航班标识
    private String test;
    private String awcd;//航空公司二字码
    private String flno;//航班号
    private String fexd;//航班执行日期
    private String fimd;//航班所属计划批次的标识日期
    private String flio;//航班进出标识
    private String fltk;//航班任务
    private String fatt;//航班属性
    private String patt;//航班属性旧值
    private String mfid;//主航班标识
    private String mffi;//主航班标识
    private String cftp;//机型
    private String cfno;//机号
    private String stat;//航班发布状态
    private String abst;//航班发布不正常状态
    private String abrs;//航班发布不正常原因
    private String ista;//航班状态
    private String iast;//内部航班不正常状态
    private String iars;//内部航班不正常原因
    private String msta;//航班发布状态2
    private String mabs;//航班发布不正常状态2
    private String mabr;//航班发布不正常原因
    private String mist;//内部航班状态2
    private String mias;//内部航班不正常状态2
    private String miar;//内部航班不正常原因2
    private String bort;//航班开始登机实际时间
    private String mbor;//航班开始登机实际时间
    private String tbrt;//航班过站登机实际时间
    private String mtbr;//航班过站登机实际时间
    private String lbdt;//航班催促登机实际时间
    private String mlbd;//航班催促登机实际时间
    private String pokt;//航班结束登机实际时间
    private String mpok;//航班结束登机实际时间
    private String apot;//备降航站
    private String dett;//备降预计起飞时间
    private String drtt;//备降实际起飞时间
    private String delt;//备降预计降落时间
    private String drlt;//备降实际降落时间
    private String vip;//VIP人数
    private String sfaw;//共享航空公司二字码
    private String sfno;//共享航班号
    private String past;//前站实际起飞时间
    private String gtls;//航班登机门动态信息标签
    private String blls;//航班行李提取转盘动态信息标签
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
    private String chls;//航班行李滑槽动态更新信息标签
    private String stls;//航班机位动态更新信息标签
    private String nmcd;//国内航站楼编号
    private String jmcd;//国际航展楼编号
    private String fldt;//第一件行李上架时间
    private String lldt;//最后一件行李上架时间
    private String cont;//起降架次
    private String prox;//航班代理

    private String apno;//航站序号
    private String apcd;//航站三字码
    private String fptt;//计划起飞时间
    private String fett;//预计起飞时间
    private String frtt;//实际起飞时间
    private String fplt;//计划降落时间
    private String felt;//预计降落时间
    private String frlt;//实际降落时间
    private String apat;//航站属性
    private Long dflt_id;
}
