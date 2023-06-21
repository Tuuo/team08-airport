package com.isoft.repository;

import com.isoft.entity.Dflt_Cfce;
import com.isoft.entity.Dflt_Fptt;
import com.isoft.entity.Dflt_Frtt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Dflt_FrttRepository extends JpaRepository<Dflt_Frtt, Integer> {
    @Query(value = "insert into TEAM08.DFME_FRTT(meta_id,flid,ffid,fide,frtt,frlt)"+
            "values(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    public Dflt_Frtt saveDflt(Long metaId, String flid, String ffid, String fide, String frtt, String frlt);

    @Query(value = "select * from TEAM08.DFME_FRTT ", nativeQuery = true)
    public Page<Dflt_Frtt> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.DFME_FRTT where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.DFME_FRTT where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<Dflt_Frtt> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);

}
