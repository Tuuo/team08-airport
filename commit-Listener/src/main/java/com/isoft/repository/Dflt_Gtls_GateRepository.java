package com.isoft.repository;

import com.isoft.entity.Dflt_Ckls_Cntr;
import com.isoft.entity.Dflt_Frtt;
import com.isoft.entity.Dflt_Gtls_Gate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Dflt_Gtls_GateRepository extends JpaRepository<Dflt_Gtls_Gate, Integer> {
    @Query(value = "insert into TEAM08.DFME_GTLS_GATE(gtno,id,code,gtat,estr,eend,rstr,rend,btsc,dflt_id)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery = true)
    public Dflt_Gtls_Gate saveDflt(String gtno,Long id, String code, String gtat, String estr, String eend, String rstr, String rend, String btsc,Long dflt_id);
    @Query(value = "select dgg.*,dg.meta_id,dg.flid,dg.ffid,dg.fide,dg.fatt from TEAM08.DFME_GTLS_GATE dgg left join TEAM08.DFME_GTLS dg on (dgg.dflt_id = dg.flid) ", nativeQuery = true)
    public Page<Dflt_Gtls_Gate> findAll(Pageable pageable);

    @Query(value = "select dgg.*,dg.meta_id,dg.flid,dg.ffid,dg.fide,dg.fatt from TEAM08.DFME_GTLS_GATE left join TEAM08.DFME_GTLS dg on (dgg.dflt_id = dg.flid) where flid like %:flid% and fide like %:fide%", countQuery = "select dgg.*,dg.meta_id,dg.flid,dg.ffid,dg.fide,dg.fatt from TEAM08.DFME_GTLS_GATE left join TEAM08.DFME_GTLS dg on (dgg.dflt_id = dg.flid) where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<Dflt_Gtls_Gate> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);


}
