package com.isoft.repository;

import com.isoft.entity.AIRL_Dflt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AIRL_DfltRepository extends JpaRepository<AIRL_Dflt, Integer> {
    @Query(value = "insert into TEAM08.DFME_AIRL(meta_id,flid,fide,ffid) " +
            "values (?1,?2,?3,?4)", nativeQuery = true)
    public AIRL_Dflt saveApot(Long metaId, Long flid, String fide, String ffid);
}
