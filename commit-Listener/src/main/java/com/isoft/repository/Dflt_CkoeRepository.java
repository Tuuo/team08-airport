package com.isoft.repository;

import com.isoft.entity.Dflt_Ckie;
import com.isoft.entity.Dflt_Ckoe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Dflt_CkoeRepository extends JpaRepository<Dflt_Ckoe, Integer> {
    @Query(value = "insert into TEAM08.DFME_CKOE(meta_id,flid,ffid,fide,fatt,stat,ista,fcre,msta,mist,mcre)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",nativeQuery = true)
    public Dflt_Ckoe saveDflt(Long metaId, String flid, String ffid, String fide, String fatt, String stat,String ista,String fcre,String msta,String mist,String mcre);

    @Query(value = "select * from TEAM08.DFME_CKOE ", nativeQuery = true)
    public Page<Dflt_Ckoe> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.DFME_CKOE where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.DFME_CKOE where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<Dflt_Ckoe> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);
    @Query(value = "SELECT fatt, COUNT(*) AS count " +
            "FROM TEAM08.DFME_CKOE " +
            "GROUP BY fatt",nativeQuery = true)
    public List<String> findCountApat();
}
