package com.isoft.repository;

import com.isoft.entity.Dflt_Cfce;
import com.isoft.entity.Dflt_Ckie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Dflt_CkieRepository extends JpaRepository<Dflt_Ckie, Integer> {
    @Query(value = "insert into TEAM08.DFME_CKIE(meta_id,flid,ffid,fide,fatt,stat,ista,fcrs,msta,mist,mcrs)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",nativeQuery = true)
    public Dflt_Ckie saveDflt(Long metaId, String flid, String ffid, String fide, String fatt, String stat,String ista,String fcrs,String msta,String mist,String mcrs);

    @Query(value = "select * from TEAM08.DFME_CKIE ", nativeQuery = true)
    public Page<Dflt_Ckie> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.DFME_CKIE where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.DFME_CKIE where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<Dflt_Ckie> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);
    @Query(value = "SELECT fatt, COUNT(*) AS count " +
            "FROM TEAM08.DFME_CKIE " +
            "GROUP BY fatt",nativeQuery = true)
    public List<String> findCountApat();
}
