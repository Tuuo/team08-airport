package com.isoft.repository;

import com.isoft.entity.Apot;
import com.isoft.entity.Meta;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface ApotRepository extends JpaRepository<Apot, Integer> {
    @Query(value = "insert into TEAM08.BASE_APUE(meta_id,code,frcd,apat,cnnm,ennm,aiso,apsn) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery = true)
    public Apot saveApot( Long metaId, String code, String frcd, String apat, String cnnm, String ennm, String aiso, String apsn);
}