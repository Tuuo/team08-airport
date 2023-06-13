package com.isoft.repository;

import com.isoft.entity.Dflt_Ckoe;
import com.isoft.entity.Dflt_Depe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Dflt_DepeRepository extends JpaRepository<Dflt_Depe, Integer> {
    @Query(value = "insert into TEAM08.DFME_DEPE(meta_id,flid,fatt,ffid,fide,stat,ista,msta,mist,frtt)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery = true)
    public Dflt_Depe saveDflt(Long metaId, String flid, String fatt,String ffid, String fide, String stat, String ista,String msta,String mist,String frtt);
}
