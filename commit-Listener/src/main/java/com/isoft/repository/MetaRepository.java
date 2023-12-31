package com.isoft.repository;


import com.isoft.entity.Meta;
import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface MetaRepository extends JpaRepository<Meta, Integer> {
//    @Transactional
    @Query(value = "insert into TEAM08.COMMON_META(sndr,rcvr,seqn,ddtm,type,styp) " +
            "values (?1,?2,?3,?4,?5,?6)", nativeQuery = true)
    public Meta saveMeta(String sndr, String rcvr, Long seqn, String ddtm,String type,String styp);
    @Query(value = "select * from TEAM08.COMMON_META where styp like 'APUE'",nativeQuery = true)
    public List<Meta> findAPUEMeta();

    @Query(value = "select * from TEAM08.COMMON_META where styp like 'CFUE'",nativeQuery = true)
    public List<Meta> findCFUEMeta();
    @Query(value = "select * from TEAM08.COMMON_META where styp like 'AFID'",nativeQuery = true)
    public List<Meta> findAFIDMeta();
    @Query(value = "select * from TEAM08.COMMON_META where styp like 'AIRL'",nativeQuery = true)
    public List<Meta> findAIRLMeta();
    @Query(value = "select * from TEAM08.COMMON_META where styp like 'ARRE'",nativeQuery = true)
    public List<Meta> findARREMeta();

    @Query(value = "select * from TEAM08.COMMON_META where styp like 'BLLS'",nativeQuery = true)
    public List<Meta> findBLLSMeta();





}
