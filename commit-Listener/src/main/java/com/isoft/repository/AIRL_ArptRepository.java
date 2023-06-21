package com.isoft.repository;

import com.isoft.entity.AFID_Dflt;
import com.isoft.entity.AIRL_Arpt;
import com.isoft.entity.AIRL_Dflt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AIRL_ArptRepository extends JpaRepository<AIRL_Arpt,Integer> {
    @Query(value = "insert into TEAM08.DFME_AIRL_ARPT(apno,apcd,fptt,fett,frtt,fplt,felt,frlt,apat,airl_id) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    public AIRL_Dflt saveApot(Integer apno,String apcd,String fptt,String fett,String frtt,
                              String fplt,String felt,String frlt,String apat,Long airlId);


    @Query(value = "select daa.id,daa.apno,daa.apcd,daa.fptt,daa.fett,daa.FRTT,daa.FPLT,daa.FELT,daa.FRLT,daa.APAT,daa.AIRL_ID from TEAM08.DFME_AIRL_ARPT daa ", nativeQuery = true)
    public Page<AIRL_Arpt> findAll(Pageable pageable);

    @Query(value = "select daa.id,daa.apno,daa.apcd,daa.fptt,daa.fett,daa.FRTT,daa.FPLT,daa.FELT,daa.FRLT,daa.APAT,daa.AIRL_ID from TEAM08.DFME_AIRL_ARPT daa where apno like %:apno% and apcd like %:apcd%", countQuery = "select count(*) from TEAM08.DFME_AIRL_ARPT  where apno like %:apno% and apcd like %:apcd%", nativeQuery = true)
    public Page<AIRL_Arpt> findAllByCodeAndCnnmContaining(@Param("apno") String apno, @Param("apcd") String apcd, Pageable pageable);

}
