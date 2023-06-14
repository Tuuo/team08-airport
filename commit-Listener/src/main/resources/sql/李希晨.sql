CREATE TABLE TEAM08.COMMON_META(
    SNDR VARCHAR(4), --消息发送者
    RCVR VARCHAR(4), --消息接收者
    SEQN NUMBER(6) PRIMARY KEY, --消息序号
    DDTM VARCHAR(50),--发送时间
    TYPE VARCHAR(4),--消息类别
    STYP VARCHAR(4) --消息类型
);

CREATE TABLE TEAM08.DFME_BORE(
	ID INT PRIMARY KEY IDENTITY(1,1),
	META_ID	NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
	FLID VARCHAR, --航班标识标签
	FFID VARCHAR, --航班标识
	FIDE VARCHAR, --航班标识
	FATT VARCHAR, --航班属性 2401-2404:国际,地区,国内,混合
	STAT VARCHAR, --航班发布状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
	ISTA VARCHAR, --航班状态.  当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
	BORT VARCHAR,    --航班开始登机实际时间:"国内,国际,地区"航班使用;当航班属性为混合时特指国内开始登机时间
	MSTA VARCHAR, --航班发布状态:"国内,国际,地区"航班不使用该内容;当航班属性为混合时特指国际部分状态
	MIST VARCHAR, --内部航班状态:"国内,国际,地区"航班不使用该内容;当航班属性为混合时特指国际部分状态
	MBOR VARCHAR    --航班开始登机实际时间:"国内,国际,地区"航班不使用;当航班属性为混合时特指国际开始登机时间
);

CREATE TABLE TEAM08.DFME_CANE(
	ID INT PRIMARY KEY IDENTITY(1,1),
	META_ID	NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
	FLID VARCHAR, --航班标识标签
	FFID VARCHAR, --航班标识
	FIDE VARCHAR, --航班标识
	FATT VARCHAR, --航班属性 2401-2404:国际,地区,国内,混合
	ABST VARCHAR, --航班不正常状态. 
	IAST VARCHAR, --内部航班不正常状态. 
	ABRS VARCHAR, --航班发布不正常原因. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布不正常原因
	IARS VARCHAR, --内部航班不正常原因. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布不正常原因
	MABS VARCHAR, --航班发布不正常状态2. 国内、国际、地区航班不使用该内容;当航班属性为混合时特指国际部分状态
	MABR VARCHAR, --航班发布不正常原因2. 国内、国际、地区航班不使用该内容;当航班属性为混合时特指国际部分状态
	MIAS VARCHAR, --内部航班不正常状态2. 国内、国际、地区航班不使用该内容;当航班属性为混合时特指国际部分状态
	MIAR VARCHAR --内部航班发布不正常原因2. 国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际部分不正常原因
);
CREATE TABLE TEAM08.DFME_CFCE(
	ID INT PRIMARY KEY IDENTITY(1,1),
	META_ID	NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
	FLID VARCHAR, --航班标识标签
	FFID VARCHAR, --航班标识
	FIDE VARCHAR, --航班标识
	CFTP VARCHAR, --机型代码
	CFNO VARCHAR --机号代码
);
CREATE TABLE TEAM08.DFME_CKIE(
	ID INT PRIMARY KEY IDENTITY(1,1),
	META_ID	NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
	FLID VARCHAR, --航班标识标签
	FFID VARCHAR, --航班标识
	FIDE VARCHAR, --航班标识
	FATT VARCHAR, --航班属性 2401-2404:国际,地区,国内,混合
	STAT VARCHAR, --航班发布状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
	ISTA VARCHAR, --航班状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
	FCRS VARCHAR, --航班旅客值机实际开始时间1. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内旅客值机时间
	MSTA VARCHAR, --航班发布状态2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际部分状态
	MIST VARCHAR, --内部航班状态2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际部分状态
	MCRS VARCHAR --航班旅客值机实际开始时间2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际旅客值机时间
);
CREATE TABLE TEAM08.DFME_CKLS_CNTR(
	CKNO VARCHAR, --值机柜台序号,用于表示航班的多个值机柜台序号
	ID NUMBER(6) PRIMARY KEY,--值机柜台唯一标识
	CODE VARCHAR, --值机柜台编号,实际资源的标识符
	CKAT VARCHAR, --值机柜台属性,2401-2404:国际,地区,国内,混合
	TYPE VARCHAR, --柜台类型
	CCAR VARCHAR, --值机柜台所属值机岛号标签
	ESTR VARCHAR, --预计开始使用时间
	EEND VARCHAR, --预计结束使用时间
	RSTR VARCHAR, --实际开始使用时间
	REND VARCHAR, --实际结束使用时间
	BTSC VARCHAR, --资源所属楼号/航站楼编号
	DFLT_ID NUMBER(6) REFERENCES TEAM08.DFME_CKLS(FLID)
);
drop table TEAM08.DFME_CKLS;
CREATE TABLE TEAM08.DFME_CKLS(
	ID INT  IDENTITY(1,1),
	META_ID	NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
	FLID NUMBER(6) PRIMARY KEY, --航班标识标签
	FFID VARCHAR, --航班标识
	FIDE VARCHAR, --航班标识
	FATT VARCHAR, --航班属性 2401-2404:国际,地区,国内,混合
	FCES VARCHAR, --航班旅客值机预计开始时间1. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内旅客值机时间
	FCEE VARCHAR, --航班旅客值机预计结束时间1. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内旅客值机时间
	FCRS VARCHAR, --航班旅客值机实际开始时间1. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内旅客值机时间
	FCRE VARCHAR, --航班旅客值机实际结束时间1. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内旅客值机时间
	MCES VARCHAR, --航班旅客值机预计开始时间2. "国内、国际、地区"航班不使用该内容;当航班属性为混合时特指国际旅客值机时间
	MCEE VARCHAR, --航班旅客值机预计开始时间2. "国内、国际、地区"航班不使用该内容;当航班属性为混合时特指国际旅客值机时间
	MCRS VARCHAR, --航班旅客值机实际开始时间2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际旅客值机时间
	MCRE VARCHAR, --航班旅客值机实际结束时间2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际旅客值机时间
	FCDP VARCHAR, --值机柜台及值机柜台区域显示1. 当航班属性为"国内、国际、地区"时使用，当航班属性为混合时特指国内旅客显示(按照集合的方式显示) 
	MCDP VARCHAR --值机柜台及值机柜台区域显示2. "国内、国际、地区"航班不使用该内容当航班属性为混合时特指国际旅客显示(按照集合的方式显示值机柜台)
);

CREATE TABLE TEAM08.DFME_CKOE(
	ID INT PRIMARY KEY IDENTITY(1,1),
	META_ID	NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
	FLID VARCHAR, --航班标识标签
	FFID VARCHAR, --航班标识
	FIDE VARCHAR, --航班标识
	FATT VARCHAR, --航班属性 2401-2404:国际,地区,国内,混合
	STAT VARCHAR, --航班发布状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
	ISTA VARCHAR, --航班状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
	FCRE VARCHAR, --航班旅客值机实际结束时间1. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内旅客值机时间
	MSTA VARCHAR, --航班发布状态2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际部分状态
	MIST VARCHAR, --内部航班状态2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际部分状态
	MCRE VARCHAR --航班旅客值机实际开始时间2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际旅客值机时间
);


--补充的表
drop table TEAM08.DFOE_DFIE;
CREATE TABLE TEAM08.DFOE_DFIE(
	ID INT IDENTITY(1,1),
	META_ID	NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
	FLID NUMBER(6) PRIMARY KEY,--航班唯一编号
	AFID VARCHAR,--关联航班ID
	FFID VARCHAR,--航班标识
	FIDE VARCHAR,--航班标识
	TEST VARCHAR,
	AWCD VARCHAR,--航空公司二字码
	FLNO VARCHAR,--航班号
	FEXD VARCHAR,--航班执行日期，进港航班的计划降落时间里面的日期，出港航班的计划起飞时间里面的日期
	FIMD VARCHAR,--航班所属计划批次的标识日期
	FLIO VARCHAR,--航班进出标志，A-进港；D-出港
	FLTK VARCHAR,--航班任务
	FATT VARCHAR,--航班属性，（2403，2401，2404，2402），2403国内，2401国际，2404混合，2402地区
	PATT VARCHAR,--航班属性旧值，（2403，2401，2404，2402），2403国内，2401国际，2404混合，2402地区
	MFID VARCHAR,--主航班标识，虚拟航班主航班和独立航班此值为空，虚拟附属航班有值，代表此虚拟航班所挂靠的执行航班。
	MFFI VARCHAR,--主航班标识，如果有<DFLT>
	CFTP VARCHAR,--机型，国际民用航空组织指定代码ICAO
	CFNO VARCHAR,--机号
	STAT VARCHAR,--航班发布状态，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内部分状态
	ABST VARCHAR,--航班发布不正常状态，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内部分状态
	ABRS VARCHAR,--航班发布不正常原因，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内部分发布不正常原因
	ISTA VARCHAR,--内部航班状态，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内部分状态
	IAST VARCHAR,--内部航班不正常状态，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内部分状态
	IARS VARCHAR,--内部航班不正常原因，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内部分不正常原因
	MSTA VARCHAR,--航班发布状态2，国内、国际、地区航班不使用该内容
	MABS VARCHAR,--航班发布不正常状态2，国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际部分状态
	MABR VARCHAR,--航班发布不正常原因2，国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际部分不正常原因
	MIST VARCHAR,
	MIAS VARCHAR,--内部航班不正常状态2，国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际部分不正常原因
	MIAR VARCHAR,--内部航班不正常状态2，国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际部分不正常原因
	BORT VARCHAR,--航班开始登机实际时间，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内开始登机时间
	MBOR VARCHAR,--航班开始登机实际时间，国内、国际、地区时不使用该内容，当航班属性为混合时特指国际开始登机时间
	TBRT VARCHAR,--航班过站登机，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内过站机时间
	MTBR VARCHAR,--航班过站登机时间，国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际过站登机时间
	LBDT VARCHAR,--航班催促登机实际时间，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内催促登机时间
	MLBD VARCHAR,--航班催促登机实际时间，国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际催促登机时间
	POKT VARCHAR,--航班结束登机实际时间，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内结束登机时间
	MPOK VARCHAR,--航班结束登机实际时间，国内、国际、地区不使用该内容，当航班属性为混合时特指国际结束登机时间
	APOT VARCHAR,--备降航站
	DETT VARCHAR,--备降预计起飞时间，如果有<APOT>
	DRTT VARCHAR,--备降实际起飞时间，如果有<APOT>
	DELT VARCHAR,--备降预计降落时间，如果有<APOT>
	DRLT VARCHAR,--备降实际降落时间，如果有<APOT>
	VIP VARCHAR,--VIP人数，如果该标签值为0，表示无VIP，大于0则表示有VIP，由于机场业务操作原因，可能导致该标签表示VIP人数不准确
	SFLG VARCHAR,--共享航班组标签
	PAST VARCHAR,--前站实际起飞时间
	GTLS VARCHAR,--航班登机门动态信息标签
	BLLS VARCHAR,--航班行李提取转盘动态信息标签
	FCES VARCHAR,--航班旅客值机预计开始时间1，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内旅客值机时间
	FCEE VARCHAR,--航班旅客值机预计结束时间1，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内旅客值机时间
	FCRS VARCHAR,--航班旅客值机实际开始时间1，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内旅客值机时间
	FCRE VARCHAR,--航班旅客值机实际结束时间1，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内旅客值机时间
	MCES VARCHAR,--航班旅客值机预计开始时间2，国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际旅客值机时间
	MCEE VARCHAR,--航班旅客值机预计结束时间2，国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际旅客值机时间
	MCRS VARCHAR,--航班旅客值机实际开始时间2，国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际旅客值机时间
	MCRE VARCHAR,--航班旅客值机实际结束时间2，国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际旅客值机时间
	FCDP VARCHAR,--值机柜台及值机柜台区域显示1，当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内旅客显示（按照集合的方式显示值机柜台）
	MCDP VARCHAR,
	CHLS VARCHAR,
	STLS VARCHAR,
	NMCD VARCHAR,
	JMCD VARCHAR,
	FLDT VARCHAR,
	LLDT VARCHAR,
	CONT VARCHAR,
	PROX VARCHAR
);
drop table TEAM08.DFOE_DFIE_ARPT;
CREATE TABLE TEAM08.DFOE_DFIE_ARPT(
	ID INT PRIMARY KEY IDENTITY(1,1),
	APNO VARCHAR,
	APCD VARCHAR,
	FPTT VARCHAR,
	FETT VARCHAR,
	FRTT VARCHAR,
	FPLT VARCHAR,
	FELT VARCHAR,
	FRLT VARCHAR,
	APAT VARCHAR,
	DFLT_ID NUMBER(6) REFERENCES TEAM08.DFOE_DFIE(FLID)
);

drop table TEAM08.DFOE_DFDL;
CREATE TABLE TEAM08.DFOE_DFDL(
	ID INT IDENTITY(1,1),
	META_ID	NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
	FLID NUMBER(6) PRIMARY KEY,
	AFID VARCHAR,
	FFID VARCHAR,
	FIDE VARCHAR,
	TEST VARCHAR,
	AWCD VARCHAR,
	FLNO VARCHAR,
	FEXD VARCHAR,
	FIMD VARCHAR,
	FLIO VARCHAR,
	FLTK VARCHAR,
	FATT VARCHAR,
	PATT VARCHAR,
	MFID VARCHAR,
	MFFI VARCHAR,
	CFTP VARCHAR,
	CFNO VARCHAR,
	STAT VARCHAR,
	ABST VARCHAR,
	ABRS VARCHAR,
	ISTA VARCHAR,
	IAST VARCHAR,
	IARS VARCHAR,
	MSTA VARCHAR,
	MABS VARCHAR,
	MABR VARCHAR,
	MIST VARCHAR,
	MIAS VARCHAR,
	MIAR VARCHAR,
	BORT VARCHAR,
	MBOR VARCHAR,
	TBRT VARCHAR,
	MTBR VARCHAR,
	LBDT VARCHAR,
	MLBD VARCHAR,
	POKT VARCHAR,
	MPOK VARCHAR,
	APOT VARCHAR,
	DETT VARCHAR,
	DRTT VARCHAR,
	DELT VARCHAR,
	DRLT VARCHAR,
	VIP VARCHAR,
	SFAW VARCHAR,
	SFNO VARCHAR,
	PAST VARCHAR,
	GTLS VARCHAR,
	BLLS VARCHAR,
	FCES VARCHAR,
	FCEE VARCHAR,
	FCRS VARCHAR,
	FCRE VARCHAR,
	MCES VARCHAR,
	MCEE VARCHAR,
	MCRS VARCHAR,
	MCRE VARCHAR,
	FCDP VARCHAR,
	MCDP VARCHAR,
	CHLS VARCHAR,
	STLS VARCHAR,
	NMCD VARCHAR,
	JMCD VARCHAR,
	FLDT VARCHAR,
	LLDT VARCHAR,
	CONT VARCHAR,
	PROX VARCHAR
);

drop table TEAM08.DFOE_DFDL_ARPT;
CREATE TABLE TEAM08.DFOE_DFDL_ARPT(
	ID INT PRIMARY KEY IDENTITY(1,1),
	APNO VARCHAR,
	APCD VARCHAR,
	FPTT VARCHAR,
	FETT VARCHAR,
	FRTT VARCHAR,
	FPLT VARCHAR,
	FELT VARCHAR,
	FRLT VARCHAR,
	APAT VARCHAR,
	DFLT_ID NUMBER(6) REFERENCES TEAM08.DFOE_DFDL(FLID)
);
