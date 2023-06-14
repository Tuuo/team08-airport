package com.isoft.repository;

import com.isoft.entity.Dflt_Ckls;
import com.isoft.entity.Dflt_Ckls_Cntr;
import com.isoft.entity.Dflt_Dfie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Dflt_DfieRepository  extends JpaRepository<Dflt_Dfie, Integer> {
    @Query(value = "insert into TEAM08.DFOE_DFIE(meta_id,flid,afid,ffid,fide,test,awcd,flno,fexd,fimd," +
            "flio,fltk,fatt,patt,mfid,mffi,cftp,cfno,stat,abst,abrs,ista,iast,iars,msta,mabs,mabr,mist," +
            "mias,miar,bort,mbor,tbrt,mtbr,lbdt,mlbd,pokt,mpok,apot,dett,drtt,delt,drlt,vip,sflg,past," +
            "gtls,blls,fces,fcee,fcrs,fcre,mces,mcee,mcrs,mcre,fcdp,mcdp,chls,stls,nmcd,jmcd,fldt,lldt," +
            "cont,prox)"+
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18,?19,?20,?21,?22,?23," +
            "?24,?25,?26,?27,?28,?29,?30,?31,?32,?33,?34,?35,?36,?37,?38,?39,?40,?41,?42,?43,?44,?45,?46," +
            "?47,?48,?49,?50,?51,?52,?53,?54,?55,?56,?57,?58,?59,?60,?61,?62,?63,?64,?65,?66)",nativeQuery = true)
    public Dflt_Dfie saveDflt(Long metaId,Long flid,String afid,String ffid,String fide,String test,
                              String awcd,String flno,String fexd,String fimd,String flio,String fltk,
                              String fatt,String patt,String mfid,String mffi,String cftp,String cfno,
                              String stat,String abst,String abrs,String ista,String iast,String iars,
                              String msta,String mabs,String mabr,String mist,String mias,String miar,
                              String bort,String mbor,String tbrt,String mtbr,String lbdt,String mlbd,
                              String pokt,String mpok,String apot,String dett,String drtt,String delt,
                              String drlt,String vip,String sflg,String past,String gtls,String blls,
                              String fces,String fcee,String fcrs, String fcre,String mces,String mcee,
                              String mcrs,String mcre,String fcdp,String mcdp,String chls,String stls,
                              String nmcd,String jmcd,String fldt,String lldt,String cont,String prox);
}
