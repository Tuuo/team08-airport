package com.isoft.repository;


import com.isoft.entity.DFME_LBDE;
import com.isoft.entity.DFME_ONRE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DFME_ONRERepository extends JpaRepository<DFME_ONRE, Integer> {
    @Query(value = "insert into TEAM08.DFME_ONRE(meta_id,flid,ffid,fide,fatt,stat,ista,msta,mist,past,eldt)" +
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)", nativeQuery = true)
    public DFME_ONRE saveDFME(Long metaId, Long flid, String ffid, String fide, String fatt, String stat, String ista, String msta, String mist, String past, String eldt);

    @Query(value = "select * from TEAM08.DFME_ONRE ", nativeQuery = true)
    public Page<DFME_ONRE> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.DFME_ONRE where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.DFME_ONRE where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<DFME_ONRE> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);
}
