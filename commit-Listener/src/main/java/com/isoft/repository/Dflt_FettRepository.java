package com.isoft.repository;

import com.isoft.entity.Dflt_Ckie;
import com.isoft.entity.Dflt_Dlye;
import com.isoft.entity.Dflt_Fett;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Dflt_FettRepository extends JpaRepository<Dflt_Fett, Integer> {
    @Query(value = "insert into TEAM08.DFME_FETT(meta_id,flid,ffid,fide,fett,felt)"+
            "values(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    public Dflt_Fett saveDflt(Long metaId, String flid, String ffid, String fide, String fett, String felt);

    @Query(value = "select * from TEAM08.DFME_FETT ", nativeQuery = true)
    public Page<Dflt_Fett> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.DFME_FETT where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.DFME_FETT where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<Dflt_Fett> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);

}
