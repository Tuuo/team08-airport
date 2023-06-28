package com.isoft.repository;

import com.isoft.entity.Dflt_Ckls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Dflt_CklsRepository extends JpaRepository<Dflt_Ckls, Integer> {
    @Query(value = "insert into TEAM08.DFME_CKLS(meta_id,flid,ffid,fide,fatt,fces,fcee,fcrs,fcre,mces,mcee,mcrs,mcre,fcdp,mcdp)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15)",nativeQuery = true)
    public Dflt_Ckls saveDflt(Long metaId,Long flid,String ffid, String fide, String fatt, String fces, String fcee,String fcrs, String fcre, String mces, String mcee, String mcrs, String mcre, String fcdp, String mcdp);
}
