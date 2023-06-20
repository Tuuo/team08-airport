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

}
