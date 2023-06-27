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

}