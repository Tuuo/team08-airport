package com.isoft.repository;

import com.isoft.entity.Dflt_Ckoe;
import com.isoft.entity.Dflt_Depe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Dflt_DepeRepository extends JpaRepository<Dflt_Depe, Integer> {
    @Query(value = "insert into TEAM08.DFME_DEPE(meta_id,flid,fatt,ffid,fide,stat,ista,msta,mist,frtt)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery = true)
    public Dflt_Depe saveDflt(Long metaId, String flid, String fatt,String ffid, String fide, String stat, String ista,String msta,String mist,String frtt);

    @Query(value = "select * from TEAM08.DFME_DEPE ", nativeQuery = true)
    public Page<Dflt_Depe> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.DFME_DEPE where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.DFME_DEPE where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<Dflt_Depe> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);

    @Query(value = "SELECT fatt, COUNT(*) AS count " +
            "FROM TEAM08.DFME_DEPE " +
            "GROUP BY fatt",nativeQuery = true)
    public List<String> findCountApat();
}
