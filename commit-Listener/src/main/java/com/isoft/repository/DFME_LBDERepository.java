package com.isoft.repository;

import com.isoft.entity.DFME_LBDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DFME_LBDERepository extends JpaRepository<DFME_LBDE, Integer> {
    @Query(value ="insert into TEAM08.DFME_LBDE(meta_id,flid,ffid,fide,fatt,stat,ista,lbdt,msta,mist,mlbd)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",nativeQuery = true)
    public DFME_LBDE saveDFME(Long metaId, Long flid, String ffid, String fide, String fatt, String stat, String ista, String lbdt, String msta, String mist, String mlbd);

}
