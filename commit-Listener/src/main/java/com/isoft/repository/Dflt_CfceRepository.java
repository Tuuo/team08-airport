package com.isoft.repository;


import com.isoft.entity.Dflt_Cane;
import com.isoft.entity.Dflt_Cfce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Dflt_CfceRepository  extends JpaRepository<Dflt_Cfce, Integer> {
    @Query(value = "insert into TEAM08.DFME_CFCE(meta_id,flid,ffid,fide,cftp,cfno)"+
            "values(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    public Dflt_Cfce saveDflt(Long metaId, String flid, String ffid, String fide, String cftp, String cfno);

    @Query(value = "select * from TEAM08.DFME_CFCE ", nativeQuery = true)
    public Page<Dflt_Cfce> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.DFME_CFCE where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.DFME_CFCE where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<Dflt_Cfce> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);

}
