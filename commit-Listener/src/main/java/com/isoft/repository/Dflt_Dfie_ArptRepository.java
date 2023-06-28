package com.isoft.repository;

import com.isoft.entity.Dflt_Ckls_Cntr;
import com.isoft.entity.Dflt_Dfdl_Arpt;
import com.isoft.entity.Dflt_Dfie_Arpt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Dflt_Dfie_ArptRepository  extends JpaRepository<Dflt_Dfie_Arpt, Integer> {
    @Query(value = "insert into TEAM08.DFOE_DFIE_ARPT(apno,apcd," +
            "fptt,fett,frtt,fplt,felt,frlt,apat,dflt_id)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery = true)
    public Dflt_Dfie_Arpt saveDflt(String apno,
                                   String apcd, String fptt, String fett,
                                   String frtt, String fplt, String felt,
                                   String frlt, String apat, Long dflt_id);


    @Query(value = "select dd.*,dda.apno,dda.apcd,dda.fptt,dda.fett,dda.frtt,dda.fplt,dda.felt,dda.frlt,dda.apat,dda.dflt_id from TEAM08.DFOE_DFIE_ARPT dda left join TEAM08.DFOE_DFIE dd on (dda.DFLT_ID = dd.flid)", nativeQuery = true)
    public Page<Dflt_Dfie_Arpt> findAll(Pageable pageable);

    @Query(value = "select dd.*,dda.apno,dda.apcd,dda.fptt,dda.fett,dda.frtt,dda.fplt,dda.felt,dda.frlt,dda.apat,dda.dflt_id from TEAM08.DFOE_DFIE_ARPT dda left join TEAM08.TEAM08.DFOE_DFIE dd on (dda.DFLT_ID = dd.flid) where flid like %:flid% and fide like %:fide%",
            countQuery = "select dd.*,dda.apno,dda.apcd,dda.fptt,dda.fett,dda.frtt,dda.fplt,dda.felt,dda.frlt,dda.apat,dda.dflt_id from TEAM08.DFOE_DFIE_ARPT dda left join TEAM08.DFOE_DFIE dd on (dda.DFLT_ID = dd.flid) where flid like %:flid% and fide like %:fide%", nativeQuery = true)
    public Page<Dflt_Dfie_Arpt> findAllByCodeAndCnnmContaining(@Param("flid") String flid, @Param("fide") String fide, Pageable pageable);

    @Query(value = "SELECT fatt, COUNT(*) AS count " +
            "FROM TEAM08.DFOE_DFIE_ARPT " +
            "GROUP BY fatt",nativeQuery = true)
    public List<String> findCountApat();
}
