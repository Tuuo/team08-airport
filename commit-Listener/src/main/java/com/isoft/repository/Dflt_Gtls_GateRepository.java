package com.isoft.repository;

import com.isoft.entity.Dflt_Ckls_Cntr;
import com.isoft.entity.Dflt_Gtls_Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Dflt_Gtls_GateRepository extends JpaRepository<Dflt_Gtls_Gate, Integer> {
    @Query(value = "insert into TEAM08.DFME_GTLS_GATE(gtno,id,code,gtat,estr,eend,rstr,rend,btsc,dflt_id)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery = true)
    public Dflt_Gtls_Gate saveDflt(String gtno,Long id, String code, String gtat, String estr, String eend, String rstr, String rend, String btsc,Long dflt_id);
}
