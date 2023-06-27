package com.isoft.repository;

import com.isoft.entity.AIRL_Arpt;
import com.isoft.entity.AIRL_Dflt;
import com.isoft.entity.BLLS_BELT;
import com.isoft.entity.BLLS_Dflt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BLLS_BeltRepository extends JpaRepository<BLLS_BELT, Integer> {
    @Query(value = "insert into TEAM08.DFME_BLLS_BELT(btno,id,code,btat,estr,eend,rstr,rend,btsc,blls_id) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    public AIRL_Dflt saveApot(Integer btno,Long id,String code,String btat,String estr,String eend,String rstr,
    String rend,String btsc,Long bllsId);

    @Query(value = "select dbb.belt_id, dbb.btno,  dbb.id, dbb.code, dbb.btat, dbb.estr, dbb.eend, dbb.rstr, dbb.rend, dbb.btsc, dbb.blls_id from TEAM08.DFME_BLLS_BELT dbb", nativeQuery = true)
    public Page<BLLS_BELT> findAll(Pageable pageable);

    @Query(value = "select dbb.belt_id,dbb.btno,dbb.id,dbb.code,dbb.btat,dbb.estr,dbb.eend,dbb.rstr,dbb.rend,dbb.btsc,dbb.blls_id from TEAM08.DFME_BLLS_BELT dbb where btno like %:btno% and id like %:id%", countQuery = "select count(*) from TEAM08.DFME_BLLS_BELT  where btno like %:btno% and id like %:id%", nativeQuery = true)
    public Page<BLLS_BELT> findAllByCodeAndCnnmContaining(@Param("btno") String btno, @Param("id") String id, Pageable pageable);
    @Query(value = "SELECT btat, COUNT(*) AS count " +
            "FROM TEAM08.DFME_BLLS_BELT " +
            "GROUP BY btat",nativeQuery = true)
    public List<String> findCountApat();
}
