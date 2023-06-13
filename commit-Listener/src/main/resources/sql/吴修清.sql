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