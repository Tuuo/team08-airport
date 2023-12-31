package com.isoft.repository;


import com.isoft.entity.Dflt_Bore;
import com.isoft.entity.Dflt_Cane;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Dflt_CaneRepository extends JpaRepository<Dflt_Cane, Integer> {
    @Query(value = "insert into TEAM08.DFME_CANE(meta_id,flid,ffid,fide,fatt,abst,iast,abrs,iars,mabs,mabr,mias,miar)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13)",nativeQuery = true)
    public Dflt_Cane saveDflt(Long metaId, String flid, String ffid, String fide, String fatt, String abst, String iast, String abrs, String iars, String mabs, String mabr, String mias,String miar);

    @Query(value = "select * from TEAM08.DFME_CANE ", nativeQuery = true)
    public Page<Dflt_Cane> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.DFME_CANE where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.DFME_CANE where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<Dflt_Cane> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);
    @Query(value = "SELECT fatt, COUNT(*) AS count " +
            "FROM TEAM08.DFME_CANE " +
            "GROUP BY fatt",nativeQuery = true)
    public List<String> findCountApat();
}
