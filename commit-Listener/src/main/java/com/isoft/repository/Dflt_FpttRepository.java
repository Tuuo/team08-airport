package com.isoft.repository;

import com.isoft.entity.Dflt_Fett;
import com.isoft.entity.Dflt_Fptt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Dflt_FpttRepository extends JpaRepository<Dflt_Fptt, Integer> {
    @Query(value = "insert into TEAM08.DFME_FPTT(meta_id,flid,ffid,fide,fptt,fplt)"+
            "values(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    public Dflt_Fptt saveDflt(Long metaId, String flid, String ffid, String fide, String fptt, String fplt);


}
