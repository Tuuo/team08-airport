package com.isoft.repository;

import com.isoft.entity.Dflt_Cfce;
import com.isoft.entity.Dflt_Frtt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Dflt_FrttRepository extends JpaRepository<Dflt_Frtt, Integer> {
    @Query(value = "insert into TEAM08.DFME_FRTT(meta_id,flid,ffid,fide,frtt,frlt)"+
            "values(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    public Dflt_Frtt saveDflt(Long metaId, String flid, String ffid, String fide, String frtt, String frlt);
}
