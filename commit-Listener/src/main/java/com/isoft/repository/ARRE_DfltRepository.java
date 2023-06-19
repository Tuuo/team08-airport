package com.isoft.repository;

import com.isoft.entity.AFID_Dflt;
import com.isoft.entity.ARRE_Dflt;
import com.isoft.entity.Apot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ARRE_DfltRepository  extends JpaRepository<ARRE_Dflt, Integer> {
    @Query(value = "insert into TEAM08.DFME_ARRE(meta_id,flid,ffid,fide,fatt,stat,ista,frlt,msta,mist) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    public Apot saveApot(Long metaId, Long flid,String ffid,String fide,String fatt,String stat,String ista,String frlt,String msta,String mist);

    @Query(value = "select * from TEAM08.DFME_ARRE",nativeQuery = true)
    public List<ARRE_Dflt> findAll();
}
