delete
TEAM08.COMMON_META;
CREATE TABLE TEAM08.COMMON_META
(
    SNDR VARCHAR(4),            --消息发送者
    RCVR VARCHAR(4),            --消息接收者
    SEQN NUMBER(6) PRIMARY KEY, --消息序号
    DDTM VARCHAR(50),--发送时间
    TYPE VARCHAR(4),--消息类别
    STYP VARCHAR(4)             --消息类型
);
--机场变更事件（APUE）
delete
TEAM08.BASE_APUE;
drop table TEAM08.BASE_APUE;
CREATE table TEAM08.BASE_APUE
(
    id      int primary key identity(1,1),
    meta_id number(6),                                          -- 消息序号
    code    varchar(3),                                         -- 机场三字代码
    frcd    varchar(4),                                         -- 机场四字代码
    apat    varchar(4) check (apat in (2403, 2401, 2404, 2402)),-- 机场属性 2403 国内，2401 国际，2404 混合， 2402 地区
    cnnm    varchar(20),                                        -- 中文描述
    ennm    varchar(50),                                        -- 英文描述
    aiso    varchar(1),                                         --通航机场是否开启 Y/N
    apsn    varchar(10),--航班简称
    foreign key (meta_id) references TEAM08.COMMON_META (seqn)
);

--飞机信息变更事件（CFUE）
drop table TEAM08.BASE_CFUE;
create table TEAM08.BASE_CFUE
(
    id      int primary key identity(1,1),
    meta_id number(6),      -- 消息序号
    code    varchar(10),
    cftp    varchar(10),
    awcd    varchar(10),
    stnm    number(3),--最大座位数
    rstn    number(3),--可供座位数
    cfsa    varchar(20),    --航空分公司
    ttwc    numeric(10, 2),--最大起飞总重量
    mxlw    numeric(10, 2),--最大页载重量
    rllw    numeric(10, 2), --可供业载重量
    foreign key (meta_id) references TEAM08.COMMON_META (seqn)
);
--航班衔接变更消息（AFID）
delete
TEAM08.DFME_AFID;
drop table TEAM08.DFME_AFID;
create table TEAM08.DFME_AFID
(
    id      int primary key identity(1,1),
    meta_id number(6),-- 消息序号
    flid    number(12),--航班标识标签
    ffid    varchar(22) CHECK (LEN(ffid) BETWEEN 15 AND 22),--航班标识
    fide    varchar(28) CHECK (LEN(fide) BETWEEN 20 AND 28),--航班标识
    afid    number(12),--衔接航班idm
    foreign key (meta_id) references TEAM08.COMMON_META (seqn)
);

--航班航线变更消息（AIRL）
delete
TEAM08.DFME_AIRL;
drop table TEAM08.DFME_AIRL;
create table TEAM08.DFME_AIRL
(
    id      int identity(1,1),
    meta_id number(6),-- 消息序号
    flid    number(8) primary key,--航班标识标签
    ffid    varchar(22) check (LEN(ffid) BETWEEN 15 AND 22 ),--航班标识
    fide    varchar(28) check (LEN(fide) BETWEEN 20 AND 28 ),--航班标识，格式为：
    -- 航空公司二字码-航班号-计划时间（yyyyMMddHHmmss）-进出标志（A-进港，D-出港)，
    --计划时间说明：进港为本站计划降落时间，出港为本站计划起飞时间。
    foreign key (meta_id) references TEAM08.COMMON_META (seqn)
);
delete
TEAM08.DFME_AIRL_ARPT;
drop table TEAM08.DFME_AIRL_ARPT;
create table TEAM08.DFME_AIRL_ARPT
(
    id      int identity(1,1) primary key,
    apno    number(2),--航班序号
    apcd    varchar(3),--航班三字码
    fptt    varchar(50),--计划起飞时间
    fett    varchar(50), --预计起飞时间
    frtt    varchar(50),--实际起飞时间
    fplt    varchar(50),--计划降落时间
    felt    varchar(50),--预计降落时间
    frlt    varchar(50),--实际降落时间
    apat    varchar(4) check (apat in (2403, 2401, 2404, 2402)),--航班属性,机场属性 2403 国内，2401 国际，2404 混合， 2402 地区
    airl_id number(8),
    foreign key (airl_id) references TEAM08.DFME_AIRL (flid)
);

--航班到达本站消息（ARRE）
delete
TEAM08.DFME_ARRE;
drop table TEAM08.DFME_ARRE;
create table TEAM08.DFME_ARRE
(
    id      int primary key identity(1,1),
    meta_id number(6),
    flid    number(8),--航班标识标签
    ffid    varchar(22) CHECK (LEN(ffid) BETWEEN 15 AND 22),--航班标识
    fide    varchar(28) check (LEN(fide) BETWEEN 20 AND 28 ),--航班标识，格式为：
    fatt    varchar(4) check (fatt in (2403, 2401, 2404, 2402)),--机场属性 2403 国内，2401 国际，2404 混合， 2402 地区
    stat    varchar(3),--航班发布状态
    ista    varchar(3),--航班状态
    frlt    varchar(50),--实际到达时间
    msta    varchar(3),--航班发布状态，国内，国际，地区航班不使用该内容
    -- 当航班属性为混合时特指国际部分状态
    mist    varchar(3),--内部航班状态
    foreign key (meta_id) references TEAM08.COMMON_META (seqn)

);
delete
TEAM08.DFME_BLLS;
drop table TEAM08.DFME_BLLS;
--航班行李提取转盘动态信息更新（BLLS）
create table TEAM08.DFME_BLLS
(
    id      int identity(1,1) primary key,
    meta_id number(6),
    flid    number(8),--航班唯一编号
    ffid    varchar(22) CHECK (LEN(ffid) BETWEEN 15 AND 22),--航班标识
    fide    varchar(28) check (LEN(fide) BETWEEN 20 AND 28 ),--航班标识，格式为：
    fatt    varchar(4) check (fatt in (2403, 2401, 2404, 2402))--机场属性 2403 国内，2401 国际，2404 混合， 2402 地区
);
delete
TEAM08.DFME_BLLS_BELT;
drop table TEAM08.DFME_BLLS_BELT;
create table TEAM08.DFME_BLLS_BELT
(
    belt_id int primary key identity(1,1),
    btno    number(2),--行李提取转盘序号
    id      varchar(20),--行李提取转盘唯一标识
    code    varchar(7), --行李提取转盘编号
    btat    varchar(4) check (btat in (2403, 2401, 2404, 2402)),--机场属性 2403 国内，2401 国际，2404 混合， 2402 地区
    estr    varchar(50),--预计开始使用时间
    eend    varchar(50),--预计结束使用时间
    rstr    varchar(50),--实际开始使用时间
    rend    varchar(50),--实际结束使用时间
    btsc    varchar(4),--资源所属楼号，航站楼编号
    blls_id number(8)
--     exno varchar(6), --到达出口号，进港航班旅客出隔离区出口号
);


CREATE TABLE TEAM08.DFME_BORE
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
    FLID    VARCHAR,                                      --航班标识标签
    FFID    VARCHAR,                                      --航班标识
    FIDE    VARCHAR,                                      --航班标识
    FATT    VARCHAR,                                      --航班属性 2401-2404:国际,地区,国内,混合
    STAT    VARCHAR,                                      --航班发布状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
    ISTA    VARCHAR,                                      --航班状态.  当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
    BORT    VARCHAR,                                      --航班开始登机实际时间:"国内,国际,地区"航班使用;当航班属性为混合时特指国内开始登机时间
    MSTA    VARCHAR,                                      --航班发布状态:"国内,国际,地区"航班不使用该内容;当航班属性为混合时特指国际部分状态
    MIST    VARCHAR,                                      --内部航班状态:"国内,国际,地区"航班不使用该内容;当航班属性为混合时特指国际部分状态
    MBOR    VARCHAR                                       --航班开始登机实际时间:"国内,国际,地区"航班不使用;当航班属性为混合时特指国际开始登机时间
);
delete
TEAM08.DFME_CANE;
CREATE TABLE TEAM08.DFME_CANE
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
    FLID    VARCHAR,                                      --航班标识标签
    FFID    VARCHAR,                                      --航班标识
    FIDE    VARCHAR,                                      --航班标识
    FATT    VARCHAR,                                      --航班属性 2401-2404:国际,地区,国内,混合
    ABST    VARCHAR,                                      --航班不正常状态.
    IAST    VARCHAR,                                      --内部航班不正常状态.
    ABRS    VARCHAR,                                      --航班发布不正常原因. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布不正常原因
    IARS    VARCHAR,                                      --内部航班不正常原因. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布不正常原因
    MABS    VARCHAR,                                      --航班发布不正常状态2. 国内、国际、地区航班不使用该内容;当航班属性为混合时特指国际部分状态
    MABR    VARCHAR,                                      --航班发布不正常原因2. 国内、国际、地区航班不使用该内容;当航班属性为混合时特指国际部分状态
    MIAS    VARCHAR,                                      --内部航班不正常状态2. 国内、国际、地区航班不使用该内容;当航班属性为混合时特指国际部分状态
    MIAR    VARCHAR                                       --内部航班发布不正常原因2. 国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际部分不正常原因
);
delete
TEAM08.DFME_CFCE;
CREATE TABLE TEAM08.DFME_CFCE
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
    FLID    VARCHAR,                                      --航班标识标签
    FFID    VARCHAR,                                      --航班标识
    FIDE    VARCHAR,                                      --航班标识
    CFTP    VARCHAR,                                      --机型代码
    CFNO    VARCHAR                                       --机号代码
);
CREATE TABLE TEAM08.DFME_CKIE
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
    FLID    VARCHAR,                                      --航班标识标签
    FFID    VARCHAR,                                      --航班标识
    FIDE    VARCHAR,                                      --航班标识
    FATT    VARCHAR,                                      --航班属性 2401-2404:国际,地区,国内,混合
    STAT    VARCHAR,                                      --航班发布状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
    ISTA    VARCHAR,                                      --航班状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
    FCRS    VARCHAR,                                      --航班旅客值机实际开始时间1. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内旅客值机时间
    MSTA    VARCHAR,                                      --航班发布状态2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际部分状态
    MIST    VARCHAR,                                      --内部航班状态2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际部分状态
    MCRS    VARCHAR                                       --航班旅客值机实际开始时间2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际旅客值机时间
);
CREATE TABLE TEAM08.DFME_CKLS_CNTR
(
    CNTR_ID INT PRIMARY KEY IDENTITY(1,1),
    CKNO    VARCHAR,  --值机柜台序号,用于表示航班的多个值机柜台序号
    ID      NUMBER(6),--值机柜台唯一标识
    CODE    VARCHAR,  --值机柜台编号,实际资源的标识符
    CKAT    VARCHAR,  --值机柜台属性,2401-2404:国际,地区,国内,混合
    TYPE    VARCHAR,  --柜台类型
    CCAR    VARCHAR,  --值机柜台所属值机岛号标签
    ESTR    VARCHAR,  --预计开始使用时间
    EEND    VARCHAR,  --预计结束使用时间
    RSTR    VARCHAR,  --实际开始使用时间
    REND    VARCHAR,  --实际结束使用时间
    BTSC    VARCHAR,  --资源所属楼号/航站楼编号
    DFLT_ID NUMBER(6)
);
drop table TEAM08.DFME_CKLS;
CREATE TABLE TEAM08.DFME_CKLS
(
    ID      INT IDENTITY(1,1) PRIMARY KEY,
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
    FLID    NUMBER(6),                                    --航班标识标签
    FFID    VARCHAR,                                      --航班标识
    FIDE    VARCHAR,                                      --航班标识
    FATT    VARCHAR,                                      --航班属性 2401-2404:国际,地区,国内,混合
    FCES    VARCHAR,                                      --航班旅客值机预计开始时间1. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内旅客值机时间
    FCEE    VARCHAR,                                      --航班旅客值机预计结束时间1. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内旅客值机时间
    FCRS    VARCHAR,                                      --航班旅客值机实际开始时间1. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内旅客值机时间
    FCRE    VARCHAR,                                      --航班旅客值机实际结束时间1. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内旅客值机时间
    MCES    VARCHAR,                                      --航班旅客值机预计开始时间2. "国内、国际、地区"航班不使用该内容;当航班属性为混合时特指国际旅客值机时间
    MCEE    VARCHAR,                                      --航班旅客值机预计开始时间2. "国内、国际、地区"航班不使用该内容;当航班属性为混合时特指国际旅客值机时间
    MCRS    VARCHAR,                                      --航班旅客值机实际开始时间2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际旅客值机时间
    MCRE    VARCHAR,                                      --航班旅客值机实际结束时间2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际旅客值机时间
    FCDP    VARCHAR,                                      --值机柜台及值机柜台区域显示1. 当航班属性为"国内、国际、地区"时使用，当航班属性为混合时特指国内旅客显示(按照集合的方式显示)
    MCDP    VARCHAR                                       --值机柜台及值机柜台区域显示2. "国内、国际、地区"航班不使用该内容当航班属性为混合时特指国际旅客显示(按照集合的方式显示值机柜台)
);

CREATE TABLE TEAM08.DFME_CKOE
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
    FLID    VARCHAR,                                      --航班标识标签
    FFID    VARCHAR,                                      --航班标识
    FIDE    VARCHAR,                                      --航班标识
    FATT    VARCHAR,                                      --航班属性 2401-2404:国际,地区,国内,混合
    STAT    VARCHAR,                                      --航班发布状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
    ISTA    VARCHAR,                                      --航班状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
    FCRE    VARCHAR,                                      --航班旅客值机实际结束时间1. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内旅客值机时间
    MSTA    VARCHAR,                                      --航班发布状态2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际部分状态
    MIST    VARCHAR,                                      --内部航班状态2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际部分状态
    MCRE    VARCHAR                                       --航班旅客值机实际开始时间2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际旅客值机时间
);


CREATE TABLE TEAM08.DFME_DEPE
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META
    FLID    VARCHAR,--航班标识标签
    FATT    VARCHAR,--航班属性
    FFID    VARCHAR,--航班标识
    FIDE    VARCHAR,--航班标识
    STAT    VARCHAR,--航班发布动态
    ISTA    VARCHAR,--航班状态
    MSTA    VARCHAR,--航班发布状态
    MIST    VARCHAR,--内部航班状态2
    FRTT    VARCHAR--实际起飞时间
);

CREATE TABLE TEAM08.DFME_DLYE
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),
    FLID    VARCHAR,--航班标识标签
    FFID    VARCHAR,--航班标识
    FIDE    VARCHAR,--航班标识
    FATT    VARCHAR,--航班属性
    ABST    VARCHAR,--航班不正常状态
    IAST    VARCHAR,--内部航班不正常状态
    ABRS    VARCHAR,--航班发布不正常原因
    IARS    VARCHAR,--内部航班不正常原因
    MABS    VARCHAR,--航班发布不正常状态2
    MABR    VARCHAR,--航班发布不正常原因2
    MIAS    VARCHAR,--内部航班不正常状态 2
    MIAR    VARCHAR,--内部航班不正常原因 2
    FETT    VARCHAR--航班预计时间
);

CREATE TABLE TEAM08.DFME_FETT
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),
    FLID    VARCHAR,--航班标识标签
    FFID    VARCHAR,--航班标识
    FIDE    VARCHAR,--航班标识
    FETT    VARCHAR,--航班预计时间
    FELT    VARCHAR--预计到达时间
);

CREATE TABLE TEAM08.DFME_FPTT
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),
    FLID    VARCHAR,--航班标识标签
    FFID    VARCHAR,--航班标识
    FIDE    VARCHAR,--航班标识
    FPTT    VARCHAR,--计划起飞时间
    FPLT    VARCHAR--计划降落时间
);

CREATE TABLE TEAM08.DFME_FRTT
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),
    FLID    VARCHAR,--航班标识标签
    FFID    VARCHAR,--航班标识
    FIDE    VARCHAR,--航班标识
    FRTT    VARCHAR,--实际起飞时间
    FRLT    VARCHAR--实际到达时间
);
drop table TEAM08.DFME_GTLS_GATE;
CREATE TABLE TEAM08.DFME_GTLS_GATE
(
    gate_ID INT IDENTITY(1,1) PRIMARY KEY,
    GTNO    VARCHAR,--登机门序号如果有<GATE>则 M
    ID      NUMBER(6),--登机门唯一标识
    CODE    VARCHAR,--登机门编号,如果有<GATE>则 M
    GTAT    VARCHAR,--登机门属性
    ESTR    VARCHAR,--预计开始使用时 间 , 如 果 有<GATE>则 M
    EEND    VARCHAR,--预计结束使用时 间 , 如 果 有<GATE>则 M
    RSTR    VARCHAR,--实际开始使用时 间 , 如 果 有<GATE>则 M
    REND    VARCHAR,--实际结束使用时 间 , 如 果 有<GATE>则 M
    BTSC    VARCHAR,--资源所属楼号,如 果 有 <GATE>则 M
    DFLT_ID NUMBER(6)
);
drop table TEAM08.DFME_GTLS;
CREATE TABLE TEAM08.DFME_GTLS
(
    ID      INT IDENTITY(1,1) PRIMARY KEY,
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),
    FLID    NUMBER(6),--航班标识标签
    FFID    VARCHAR,--航班标识
    FIDE    VARCHAR,--航班标识
    FATT    VARCHAR--航班属性
);



drop table TEAM08.DFME_LBDE;

--航班催促登机消息（LBDE）
CREATE TABLE TEAM08.DFME_LBDE
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
    FLID    NUMBER,                                       -- 航班标识标签
    FFID    VARCHAR,                                      --航班标识
    FIDE    VARCHAR,                                      --航班标识
    FATT    VARCHAR,                                      --航班属性 2401-2404:国际,地区,国内,混合
    STAT    VARCHAR,                                      --航班发布状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
    ISTA    VARCHAR,                                      --航班状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
    LBDT    VARCHAR,                                      --当航班属性为国内、国际、地区时使用,当航班属性为混合时特指国内催促登机时间
    MSTA    VARCHAR,                                      --航班发布状态2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际部分状态
    MIST    VARCHAR,                                      --内部航班状态2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际部分状态
    MLBD    VARCHAR                                       --国内、国际、地区航班不使用该内容,当航班属性为混合时特指国际催促登机时间
);

--航班前站起飞消息（ONRE）
CREATE TABLE TEAM08.DFME_ONRE
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
    FLID    NUMBER,                                       -- 航班标识标签
    FFID    VARCHAR,                                      --航班标识
    FIDE    VARCHAR,                                      --航班标识
    FATT    VARCHAR,                                      --航班属性 2401-2404:国际,地区,国内,混合
    STAT    VARCHAR,                                      --航班发布状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
    ISTA    VARCHAR,                                      --航班状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
    MSTA    VARCHAR,                                      --航班发布状态 2M  国内、国际、地区航班不使用该内容
    MIST    VARCHAR,                                      --内部航班状态 2M  国内、国际、地区航班不使用该内容,当航班属性为混合时特指国际部分状态
    PAST    VARCHAR,                                      --前站实际起飞时间M
    ELDT    VARCHAR                                       --本站预计降落时间
);


--航班结束登机消息（POKE)
CREATE TABLE TEAM08.DFME_POKE
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
    FLID    NUMBER,                                       -- 航班标识标签
    FFID    VARCHAR,                                      --航班标识
    FIDE    VARCHAR,                                      --航班标识
    FATT    VARCHAR,                                      --航班属性 2401-2404:国际,地区,国内,混合
    STAT    VARCHAR,                                      --航班发布状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
    ISTA    VARCHAR,                                      --航班状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
    POKT    VARCHAR,                                      --航班结束登机实际时间   当航班属性为国内、国际、地区时使用，当航班属为混合时特指国内结束登机时间
    MSTA    VARCHAR,                                      --航班发布状态 2M  国内、国际、地区航班不使用该内容
    MIST    VARCHAR,                                      --内部航班状态 2M  国内、国际、地区航班不使用该内容,当航班属性为混合时特指国际部分状态
    MPOK    VARCHAR                                       -- 航班结束登机实际时间     国内、国际、地区航班不使用该内容,当航班属性为混合时特指国际结束登机时间
);

--航班机位动态信息更新（STLS)
CREATE TABLE TEAM08.DFME_STLS
(
    ID      INT IDENTITY(1,1) PRIMARY KEY,
    META_ID NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
    FLID    VARCHAR,                                      -- 航班标识标签
    FFID    VARCHAR,                                      --航班标识
    FIDE    VARCHAR,                                      --航班标识
    FATT    VARCHAR                                       --航班属性 2401-2404:国际,地区,国内,混合
);

DROP TABLE TEAM08.DFME_STLS_STND;
CREATE TABLE TEAM08.DFME_STLS_STND
(
    ID      INT PRIMARY KEY IDENTITY(1,1),
    STLS_ID VARCHAR,
    STNO    NUMBER,  --机位序号     STNO 用于标识航班的多个机位。该序号代表了机位的占用顺序。
    CODE    VARCHAR, --值机柜台编号,实际资源的标识符
    ESTR    VARCHAR, --预计开始使用时间
    EEND    VARCHAR, --预计结束使用时间
    RSTR    VARCHAR, --实际开始使用时间
    REND    VARCHAR, --实际结束使用时间
    CSSI    VARCHAR, --当前停放机位标识    Y 标示当前即停放此机位，为空表示不在当前机位上
    BTSC    VARCHAR--资源所属楼号
);
