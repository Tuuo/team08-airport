package com.isoft.repository;


import com.isoft.entity.DFME_POKE;
import com.isoft.entity.DFME_STLS_STND;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DFME_STLS_STNDRepository extends JpaRepository<DFME_STLS_STND, Integer> {
    @Query(value ="insert into TEAM08.DFME_STLS_STND(stls_id,stno,code,estr,eend,rstr,rend,cssi,btsc)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9)",nativeQuery = true)
    public DFME_STLS_STND saveDFME(Long stls_id, String stno, String code, String estr, String eend, String rstr, String rend, String cssi, String btsc);

    @Query(value = "select dss.*,ds.meta_id,ds.flid,ds.ffid,ds.fide,ds.fatt from TEAM08.DFME_STLS_STND dss left join TEAM08.DFME_STLS ds on (dss.STLS_ID = ds.flid)", nativeQuery = true)
    public Page<DFME_STLS_STND> findAll(Pageable pageable);

    @Query(value = "select dss.*,ds.meta_id,ds.flid,ds.ffid,ds.fide,ds.fatt from TEAM08.DFME_STLS_STND dss left join TEAM08.DFME_STLS ds on (dss.STLS_ID = ds.flid) where flid like %:flid% and fide like %:fide%", countQuery = "select dss.*,ds.meta_id,ds.flid,ds.ffid,ds.fide,ds.fatt from TEAM08.DFME_STLS_STND dss left join TEAM08.DFME_STLS ds on (dss.STLS_ID = ds.flid) where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<DFME_STLS_STND> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);

    @Query(value = "SELECT fatt, COUNT(*) AS count " +
            "FROM TEAM08.DFME_STLS_STND " +
            "GROUP BY fatt",nativeQuery = true)
    public List<String> findCountApat();
}
