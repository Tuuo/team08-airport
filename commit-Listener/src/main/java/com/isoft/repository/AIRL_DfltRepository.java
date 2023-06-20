package com.isoft.repository;

import com.isoft.entity.AFID_Dflt;
import com.isoft.entity.AIRL_Dflt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AIRL_DfltRepository extends JpaRepository<AIRL_Dflt, Integer> {
    @Query(value = "insert into TEAM08.DFME_AIRL(meta_id,flid,fide,ffid) " +
            "values (?1,?2,?3,?4)", nativeQuery = true)
    public AIRL_Dflt saveApot(Long metaId, Long flid, String fide, String ffid);
    @Query(value = "select * from TEAM08.DFME_AIRL ", nativeQuery = true)
    public Page<AIRL_Dflt> findAll(Pageable pageable);

//    @Query(value = "select * from TEAM08.DFME_AIRL where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.BASE_APUE where flid like %:flid% and fide like %:fide%", nativeQuery = true)
//    public Page<AIRL_Dflt> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);

}
