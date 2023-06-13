drop table TEAM08.COMMON_META;
create table TEAM08.COMMON_META(
    sndr varchar(4) ,--CHECK (COMMON_META.sndr LIKE '[0-9][a-z][A-Z]' or COMMON_META.sndr is null) , --消息发送者
    rcvr varchar(4) ,--CHECK (COMMON_META.rcvr LIKE '[0-9][a-z][A-Z]' or COMMON_META.rcvr is null), --消息接收者
    seqn number(6) , --消息序号
    ddtm varchar(50),--发送时间
    type varchar(4) ,--CHECK (COMMON_META.type LIKE '[0-9][a-z][A-Z]'),--消息类别
    styp varchar(4) ,--CHECK (COMMON_META.styp LIKE '[0-9][a-z][A-Z]'), --消息类型
    primary key (seqn)
);


drop table TEAM08.DFME_LBDE;

--航班催促登机消息（LBDE）
CREATE TABLE TEAM08.DFME_LBDE(
  ID INT PRIMARY KEY IDENTITY(1,1),
  META_ID	NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
  FLID NUMBER,       -- 航班标识标签
  FFID VARCHAR, --航班标识
  FIDE VARCHAR, --航班标识
  FATT VARCHAR, --航班属性 2401-2404:国际,地区,国内,混合
  STAT VARCHAR, --航班发布状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
  ISTA VARCHAR, --航班状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
  LBDT VARCHAR,    --当航班属性为国内、国际、地区时使用,当航班属性为混合时特指国内催促登机时间
  MSTA VARCHAR, --航班发布状态2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际部分状态
  MIST VARCHAR, --内部航班状态2. "国内、国际、地区"航班"不使用"该内容;当航班属性为混合时特指国际部分状态
  MLBD VARCHAR    --国内、国际、地区航班不使用该内容,当航班属性为混合时特指国际催促登机时间
);

--航班前站起飞消息（ONRE）
CREATE TABLE TEAM08.DFME_ONRE(
  ID INT PRIMARY KEY IDENTITY(1,1),
  META_ID	NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
  FLID NUMBER,       -- 航班标识标签
  FFID VARCHAR, --航班标识
  FIDE VARCHAR, --航班标识
  FATT VARCHAR, --航班属性 2401-2404:国际,地区,国内,混合
  STAT VARCHAR, --航班发布状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
  ISTA VARCHAR, --航班状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
  MSTA VARCHAR, --航班发布状态 2M  国内、国际、地区航班不使用该内容
  MIST VARCHAR, --内部航班状态 2M  国内、国际、地区航班不使用该内容,当航班属性为混合时特指国际部分状态
  PAST VARCHAR,    --前站实际起飞时间M  
  ELDT VARCHAR    --本站预计降落时间
);


--航班结束登机消息（POKE)
CREATE TABLE TEAM08.DFME_POKE(
  ID INT PRIMARY KEY IDENTITY(1,1),
  META_ID	NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
  FLID NUMBER,       -- 航班标识标签
  FFID VARCHAR, --航班标识
  FIDE VARCHAR, --航班标识
  FATT VARCHAR, --航班属性 2401-2404:国际,地区,国内,混合
  STAT VARCHAR, --航班发布状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
  ISTA VARCHAR, --航班状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
  POKT VARCHAR,    --航班结束登机实际时间   当航班属性为国内、国际、地区时使用，当航班属为混合时特指国内结束登机时间
  MSTA VARCHAR, --航班发布状态 2M  国内、国际、地区航班不使用该内容
  MIST VARCHAR, --内部航班状态 2M  国内、国际、地区航班不使用该内容,当航班属性为混合时特指国际部分状态
  MPOK VARCHAR    -- 航班结束登机实际时间     国内、国际、地区航班不使用该内容,当航班属性为混合时特指国际结束登机时间
);

--航班机位动态信息更新（STLS)
CREATE TABLE TEAM08.DFME_STLS(
  ID INT IDENTITY(1,1) ,
  META_ID	NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
  FLID VARCHAR  PRIMARY KEY,       -- 航班标识标签
  FFID VARCHAR, --航班标识
  FIDE VARCHAR, --航班标识
  FATT VARCHAR --航班属性 2401-2404:国际,地区,国内,混合
);  

  
 CREATE TABLE TEAM08.DFME_STLS_STND(
  ID INT  PRIMARY KEY IDENTITY(1,1),
  STLS_ID VARCHAR ,
  STNO NUMBER,  --机位序号     STNO 用于标识航班的多个机位。该序号代表了机位的占用顺序。
  CODE VARCHAR, --值机柜台编号,实际资源的标识符
  ESTR VARCHAR, --预计开始使用时间
  EEND VARCHAR, --预计结束使用时间
  RSTR VARCHAR, --实际开始使用时间
  REND VARCHAR, --实际结束使用时间
  CSSI VARCHAR, --当前停放机位标识    Y 标示当前即停放此机位，为空表示不在当前机位上
  BTSC VARCHAR, --资源所属楼号
  foreign key (STLS_ID) references TEAM08.DFME_STLS(FLID)
 
);


--动态航班整表同步事件（DFDL)
CREATE TABLE TEAM08.DFOE_DFDL(
  ID INT PRIMARY KEY IDENTITY(1,1),
  MEAT_ID	NUMBER(6) REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
  RECD NUMBER,       --传送航班总数  没有航班时，数值为 0
  FLID NUMBER,       --航班标识标签
  AFID NUMBER,       --衔接航班ID
  FFID VARCHAR,      --航班标识
  FIDE VARCHAR,      --航班标识
  AWCD VARCHAR,      --航空公司二字码
  FLNO NUMBER,       --航班号
  FEXD DATE,         --航班执行日期
  FIMD DATE,         --航班所属计划批次的标识日期
  FLIO VARCHAR,      --航班进出标志
  FLTK VARCHAR,      --航班任务 
  FATT NUMBER,       --航班属性
  
--  继DFIE
);

--航班动态增加信息（DFIE）
CREATE TABLE TEAM08.DFOE_DFIE(
  ID INT PRIMARY KEY IDENTITY(1,1),
  MEAT_ID	NUMBER REFERENCES TEAM08.COMMON_META(SEQN),--关联META表
  RECD NUMBER,       --传送航班总数  没有航班时，数值为 0
  FLID NUMBER,       --航班标识标签
  AFID NUMBER,       --衔接航班ID
  FFID VARCHAR,      --航班标识
  FIDE VARCHAR,      --航班标识
);  

CREATE TABLE TEAM08.DFOE_DFIE_FIDE(
  ID NUMBER PRIMARY KEY IDENTITY(1,1),
  AWCD VARCHAR,      --航空公司二字码
  FLNO NUMBER,       --航班号
  FEXD DATE,         --航班执行日期
  FIMD DATE,         --航班所属计划批次的标识日期
  FLIO VARCHAR,      --航班进出标志
  FLTK VARCHAR,      --航班任务 
  FATT NUMBER,       --航班属性
  PATT NUMBER,       --航班属性旧值   2403 国内2401 国际2404 混合2402 地区航班属性变更前的值，在增加航班时，此标签值为空。
  MFID VARCHAR,      --主航班标识   虚拟航班主航班和独立航班此值为空，虚拟附属航班有值，代表此虚拟航班所挂靠的执行航班。
  MFFI VARCHAR,      --主航班标识
);


  CONT VARCHAR,      --起降架次
  PROX VARCHAR,      --航班代理
  CFTP VARCHAR,      --机型
  CFNO VARCHAR,      --机号
  STAT VARCHAR,      --航班发布状态. 当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
  ABST VARCHAR,      --航班发布不正常状态      当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
  ABRS VARCHAR,      --航班发布不正常原因     当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
  ISTA VARCHAR,      --内部航班状态       当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
  IAST VARCHAR,      --内部航班不正常状态      当航班属性为"国内、国际、地区"时使用;当航班属性为混合时特指国内部分发布状态
  MSTA VARCHAR,      --航班发布状态     国内、国际、地区航班不使用该内容当航班属性为混合时特指国际部分状态
  MIST VARCHAR,      --内部航班状态     国内、国际、地区航班不使用该内容当航班属性为混合时特指国际部分状态
  MABS VARCHAR,      --航班发布不正常状态   国内、国际、地区航班不使用该内容当航班属性为混合时特指国际部分状态
  MIAS VARCHAR,      --内部航班不正常状态     国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际部分不正常原因
  MABR VARCHAR,      --航班发布不正常原因    国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际部分不正常原因
  MIAR VARCHAR,      --内部航班不正常原因     国内、国际、地区航班不使用该内容，当航班属性为混合时特指国际部分不正常原因
  IARS VARCHAR,      --内部航班不正常原因    当航班属性为国内、国际、地区时使用，当航班属性为混合时特指国内部分不正常原因
  BORT DATE,         --航班开始登机实际时间
  MBOR DATE,         --航班开始登机实际时间
  TBRT DATE,         --航班过站登机实际时间
  MTBR DATE,         --航班过站登机实际时间
  LBDT DATE,         --航班催促登机实际时间    当航班属性为国内、国际、地区时使用当航班属性为混合时特指国内催促登机时间
  MLBD DATE,         --航班催促登机实际时间    国内、国际、地区航班不使用该内容当航班属性为混合时特指国际催促登机时间
  POKT DATE,         --航班结束登机实际时间    当航班属性为国内、国际、地区时使用当航班属性为混合时特指国内结束登机时间
  MPOK DATE,         --航班结束登机实际时间   国内、国际、地区航班不使用该内容当航班属性为混合时特指国际结束登机时间
  APOT VARCHAR,      --备降航站
  DETT DATE,         --备降预计起飞时间
  DRTT DATE,         --备降实际起飞时间
  DELT DATE,         --备降预计降落时间
  DRLT DATE,         --备降实际降落时间
  VIP  NUMBER,       --vip人数



--共享航班
  SFLG VARCHAR,      --共享航班组标签
  SFLT VARCHAR,      --单个共享航班子标签
  SFAW VARCHAR,      --共享航空公司二字码
  SFNO VARCHAR,      --共享航班号
  
  
--  航站消息组
  PAST DATE,         --前站实际起飞时间
  AIRL VARCHAR,      --航线标签
  ARPT VARCHAR,      --航站标签
  APNO VARCHAR,      --航站序号
  APCD VARCHAR,      --航站三字码
  FPTT DATE,         --计划起飞时间
  FETT DATE,         --预计起飞时间
  FRTT DATE,         --实际起飞时间
  FPLT DATE,         --计划降落时间
  FELT DATE,         --预计降落时间
  FRLT DATE,         --实际降落时间
  APAT VARCHAR,      --航站属性

--  航班其它信息
  
  GTLS VARCHAR,      --航班登机门动态信息标签
  GATE VARCHAR,      --单个登机门组标签
  GTNO VARCHAR,      --登机门序号
  ID   VARCHAR,      --登机门唯一标识
  CODE VARCHAR, --值机柜台编号,实际资源的标识符
  GTAT VARCHAR, --登机门属性
  ESTR DATE, --预计开始使用时间
  EEND DATE, --预计结束使用时间
  RSTR DATE, --实际开始使用时间
  REND DATE, --实际结束使用时间
  BTSC VARCHAR, --资源所属楼号
  
  
  BLLS VARCHAR, --航班行李提取转盘动态信息标签
  BELT VARCHAR, --单个行李提取转盘组标签    
  BTNO VARCHAR, --行李提取转盘序号
  ID   VARCHAR, --行李提取转盘唯一标识
  CODE VARCHAR, --行李提取转盘编号
  BTAT VARCHAR, --行李提取转盘属性
  ESTR DATE,    --预计开始使用时间
  EEND DATE,    --预计结束使用时间
  RSTR DATE,    --实际开始使用时间
  REND DATE,    --实际结束使用时间
  BTSC VARCHAR, --资源所属楼号
  EXNO VARCHAR, --到达出口号
  
  
  CHLS VARCHAR, --航班行李滑槽动态更新信息标签
  CHUT VARCHAR, --单个行李滑槽组标签
  CHNO VARCHAR, --行李滑槽序号
  ID VARCHAR,   --行李滑槽编号
  CHAT VARCHAR, --行李滑槽属性
  ESTR DATE,    --预计开始使用时间
  EEND DATE,    --预计结束使用时间
  BSTR DATE,    --实际开始使用时间
  REND DATE,    --实际结束使用时间
  BTSC VARCHAR, --资源所属楼号
  
  CKLS VARCHAR, --航班值机柜台动态信息标签
  FCES DATE,    --航班旅客值机预计开始时间1
  FCEE DATE,    --航班旅客值机预计结束时间1
  FCRS DATE,    --航班旅客值机实际开始时间1
  FCRE DATE,    --航班旅客值机实际结束时间1
  MCES DATE,    --航班旅客值机预计开始时间2
  MCEE DATE,    --航班旅客值机预计结束时间2
  MCRS DATE,    --航班旅客值机实际开始时间2
  MCRE DATE,    --航班旅客值机实际结束时间2
  FCDP VARCHAR, --值机柜台及值机柜台区域显示 1
  MCDP VARCHAR, --值机柜台及值机柜台区域显示2
  
  
  
  CNTR VARCHAR,  --单个值机柜台组标签
  CKNO VARCHAR,  --值机柜台序号
  ID   VARCHAR,  --值机柜台唯一标识
  CODE VARCHAR,  --值机柜台编号
  CKAT VARCHAR,  --值机柜台属性
  TYPE VARCHAR,  --柜台类型
  CCAR VARCHAR,  --值机柜台所属值机岛号标签
  ESTR DATE,    --预计开始使用时间
  EEND DATE,    --预计结束使用时间
  RSTR DATE,    --实际开始使用时间
  REND DATE,    --实际结束使用时间
  BTSC VARCHAR, --资源所属楼号
  
  
  
  STLS VARCHAR,  --航班机位动态更新信息标签
  STND VARCHAR,  --单个机位组标签
  STNO VARCHAR,  --机位序号
  CODE VARCHAR,  --机位编号
  ESTR DATE,    --预计开始使用时间
  EEND DATE,    --预计结束使用时间
  RSTR DATE,    --实际开始使用时间
  REND DATE,    --实际结束使用时间
  BTSC VARCHAR, --资源所属楼号
  CSSI VARCHAR, --当前停放机位标识
  
--  楼号组信息

  TMCD VARCHAR, --航站楼编号组
  NMCD VARCHAR, --国内航站楼编号
  JMCD VARCHAR, --国际航站楼编号
  FLDT DATE,    --第一件行李上架时间
  LLDT DATE,    --最后一件行李上架时间
  
  
  
  
  
  
  










