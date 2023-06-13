package com.isoft.repository;

import com.isoft.entity.Dflt_Cfce;
import com.isoft.entity.Dflt_Ckie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Dflt_CkieRepository extends JpaRepository<Dflt_Ckie, Integer> {
    @Query(value = "insert into TEAM08.DFME_CKIE(meta_id,flid,ffid,fide,fatt,stat,ista,fcrs,msta,mist,mcrs)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",nativeQuery = true)
    public Dflt_Ckie saveDflt(Long metaId, String flid, String ffid, String fide, String fatt, String stat,String ista,String fcrs,String msta,String mist,String mcrs);
}
