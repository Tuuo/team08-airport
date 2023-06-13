package com.isoft.repository;


import com.isoft.entity.DFME_STLS_STND;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DFME_STLS_STNDRepository extends JpaRepository<DFME_STLS_STND, Integer> {
    @Query(value ="insert into TEAM08.DFME_STLS_STND(stls_id,stno,code,estr,eend,rstr,rend,cssi,btsc)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9)",nativeQuery = true)
    public DFME_STLS_STND saveDFME(Long stls_id, String stno, String code, String estr, String eend, String rstr, String rend, String cssi, String btsc);


}
