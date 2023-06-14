package com.isoft.repository;

import com.isoft.entity.Dflt_Dfdl_Arpt;
import com.isoft.entity.Dflt_Dfie_Arpt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Dflt_Dfdl_ArptRepository extends JpaRepository<Dflt_Dfie_Arpt, Integer> {
    @Query(value = "insert into TEAM08.DFOE_DFDL_ARPT(apno,apcd," +
            "fptt,fett,frtt,fplt,felt,frlt,apat,dflt_id)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery = true)
    public Dflt_Dfdl_Arpt saveDflt(String apno,
                                   String apcd, String fptt, String fett,
                                   String frtt, String fplt, String felt,
                                   String frlt, String apat, Long dflt_id);
}
