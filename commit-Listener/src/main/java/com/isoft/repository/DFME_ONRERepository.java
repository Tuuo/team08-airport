package com.isoft.repository;


import com.isoft.entity.DFME_ONRE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DFME_ONRERepository extends JpaRepository<DFME_ONRE, Integer> {
    @Query(value ="insert into TEAM08.DFME_ONRE(meta_id,flid,ffid,fide,fatt,stat,ista,msta,mist,past,eldt)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",nativeQuery = true)
    public DFME_ONRE saveDFME(Long metaId, Long flid, String ffid, String fide, String fatt, String stat, String ista, String msta, String mist, String past, String eldt);

}
