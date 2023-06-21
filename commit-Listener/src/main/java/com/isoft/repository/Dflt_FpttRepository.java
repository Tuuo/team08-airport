package com.isoft.repository;

import com.isoft.entity.Dflt_Fett;
import com.isoft.entity.Dflt_Fptt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Dflt_FpttRepository extends JpaRepository<Dflt_Fptt, Integer> {
    @Query(value = "insert into TEAM08.DFME_FPTT(meta_id,flid,ffid,fide,fptt,fplt)"+
            "values(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    public Dflt_Fptt saveDflt(Long metaId, String flid, String ffid, String fide, String fptt, String fplt);

    @Query(value = "select * from TEAM08.DFME_FPTT ", nativeQuery = true)
    public Page<Dflt_Fptt> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.DFME_FPTT where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.DFME_FPTT where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<Dflt_Fptt> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);

}
