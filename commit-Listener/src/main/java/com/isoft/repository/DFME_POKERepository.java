package com.isoft.repository;


import com.isoft.entity.DFME_ONRE;
import com.isoft.entity.DFME_POKE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DFME_POKERepository extends JpaRepository<DFME_POKE, Integer> {
    @Query(value ="insert into TEAM08.DFME_POKE(meta_id,flid,ffid,fide,fatt,stat,ista,pokt,msta,mist,mpok)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",nativeQuery = true)
    public DFME_POKE saveDFME(Long metaId, Long flid, String ffid, String fide, String fatt, String stat, String ista, String pokt, String msta, String mist, String mpok);

    @Query(value = "select * from TEAM08.DFME_POKE ", nativeQuery = true)
    public Page<DFME_POKE> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.DFME_POKE where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.DFME_POKE where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<DFME_POKE> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);
}
