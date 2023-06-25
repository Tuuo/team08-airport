package com.isoft.controller;


import com.isoft.entity.*;
import com.isoft.repository.*;
import com.isoft.vo.PageVo;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
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
    System.out.println(apuePage.getContent());
    // 将查询结果和分页信息封装到LayUiResult对象中进行返回
    return new LayUiResult(apuePage.getTotalElements(), apuePage.getContent());
}

    @GetMapping("/CFUE")
    public LayUiResult getCFUE(PageVo pageVo, @RequestParam(required = false) String code, @RequestParam(required = false) String awcd) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<Crft> crftPage = null;
        if (StringUtils.isNoneBlank(code) && StringUtils.isNoneBlank(awcd)) {
            crftPage = crftRepository.findAllByCodeAndCnnmContaining(code, awcd, pageable);
        } else {
            crftPage = crftRepository.findAll(pageable);
        }
        System.out.println(crftPage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(crftPage.getTotalElements(), crftPage.getContent());
    }

    @GetMapping("/AFID")
    public LayUiResult getAFID(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<AFID_Dflt> afid_dfltPage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            afid_dfltPage = afid_dfltRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            afid_dfltPage = afid_dfltRepository.findAll(pageable);
        }
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(afid_dfltPage.getTotalElements(), afid_dfltPage.getContent());
    }
    @GetMapping("/AIRL")
    public LayUiResult getAIRL(PageVo pageVo, @RequestParam(required = false) String apno, @RequestParam(required = false) String apcd) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<AIRL_Arpt> airl_arptPage = null;
        if (StringUtils.isNoneBlank(apno) && StringUtils.isNoneBlank(apcd)) {
            airl_arptPage = airl_arptRepository.findAllByCodeAndCnnmContaining(apno, apcd, pageable);
        } else {
            airl_arptPage = airl_arptRepository.findAll(pageable);
        }
        System.out.println(airl_arptPage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(airl_arptPage.getTotalElements(), airl_arptPage.getContent());
    }

    @GetMapping("/ARRE")
    public LayUiResult getARRE(PageVo pageVo, @RequestParam(required = false) String apno, @RequestParam(required = false) String apcd) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<ARRE_Dflt> arre_dfltPage = null;
        if (StringUtils.isNoneBlank(apno) && StringUtils.isNoneBlank(apcd)) {
            arre_dfltPage = arre_dfltRepository.findAllByCodeAndCnnmContaining(apno, apcd, pageable);
        } else {
            arre_dfltPage = arre_dfltRepository.findAll(pageable);
        }
        System.out.println(arre_dfltPage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(arre_dfltPage.getTotalElements(), arre_dfltPage.getContent());
    }

    @GetMapping("/BLLS")
    public LayUiResult getBLLS(PageVo pageVo, @RequestParam(required = false) String btno, @RequestParam(required = false) String id) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<BLLS_BELT> blls_beltPage = null;
        if (StringUtils.isNoneBlank(btno) && StringUtils.isNoneBlank(id)) {
            blls_beltPage = blls_beltRepository.findAllByCodeAndCnnmContaining(btno, id, pageable);
        } else {
            blls_beltPage = blls_beltRepository.findAll(pageable);
        }
        System.out.println(blls_beltPage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(blls_beltPage.getTotalElements(), blls_beltPage.getContent());
    }




    //L




    @GetMapping("/BORE")
    public LayUiResult getBORE(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<Dflt_Bore> dflt_borePage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dflt_borePage = dflt_boreRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dflt_borePage = dflt_boreRepository.findAll(pageable);
        }
        System.out.println(dflt_borePage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dflt_borePage.getTotalElements(), dflt_borePage.getContent());
    }


    @GetMapping("/CANE")
    public LayUiResult getCANE(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<Dflt_Cane> dflt_canePage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dflt_canePage = dflt_caneRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dflt_canePage = dflt_caneRepository.findAll(pageable);
        }
        System.out.println(dflt_canePage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dflt_canePage.getTotalElements(), dflt_canePage.getContent());
    }

    @GetMapping("/CFCE")
    public LayUiResult getCFCE(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<Dflt_Cfce> dflt_cfcePage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dflt_cfcePage = dflt_cfceRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dflt_cfcePage = dflt_cfceRepository.findAll(pageable);
        }
        System.out.println(dflt_cfcePage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dflt_cfcePage.getTotalElements(), dflt_cfcePage.getContent());
    }

    @GetMapping("/CKIE")
    public LayUiResult getCKIE(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<Dflt_Ckie> dflt_ckiePage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dflt_ckiePage = dflt_ckieRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dflt_ckiePage = dflt_ckieRepository.findAll(pageable);
        }
        System.out.println(dflt_ckiePage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dflt_ckiePage.getTotalElements(), dflt_ckiePage.getContent());
    }

    @GetMapping("/CKOE")
    public LayUiResult getCKOE(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<Dflt_Ckoe> dflt_ckoePage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dflt_ckoePage = dflt_ckoeRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dflt_ckoePage = dflt_ckoeRepository.findAll(pageable);
        }
        System.out.println(dflt_ckoePage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dflt_ckoePage.getTotalElements(), dflt_ckoePage.getContent());
    }

    //z
    @GetMapping("/DEPE")
    public LayUiResult getDEPE(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<Dflt_Depe> dflt_depePage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dflt_depePage = dflt_depeRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dflt_depePage = dflt_depeRepository.findAll(pageable);
        }
        System.out.println(dflt_depePage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dflt_depePage.getTotalElements(), dflt_depePage.getContent());
    }

    @GetMapping("/DLYE")
    public LayUiResult getDLYE(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<Dflt_Dlye> dflt_dlyePage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dflt_dlyePage = dflt_dlyeRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dflt_dlyePage = dflt_dlyeRepository.findAll(pageable);
        }
        System.out.println(dflt_dlyePage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dflt_dlyePage.getTotalElements(), dflt_dlyePage.getContent());
    }

    @GetMapping("/FETT")
    public LayUiResult getFETT(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<Dflt_Fett> dflt_fettPage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dflt_fettPage = dflt_fettRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dflt_fettPage = dflt_fettRepository.findAll(pageable);
        }
        System.out.println(dflt_fettPage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dflt_fettPage.getTotalElements(), dflt_fettPage.getContent());
    }

    @GetMapping("/FPTT")
    public LayUiResult getFPTT(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<Dflt_Fptt> dflt_fpttPage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dflt_fpttPage = dflt_fpttRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dflt_fpttPage = dflt_fpttRepository.findAll(pageable);
        }
        System.out.println(dflt_fpttPage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dflt_fpttPage.getTotalElements(), dflt_fpttPage.getContent());
    }

    @GetMapping("/FRTT")
    public LayUiResult getFRTT(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<Dflt_Frtt> dflt_frttPage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dflt_frttPage = dflt_frttRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dflt_frttPage = dflt_frttRepository.findAll(pageable);
        }
        System.out.println(dflt_frttPage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dflt_frttPage.getTotalElements(), dflt_frttPage.getContent());
    }



    //r
    @GetMapping("/LBDE")
    public LayUiResult getLBDE(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<DFME_LBDE> dfme_lbdePage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dfme_lbdePage = dfme_lbdeRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dfme_lbdePage = dfme_lbdeRepository.findAll(pageable);
        }
        System.out.println(dfme_lbdePage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dfme_lbdePage.getTotalElements(), dfme_lbdePage.getContent());
    }

    @GetMapping("/ONRE")
    public LayUiResult getONRE(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<DFME_ONRE> dfme_onrePage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dfme_onrePage = onreRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dfme_onrePage = onreRepository.findAll(pageable);
        }
        System.out.println(dfme_onrePage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dfme_onrePage.getTotalElements(), dfme_onrePage.getContent());
    }

    @GetMapping("/POKE")
    public LayUiResult getPOKE(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<DFME_POKE> dfme_pokePage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dfme_pokePage = pokeRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dfme_pokePage = pokeRepository.findAll(pageable);
        }
        System.out.println(dfme_pokePage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dfme_pokePage.getTotalElements(), dfme_pokePage.getContent());
    }

    @GetMapping("/CKLS")
    public LayUiResult getCKLS(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<Dflt_Ckls_Cntr> dflt_ckls_cntrPage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dflt_ckls_cntrPage = dflt_ckls_cntrRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dflt_ckls_cntrPage = dflt_ckls_cntrRepository.findAll(pageable);
        }
        System.out.println(dflt_ckls_cntrPage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dflt_ckls_cntrPage.getTotalElements(), dflt_ckls_cntrPage.getContent());
    }

    @GetMapping("/GTLS")
    public LayUiResult getGTLS(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<Dflt_Gtls_Gate> dflt_gtls_gatePage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dflt_gtls_gatePage = dflt_gtls_gateRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dflt_gtls_gatePage = dflt_gtls_gateRepository.findAll(pageable);
        }
        System.out.println(dflt_gtls_gatePage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dflt_gtls_gatePage.getTotalElements(), dflt_gtls_gatePage.getContent());
    }

    @GetMapping("/STLS")
    public LayUiResult getSTLS(PageVo pageVo, @RequestParam(required = false) String flid, @RequestParam(required = false) String fide) {
        // 创建分页请求
        Pageable pageable = PageRequest.of(pageVo.getPage() - 1, pageVo.getLimit());
        // 调用查询方法获取分页结果
        Page<DFME_STLS_STND> dfme_stls_stndPage = null;
        if (StringUtils.isNoneBlank(flid) && StringUtils.isNoneBlank(fide)) {
            dfme_stls_stndPage = stndRepository.findAllByCodeAndCnnmContaining(flid, fide, pageable);
        } else {
            dfme_stls_stndPage = stndRepository.findAll(pageable);
        }
        System.out.println(dfme_stls_stndPage.getContent());
        // 将查询结果和分页信息封装到LayUiResult对象中进行返回
        return new LayUiResult(dfme_stls_stndPage.getTotalElements(), dfme_stls_stndPage.getContent());
    }
}
