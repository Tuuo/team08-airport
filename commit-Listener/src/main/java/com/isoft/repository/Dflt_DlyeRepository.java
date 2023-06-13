package com.isoft.repository;

import com.isoft.entity.Dflt_Cane;
import com.isoft.entity.Dflt_Dlye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Dflt_DlyeRepository extends JpaRepository<Dflt_Dlye, Integer> {
    @Query(value = "insert into TEAM08.DFME_DLYE(meta_id,flid,ffid,fide,fatt,abst,iast,abrs,iars,mabs,mabr,mias,miar,fett)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14)",nativeQuery = true)
    public Dflt_Dlye saveDflt(Long metaId, String flid, String ffid, String fide, String fatt, String abst, String iast, String abrs, String iars, String mabs, String mabr, String mias,String miar,String fett);
}
