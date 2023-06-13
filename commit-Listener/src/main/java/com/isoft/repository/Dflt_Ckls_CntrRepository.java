package com.isoft.repository;

import com.isoft.entity.Dflt_Cfce;
import com.isoft.entity.Dflt_Ckie;
import com.isoft.entity.Dflt_Ckls_Cntr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Dflt_Ckls_CntrRepository extends JpaRepository<Dflt_Ckls_Cntr, Integer> {
    @Query(value = "insert into TEAM08.DFME_CKLS_CNTR(ckno,id,code,ckat,type,ccar,estr,eend,rstr,rend,btsc,dflt_id)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12)",nativeQuery = true)
    public Dflt_Ckls_Cntr saveDflt(String ckno,Long id, String code, String ckat, String type, String ccar, String estr, String eend, String rstr, String rend, String btsc,Long dflt_id);
}
