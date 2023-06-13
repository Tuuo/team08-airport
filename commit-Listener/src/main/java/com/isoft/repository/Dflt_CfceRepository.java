package com.isoft.repository;


import com.isoft.entity.Dflt_Cfce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Dflt_CfceRepository  extends JpaRepository<Dflt_Cfce, Integer> {
    @Query(value = "insert into TEAM08.DFME_CFCE(meta_id,flid,ffid,fide,cftp,cfno)"+
            "values(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    public Dflt_Cfce saveDflt(Long metaId, String flid, String ffid, String fide, String cftp, String cfno);
}
