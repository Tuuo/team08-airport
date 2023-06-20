package com.isoft.repository;

import com.isoft.entity.AFID_Dflt;
import com.isoft.entity.Crft;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AFID_DfltRepository extends JpaRepository<AFID_Dflt, Integer> {
    @Query(value = "insert into TEAM08.DFME_AFID(meta_id,flid,ffid,fide,afid) " +
            "values (?1,?2,?3,?4,?5)", nativeQuery = true)
    public AFID_Dflt saveApot(Long metaId,Long flid,String ffid,String fide,String afid);
    @Query(value = "select * from TEAM08.DFME_AFID ", nativeQuery = true)
    public Page<AFID_Dflt> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.DFME_AFID where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.BASE_APUE where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<AFID_Dflt> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);


}
