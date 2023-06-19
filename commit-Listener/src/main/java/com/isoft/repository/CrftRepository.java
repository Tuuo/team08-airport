package com.isoft.repository;

import com.isoft.entity.Apot;
import com.isoft.entity.Crft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CrftRepository extends JpaRepository<Crft, Integer> {

    @Query(value = "insert into TEAM08.BASE_CFUE(meta_id,code,cftp,awcd,stnm,rstn,cfsa,ttwc,mxlw,rllw) " +
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery = true)
    public Crft saveCrft( Long metaId, String code, String cftp, String awcd, Integer stnm, Integer rstn, String cfsa, Float ttwc,Float mxlw,Float rllw);
    @Query(value = "select * from TEAM08.BASE_CFUE",nativeQuery = true)
    public List<Crft> findAll();

}
