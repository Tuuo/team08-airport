package com.isoft.repository;

import com.isoft.entity.Dflt_Ckie;
import com.isoft.entity.Dflt_Ckoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Dflt_CkoeRepository extends JpaRepository<Dflt_Ckoe, Integer> {
    @Query(value = "insert into TEAM08.DFME_CKOE(meta_id,flid,ffid,fide,fatt,stat,ista,fcre,msta,mist,mcre)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",nativeQuery = true)
    public Dflt_Ckoe saveDflt(Long metaId, String flid, String ffid, String fide, String fatt, String stat,String ista,String fcre,String msta,String mist,String mcre);
}
