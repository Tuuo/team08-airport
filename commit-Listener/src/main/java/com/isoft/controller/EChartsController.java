package com.isoft.controller;

import com.isoft.entity.Apot;
import com.isoft.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class EChartsController {
    @Autowired
    ApotRepository apotRepository;
    @Autowired
    AIRL_ArptRepository airl_arptRepository;

    @Autowired
    ARRE_DfltRepository arre_dfltRepository;
    @Autowired
    BLLS_BeltRepository blls_beltRepository;
    @Autowired
    Dflt_DlyeRepository dflt_dlyeRepository;

    @Autowired
    Dflt_BoreRepository dflt_boreRepository;
    @Autowired
    Dflt_CaneRepository dflt_caneRepository;

    @Autowired
    Dflt_CkieRepository dflt_ckieRepository;
    @Autowired
    Dflt_CkoeRepository dflt_ckoeRepository;

    @Autowired
    Dflt_DepeRepository dflt_depeRepository;
    @Autowired
    DFME_LBDERepository dfme_lbdeRepository;
    @Autowired
    DFME_ONRERepository dfme_onreRepository;
    @Autowired
    DFME_POKERepository dfme_pokeRepository;
    @Autowired
    Dflt_Ckls_CntrRepository dflt_ckls_cntrRepository;
    @Autowired
    Dflt_Gtls_GateRepository dflt_gtls_gateRepository;
    @Autowired
    DFME_STLS_STNDRepository dfme_stls_stndRepository;
    @Autowired
    Dflt_Dfdl_ArptRepository dflt_dfdl_arptRepository;
    @Autowired
    Dflt_Dfie_ArptRepository dflt_dfie_arptRepository;

    @Autowired
    Dflt_GtlsRepository dflt_gtlsRepository;

    @GetMapping("/echartsAPUE")
    public List<String> echartAPUE() {
        System.out.println(apotRepository.findCountApat());
        return apotRepository.findCountApat();
    }

    @GetMapping("/echartsAIRL")
    public List<String> echartAIRL() {
        System.out.println(airl_arptRepository.findCountApat());
        return airl_arptRepository.findCountApat();
    }

    @GetMapping("/echartsARRE")
    public List<String> echartARRE() {
        System.out.println(arre_dfltRepository.findCountApat());
        return arre_dfltRepository.findCountApat();
    }

    @GetMapping("/echartsBLLS")
    public List<String> echartBLLS() {
        System.out.println(blls_beltRepository.findCountApat());
        return blls_beltRepository.findCountApat();
    }

    @GetMapping("/echartsDLYE")
    public List<String> echartDLYE() {
        System.out.println(dflt_dlyeRepository.findCountApat());
        return dflt_dlyeRepository.findCountApat();
    }

    @GetMapping("/echartsBORE")
    public List<String> echartBORE() {
        System.out.println(dflt_boreRepository.findCountApat());
        return dflt_boreRepository.findCountApat();
    }

    @GetMapping("/echartsCANE")
    public List<String> echartCANE() {
        System.out.println(dflt_caneRepository.findCountApat());
        return dflt_caneRepository.findCountApat();
    }
    @GetMapping("/echartsCKIE")
    public List<String> echartCKIE() {
        System.out.println(dflt_ckieRepository.findCountApat());
        return dflt_ckieRepository.findCountApat();
    }

    @GetMapping("/echartsCKOE")
    public List<String> echartCKOE() {
        System.out.println(dflt_ckoeRepository.findCountApat());
        return dflt_ckoeRepository.findCountApat();
    }

    @GetMapping("/echartsDEPE")
    public List<String> echartDEPE() {
        System.out.println(dflt_depeRepository.findCountApat());
        return dflt_depeRepository.findCountApat();
    }

    @GetMapping("/echartsLBDE")
    public List<String> echartLBDE() {
        System.out.println(dfme_lbdeRepository.findCountApat());
        return dfme_lbdeRepository.findCountApat();
    }

    @GetMapping("/echartsONRE")
    public List<String> echartONRE() {
        System.out.println(dfme_onreRepository.findCountApat());
        return dfme_onreRepository.findCountApat();
    }

    @GetMapping("/echartsPOKE")
    public List<String> echartPOKE() {
        System.out.println(dfme_pokeRepository.findCountApat());
        return dfme_pokeRepository.findCountApat();
    }

    @GetMapping("/echartsCKLS")
    public List<String> echartCKLS() {
        System.out.println(dflt_ckls_cntrRepository.findCountApat());
        return dflt_ckls_cntrRepository.findCountApat();
    }

    @GetMapping("/echartsGTLS")
    public List<String> echartGTLS() {
        System.out.println(dflt_gtlsRepository.findCountApat());
        return dflt_gtlsRepository.findCountApat();
    }

    @GetMapping("/echartsSTLS")
    public List<String> echartSTLS() {
        System.out.println(dfme_stls_stndRepository.findCountApat());
        return dfme_stls_stndRepository.findCountApat();
    }

    @GetMapping("/echartsDFDL")
    public List<String> echartDFDL() {
        System.out.println(dflt_dfdl_arptRepository.findCountApat());
        return dflt_dfdl_arptRepository.findCountApat();
    }


    @GetMapping("/echartsDFIE")
    public List<String> echartDFIE() {
        System.out.println(dflt_dfie_arptRepository.findCountApat());
        return dflt_dfie_arptRepository.findCountApat();
    }
}