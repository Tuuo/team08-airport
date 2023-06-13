package com.isoft.repository;

import com.isoft.entity.AIRL_Dflt;
import com.isoft.entity.BLLS_BELT;
import com.isoft.entity.BLLS_Dflt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BLLS_BeltRepository extends JpaRepository<BLLS_BELT, Integer> {
    @Query(value = "insert into TEAM08.DFME_BLLS_BELT(btno,id,code,btat,estr,eend,rstr,rend,btsc,blls_id) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    public AIRL_Dflt saveApot(Integer btno,Long id,String code,String btat,String estr,String eend,String rstr,
    String rend,String btsc,Long bllsId);
}
