package com.isoft.repository;

import com.isoft.entity.AFID_Dflt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AFID_DfltRepository extends JpaRepository<AFID_Dflt, Integer> {
    @Query(value = "insert into TEAM08.DFME_AFID(meta_id,flid,ffid,fide,afid) " +
            "values (?1,?2,?3,?4,?5)", nativeQuery = true)
    public AFID_Dflt saveApot(Long metaId,Long flid,String ffid,String fide,String afid);
}
