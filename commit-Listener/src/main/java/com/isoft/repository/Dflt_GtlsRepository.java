package com.isoft.repository;

import com.isoft.entity.Dflt_Ckie;
import com.isoft.entity.Dflt_Gtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Dflt_GtlsRepository extends JpaRepository<Dflt_Gtls, Integer> {
    @Query(value = "insert into TEAM08.DFME_GTLS(meta_id,flid,ffid,fide,fatt)"+
            "values(?1,?2,?3,?4,?5)",nativeQuery = true)
    public Dflt_Gtls saveDflt(Long metaId, Long flid, String ffid, String fide, String fatt);
    @Query(value = "SELECT fatt, COUNT(*) AS count " +
            "FROM TEAM08.DFME_GTLS " +
            "GROUP BY fatt",nativeQuery = true)
    public List<String> findCountApat();
}
