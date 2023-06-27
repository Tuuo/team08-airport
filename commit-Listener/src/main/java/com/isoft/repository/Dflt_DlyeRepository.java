package com.isoft.repository;

import com.isoft.entity.Dflt_Cane;
import com.isoft.entity.Dflt_Depe;
import com.isoft.entity.Dflt_Dlye;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Dflt_DlyeRepository extends JpaRepository<Dflt_Dlye, Integer> {
    @Query(value = "insert into TEAM08.DFME_DLYE(meta_id,flid,ffid,fide,fatt,abst,iast,abrs,iars,mabs,mabr,mias,miar,fett)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14)",nativeQuery = true)
    public Dflt_Dlye saveDflt(Long metaId, String flid, String ffid, String fide, String fatt, String abst, String iast, String abrs, String iars, String mabs, String mabr, String mias,String miar,String fett);

    @Query(value = "select * from TEAM08.DFME_DLYE ", nativeQuery = true)
    public Page<Dflt_Dlye> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.DFME_DLYE where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.DFME_DLYE where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<Dflt_Dlye> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);
    @Query(value = "SELECT fatt, COUNT(*) AS count " +
            "FROM TEAM08.DFME_DLYE " +
            "GROUP BY fatt",nativeQuery = true)
    public List<String> findCountApat();
}
