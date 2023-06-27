package com.isoft.repository;

import com.isoft.entity.Apot;
import com.isoft.entity.Meta;
import com.isoft.vo.PageVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;


public interface ApotRepository extends JpaRepository<Apot, Integer> {
    @Query(value = "insert into TEAM08.BASE_APUE(meta_id,code,frcd,apat,cnnm,ennm,aiso,apsn) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery = true)
    public Apot saveApot( Long metaId, String code, String frcd, String apat, String cnnm, String ennm, String aiso, String apsn);

    @Query(value = "select * from TEAM08.BASE_APUE ", nativeQuery = true)
    public Page<Apot> findAll(Pageable pageable);

    @Query(value = "select * from TEAM08.BASE_APUE where code like %:code% and cnnm like %:cnnm%", countQuery = "select count(*) from TEAM08.BASE_APUE where code like %:code% and cnnm like %:cnnm%", nativeQuery = true)
    public Page<Apot> findAllByCodeAndCnnmContaining(@Param("code") String code, @Param("cnnm") String cnnm, Pageable pageable);

    @Query(value = "SELECT apat, COUNT(*) AS count\n" +
            "FROM TEAM08.BASE_APUE\n" +
            "GROUP BY apat",nativeQuery = true)
    public List<String> findCountApat();
}
