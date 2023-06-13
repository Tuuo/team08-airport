package com.isoft.repository;

import com.isoft.entity.AIRL_Dflt;
import com.isoft.entity.ARRE_Dflt;
import com.isoft.entity.BLLS_Dflt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BLLS_DfltRepository extends JpaRepository<BLLS_Dflt, Integer> {
    @Query(value = "insert into TEAM08.DFME_BLLS(meta_id,flid,ffid,fide,fatt) " +
            "values (?1,?2,?3,?4,?5)", nativeQuery = true)
    public AIRL_Dflt saveApot(Long metaId, Long flid, String ffid, String fide,String fatt);
}
