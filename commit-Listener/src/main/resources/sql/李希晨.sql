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
	SFLG VARCHAR,
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
