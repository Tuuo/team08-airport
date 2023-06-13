package com.isoft.repository;


import com.isoft.entity.DFME_STLS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DFME_STLSRepository extends JpaRepository<DFME_STLS, Integer> {
    @Query(value ="insert into TEAM08.DFME_STLS(meta_id,flid,ffid,fide,fatt)"+
            "values(?1,?2,?3,?4,?5)",nativeQuery = true)
    public DFME_STLS saveDFME(Long metaId, Long flid, String ffid, String fide, String fatt);

}
