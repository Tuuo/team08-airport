package com.isoft.repository;

import com.isoft.entity.Dflt_Cfce;
import com.isoft.entity.Dflt_Ckie;
import com.isoft.entity.Dflt_Ckls_Cntr;
import com.isoft.entity.Dflt_Ckoe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Dflt_Ckls_CntrRepository extends JpaRepository<Dflt_Ckls_Cntr, Integer> {
    @Query(value = "insert into TEAM08.DFME_CKLS_CNTR(ckno,id,code,ckat,type,ccar,estr,eend,rstr,rend,btsc,dflt_id)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12)",nativeQuery = true)
    public Dflt_Ckls_Cntr saveDflt(String ckno,Long id, String code, String ckat, String type, String ccar, String estr, String eend, String rstr, String rend, String btsc,Long dflt_id);
    @Query(value = "select dcc.*,dc.meta_id,dc.flid,dc.ffid,dc.fide,dc.fatt,dc.fces,dc.fcee,dc.fcrs,dc.fcre,dc.mces,dc.mcee,dc.mcrs,dc.mcre,dc.fcdp,dc.mcdp from TEAM08.DFME_CKLS_CNTR dcc left join TEAM08.DFME_CKLS dc on (dcc.DFLT_ID = dc.flid)", nativeQuery = true)
    public Page<Dflt_Ckls_Cntr> findAll(Pageable pageable);

    @Query(value = "select dcc.*,dc.meta_id,dc.flid,dc.ffid,dc.fide,dc.fatt,dc.fces,dc.fcee,dc.fcrs,dc.fcre,dc.mces,dc.mcee,dc.mcrs,dc.mcre,dc.fcdp,dc.mcdp from TEAM08.DFME_CKLS_CNTR dcc left join TEAM08.DFME_CKLS dc on (dcc.DFLT_ID = dc.flid)where flid like %:flid% and fide like %:fide%", countQuery = "select dcc*,dc.meta_id,dc.flid,dc.ffid,dc.fide,dc.fatt,dc.fces,dc.fcee,dc.fcrs,dc.fcre,dc.mces,dc.mcee,dc.mcrs,dc.mcre,dc.fcdp,dc.mcdp from TEAM08.DFME_CKLS_CNTR dcc left join TEAM08.DFME_CKLS dc on (dcc.DFLT_ID = dc.flid)  where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<Dflt_Ckls_Cntr> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);

    @Query(value = "SELECT fatt, COUNT(*) AS count " +
            "FROM TEAM08.DFME_CKLS_CNTR " +
            "GROUP BY fatt",nativeQuery = true)
    public List<String> findCountApat();
}
