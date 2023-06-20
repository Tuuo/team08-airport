package com.isoft.controller;


import com.isoft.entity.*;
import com.isoft.repository.*;
import com.isoft.vo.PageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    ApotRepository apotRepository;
    @Autowired
    MetaRepository metaRepository;
    @Autowired
    CrftRepository crftRepository;

    @Autowired
    AFID_DfltRepository afid_dfltRepository;

    @Autowired
    AIRL_DfltRepository airl_dfltRepository;
    @Autowired
    AIRL_ArptRepository airl_arptRepository;

    @Autowired
    Dflt_BoreRepository dflt_boreRepository;
    @Autowired
    Dflt_CaneRepository dflt_caneRepository;
    @Autowired
    Dflt_CfceRepository dflt_cfceRepository;
    @Autowired
    Dflt_CkieRepository dflt_ckieRepository;
    @Autowired
    Dflt_Ckls_CntrRepository dflt_ckls_cntrRepository;
    @Autowired
    Dflt_CklsRepository dflt_cklsRepository;
    @Autowired
    Dflt_CkoeRepository dflt_ckoeRepository;
    @Autowired
    BLLS_DfltRepository blls_dfltRepository;
    @Autowired
    BLLS_BeltRepository blls_beltRepository;

    @Autowired
    ARRE_DfltRepository arre_dfltRepository;

    @Autowired
    Dflt_DepeRepository dflt_depeRepository;

    @Autowired
    Dflt_DlyeRepository dflt_dlyeRepository;

    @Autowired
    Dflt_FettRepository dflt_fettRepository;

    @Autowired
    Dflt_FpttRepository dflt_fpttRepository;

    @Autowired
    Dflt_FrttRepository dflt_frttRepository;

    @Autowired
    Dflt_Gtls_GateRepository dflt_gtls_gateRepository;

    @Autowired
    Dflt_GtlsRepository dflt_gtlsRepository;

    @Autowired
    DFME_LBDERepository dfme_lbdeRepository;

    @Autowired
    DFME_ONRERepository onreRepository;

    @Autowired
    DFME_POKERepository pokeRepository;

    @Autowired
    DFME_STLSRepository stlsRepository;

    @Autowired
    DFME_STLS_STNDRepository stndRepository;

    @Autowired
    Dflt_Dfie_ArptRepository dflt_dfie_arptRepository;

    @Autowired
    Dflt_DfieRepository dflt_dfieRepository;

    @Autowired
    Dflt_Dfdl_ArptRepository dflt_dfdl_arptRepository;

    @Autowired
    Dflt_DfdlRepository dflt_dfdlRepository;


//    @GetMapping("/APUE")
//    public LayUiResult getAPUE(PageVo pageVo,String code,String cnnm) {
//        System.out.println(pageVo);
//        System.out.println(code);
//        System.out.println(cnnm);
//        // 创建分页请求
//        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
//        // 调用查询方法获取分页结果
//        Page<Apot> apuePage = apotRepository.findAll(code,cnnm,pageable);
//        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
//        return new LayUiResult(apuePage.getTotalElements(), apuePage.getContent());
//    }
@GetMapping("/APUE")
public LayUiResult getAPUE(PageVo pageVo, @RequestParam(required = false) String code, @RequestParam(required = false) String cnnm) {
    // 创建分页请求
    Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
    // 调用查询方法获取分页结果
    Page<Apot> apuePage = null;
    if (StringUtils.isNoneBlank(code) && StringUtils.isNoneBlank(cnnm)) {
        apuePage = apotRepository.findAllByCodeAndCnnmContaining(code, cnnm, pageable);
    } else {
        apuePage = apotRepository.findAll(pageable);
    }
    // 将查询结果和分页信息封装到LayUiResult对象中进行返回
    return new LayUiResult(apuePage.getTotalElements(), apuePage.getContent());
}

    @GetMapping("/CFUE")
    public List<Object> getCFUE() {
        List<Object> list = new ArrayList<>();
        List<Crft> crft = crftRepository.findAll();
        List<Meta> meta = metaRepository.findCFUEMeta();
        list.add(meta);
        list.add(crft);
        return list;
    }

    @GetMapping("/AFID")
    public List<Object> getAFID() {
        List<Object> list = new ArrayList<>();
        List<AFID_Dflt> afid_dflts = afid_dfltRepository.findAll();
        List<Meta> meta = metaRepository.findAFIDMeta();
        list.add(meta);
        list.add(afid_dflts);
        return list;
    }

    @GetMapping("/AIRL")
    public List<Object> getAIRL() {
        List<Object> list = new ArrayList<>();
        List<AIRL_Dflt> airl_dflts = airl_dfltRepository.findAll();
        List<AIRL_Arpt> airl_arpts = airl_arptRepository.findAll();
        List<Meta> meta = metaRepository.findAIRLMeta();
        list.add(meta);
        list.add(airl_dflts);
        list.add(airl_arpts);
        return list;
    }

    @GetMapping("/ARRE")
    public List<Object> getARRE() {
        List<Object> list = new ArrayList<>();
        List<ARRE_Dflt> arre_dflts = arre_dfltRepository.findAll();
        List<Meta> meta = metaRepository.findARREMeta();
        list.add(meta);
        list.add(arre_dflts);
        return list;
    }

    @GetMapping("/BLLS")
    public List<Object> getBLLS() {
        List<Object> list = new ArrayList<>();
        List<BLLS_Dflt> blls_dflts = blls_dfltRepository.findAll();
        List<BLLS_BELT> blls_belts = blls_beltRepository.findAll();
        List<Meta> meta = metaRepository.findARREMeta();
        list.add(meta);
        list.add(blls_dflts);
        list.add(blls_belts);
        return list;
    }

}