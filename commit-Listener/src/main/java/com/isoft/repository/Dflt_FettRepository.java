package com.isoft.repository;

import com.isoft.entity.Dflt_Ckie;
import com.isoft.entity.Dflt_Fett;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Dflt_FettRepository extends JpaRepository<Dflt_Fett, Integer> {
    @Query(value = "insert into TEAM08.DFME_FETT(meta_id,flid,ffid,fide,fett,felt)"+
            "values(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    public Dflt_Fett saveDflt(Long metaId, String flid, String ffid, String fide, String fett, String felt);


}
