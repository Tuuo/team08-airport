create table T_AUTHORITY
(
    --
    ID        INT,
    AUTHORITY VARCHAR(20)
);

create unique index INDEX33555679
    on T_AUTHORITY (ID);

alter table T_AUTHORITY
    add constraint CONS134218998
        primary key (ID);

create table T_CUSTOMER
(
    --
    ID       INT,
    USERNAME VARCHAR(200) default 'NULL'
        constraint INDEX33556466
            unique,
    PASSWORD VARCHAR(200) default 'NULL',
    VALID    INT default '1' not null
);

create unique index INDEX33556465
    on T_CUSTOMER (ID);

alter table T_CUSTOMER
    add constraint CONS134219786
        primary key (ID);

create table T_CUSTOMER_AUTHORITY
(
    --
    ID           INT,
    CUSTOMER_ID  INT default NULL,
    AUTHORITY_ID INT default NULL
);

create unique index INDEX33555683
    on T_CUSTOMER_AUTHORITY (ID);

alter table T_CUSTOMER_AUTHORITY
    add constraint CONS134219000
        primary key (ID);


