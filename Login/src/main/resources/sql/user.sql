create table T_AUTHORITY
(
    --
    ID        INT(10),
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
    ID       INT(10),
    USERNAME VARCHAR(200) default 'NULL'
        constraint T_CUSTOMER_USERNAME_UINDEX
            unique,
    PASSWORD VARCHAR(200) default 'NULL',
    VALID    INT(10) default '1' not null
);

create unique index INDEX33555681
    on T_CUSTOMER (ID);

alter table T_CUSTOMER
    add constraint CONS134218999
        primary key (ID);

create table T_CUSTOMER_AUTHORITY
(
    --
    ID           INT(10),
    CUSTOMER_ID  INT(10) default NULL,
    AUTHORITY_ID INT(10) default NULL
);

create unique index INDEX33555683
    on T_CUSTOMER_AUTHORITY (ID);

alter table T_CUSTOMER_AUTHORITY
    add constraint CONS134219000
        primary key (ID);

