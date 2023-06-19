package com.isoft.repository;

import com.isoft.entity.AFID_Dflt;
import com.isoft.entity.AIRL_Arpt;
import com.isoft.entity.AIRL_Dflt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AIRL_ArptRepository extends JpaRepository<AIRL_Arpt,Integer> {
    @Query(value = "insert into TEAM08.DFME_AIRL_ARPT(apno,apcd,fptt,fett,frtt,fplt,felt,frlt,apat,airl_id) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    public AIRL_Dflt saveApot(Integer apno,String apcd,String fptt,String fett,String frtt,
                              String fplt,String felt,String frlt,String apat,Long airlId);


    @Query(value = "select * from DFME_AIRL_ARPT",nativeQuery = true)
    public List<AIRL_Arpt> findAll();
}
