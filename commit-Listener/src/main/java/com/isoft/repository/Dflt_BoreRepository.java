package com.isoft.repository;

import com.isoft.entity.Apot;
import com.isoft.entity.Dflt_Bore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Dflt_BoreRepository extends JpaRepository<Dflt_Bore, Integer> {
    @Query(value = "insert into TEAM08.DFME_BORE(meta_id,flid,ffid,fide,fatt,stat,ista,bort,msta,mist,mbor)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",nativeQuery = true)
    public Dflt_Bore saveDflt(Long metaId, String flid, String ffid, String fide, String fatt, String stat, String ista, String bort, String msta, String mist, String mbor);



    @Query(value = "select * from TEAM08.DFME_BORE ", nativeQuery = true)
    public Page<Dflt_Bore> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.DFME_BORE where flid like %:flid% and fide like %:fide%", countQuery = "select count(*) from TEAM08.DFME_BORE where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<Dflt_Bore> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);

    @Query(value = "SELECT fatt, COUNT(*) AS count " +
            "FROM TEAM08.DFME_BORE " +
            "GROUP BY fatt",nativeQuery = true)
    public List<String> findCountApat();
}
