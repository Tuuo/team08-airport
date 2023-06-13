package com.isoft.repository;

import com.isoft.entity.Dflt_Bore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Dflt_BoreRepository extends JpaRepository<Dflt_Bore, Integer> {
    @Query(value = "insert into TEAM08.DFME_BORE(meta_id,flid,ffid,fide,fatt,stat,ista,bort,msta,mist,mbor)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",nativeQuery = true)
    public Dflt_Bore saveDflt(Long metaId, String flid, String ffid, String fide, String fatt, String stat, String ista, String bort, String msta, String mist, String mbor);
}
