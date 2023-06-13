package com.isoft.config;


import com.isoft.entity.*;
import com.isoft.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;


/**
 * xml解析工具包
 */
@Transactional
@Slf4j
public class XmlAnaly {

    private ApotRepository apotRepository = BeanContext.getBean(ApotRepository.class);
    private CrftRepository crftRepository = BeanContext.getBean(CrftRepository.class);
    private MetaRepository metaRepository = BeanContext.getBean(MetaRepository.class);
    private AFID_DfltRepository afid_dfltRepository = BeanContext.getBean(AFID_DfltRepository.class);
    private AIRL_DfltRepository airl_dfltRepository = BeanContext.getBean(AIRL_DfltRepository.class);
    private AIRL_ArptRepository airl_arptRepository = BeanContext.getBean(AIRL_ArptRepository.class);
    private Dflt_BoreRepository dflt_boreRepository = BeanContext.getBean(Dflt_BoreRepository.class);
    private Dflt_CaneRepository dflt_caneRepository = BeanContext.getBean(Dflt_CaneRepository.class);
    private Dflt_CfceRepository dflt_cfceRepository = BeanContext.getBean(Dflt_CfceRepository.class);
    private Dflt_CkieRepository dflt_ckieRepository = BeanContext.getBean(Dflt_CkieRepository.class);
    private Dflt_Ckls_CntrRepository dflt_ckls_cntrRepository = BeanContext.getBean(Dflt_Ckls_CntrRepository.class);
    private Dflt_CklsRepository dflt_cklsRepository = BeanContext.getBean(Dflt_CklsRepository.class);
    private Dflt_CkoeRepository dflt_ckoeRepository = BeanContext.getBean(Dflt_CkoeRepository.class);
    private BLLS_BeltRepository blls_beltRepository = BeanContext.getBean(BLLS_BeltRepository.class);
    private BLLS_DfltRepository blls_dfltRepository = BeanContext.getBean(BLLS_DfltRepository.class);
    private ARRE_DfltRepository arre_dfltRepository = BeanContext.getBean(ARRE_DfltRepository.class);

    private Dflt_DepeRepository dflt_depeRepository = BeanContext.getBean(Dflt_DepeRepository.class);

    private Dflt_DlyeRepository dflt_dlyeRepository = BeanContext.getBean(Dflt_DlyeRepository.class);

    private Dflt_FettRepository dflt_fettRepository = BeanContext.getBean(Dflt_FettRepository.class);

    private Dflt_FpttRepository dflt_fpttRepository = BeanContext.getBean(Dflt_FpttRepository.class);

    private Dflt_FrttRepository dflt_frttRepository = BeanContext.getBean(Dflt_FrttRepository.class);
    private Dflt_Gtls_GateRepository dflt_gtls_gateRepository = BeanContext.getBean(Dflt_Gtls_GateRepository.class);
    private Dflt_GtlsRepository dflt_gtlsRepository = BeanContext.getBean(Dflt_GtlsRepository.class);


    /**
     * BASE_APUE
     */
    public void getApue(String path) {
        File file = new File(path);
        //对数据进行解析
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read(file);    //读取文档
            Element root = doc.getRootElement();    //取得根元素
            List<Element> elements = root.elements();    //获取所有的元素

            //META
            Element element = root.element("META");
            Meta meta = new Meta();
            for (Element e : elements) {
                if (e == element) {
                    meta.setSndr(e.elementText("SNDR"));
                    String rcvrStr = StringUtil.trimToNull(e.elementText("RCVR"));
                    String rcvr = rcvrStr == null ? null : rcvrStr;
                    meta.setRcvr(rcvr);
                    String seqnStr = e.elementText("SEQN");
                    long seqn = Long.parseLong(seqnStr);
                    meta.setSeqn(seqn);
                    meta.setDdtm(e.elementText("DDTM"));
                    meta.setType(e.elementText("TYPE"));
                    meta.setStyp(e.elementText("STYP"));
                    break;
                }
            }
            System.out.println(meta);
            metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                    meta.getDdtm(), meta.getType(), meta.getStyp());

            //APOT
            Element element2 = root.element("APOT");
            Apot apot = new Apot();
            for (Element e : elements) {
                if (e == element2) {
//                    apot.setMeta_id(meta.getSeqn());
                    apot.setCode(e.elementText("CODE"));
                    apot.setFrcd(e.elementText("APAT"));
                    apot.setApat(e.elementText("APAT"));
                    apot.setCnnm(e.elementText("CNNM"));
                    apot.setEnnm(e.elementText("ENNM"));
                    apot.setAiso(e.elementText("AISO"));
                    apot.setApsn(e.elementText("APSN"));
//                    System.out.println(apot);
                    break;
                }
            }
            System.out.println(apot);
            System.out.println(meta.getSeqn());
            if (apotRepository == null) {
//                throw new IllegalStateException("apotRepository not initialized");
                System.out.println("apotRepository为空");
            } else {
                System.out.println("apotRepository不为空");
            }
            apotRepository.saveApot(meta.getSeqn(), apot.getCode(), apot.getFrcd(),
                    apot.getApat(), apot.getCnnm(), apot.getEnnm(),
                    apot.getAiso(), apot.getApsn());

        } catch (Exception e) {
            log.info("出错啦");
            e.printStackTrace();
        }
    }

    /**
     * BASE_CFUE
     */
    public void getCfue(String path) {

        StringBuilder result = new StringBuilder();
        File file = new File(path);
        try {
            // 构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            // 使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
                s.replaceAll(" ", "");
                result.append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //对数据进行解析
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();
//        System.out.println(root);
        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());
        //APOT
        Element element2 = root.element("CRFT");
        Crft crft = new Crft();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element2) {
                crft.setCode(linkman.elementText("CODE"));
                crft.setCftp(linkman.elementText("CFTP"));
                crft.setAwcd(linkman.elementText("AWCD"));
                String stnmStr = StringUtil.trimToNull(linkman.elementText("STNM"));
                Integer stnm = stnmStr == null ? null : Integer.parseInt(stnmStr);
                crft.setStnm(stnm);
                String rstnStr = StringUtil.trimToNull(linkman.elementText("RSTN"));
                Integer rstn = rstnStr == null ? null : Integer.parseInt(rstnStr);
                crft.setRstn(rstn);
                String cfsaStr = StringUtil.trimToNull(linkman.elementText("CFSA"));
                Integer cfsa = cfsaStr == null ? null : Integer.parseInt(cfsaStr);
                crft.setRstn(cfsa);
                String ttwcStr = StringUtil.trimToNull(linkman.elementText("TTWC"));
                Float ttwc = ttwcStr == null ? null : Float.parseFloat(ttwcStr);
                crft.setTtwc(ttwc);
                String mxlwStr = StringUtil.trimToNull(linkman.elementText("MXLW"));
                Float mxlw = mxlwStr == null ? null : Float.parseFloat(mxlwStr);
                crft.setMxlw(mxlw);
                String rllwStr = StringUtil.trimToNull(linkman.elementText("RLLW"));
                Float rllw = rllwStr == null ? null : Float.parseFloat(rllwStr);
                crft.setRllw(rllw);

                System.out.println(crft);
                break;
            } else {
                continue;
            }
        }
        crftRepository.saveCrft(meta.getSeqn(), crft.getCode(), crft.getCftp(), crft.getAwcd(),
                crft.getStnm(), crft.getRstn(), crft.getCfsa(), crft.getTtwc(), crft.getMxlw(), crft.getRllw());

    }
//}

    /**
     * DFME_AFID
     */
    public void getAfid(String path) {

        StringBuilder result = new StringBuilder();
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();
//        System.out.println(root);
        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());
        //APOT
        Element element2 = root.element("DFLT");
        AFID_Dflt afid_dflt = new AFID_Dflt();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element2) {
                String flidStr = StringUtil.trimToNull(linkman.elementText("FLID"));
                Long flid = flidStr == null ? null : Long.parseLong(flidStr);
                afid_dflt.setFlid(flid);
                afid_dflt.setFfid(linkman.elementText("FFID"));
                afid_dflt.setFide(linkman.elementText("FIDE"));
                afid_dflt.setAfid(linkman.elementText("AFID"));
                System.out.println(afid_dflt);
                break;
            } else {
                continue;
            }
        }
        afid_dfltRepository.saveApot(meta.getSeqn(), afid_dflt.getFlid(), afid_dflt.getFfid(), afid_dflt.getFide(), afid_dflt.getAfid());

    }


    /**
     * DFME_AIRL
     */
    public void getAirl(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();
//        System.out.println(root);
        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());
        //APOT
        Element element2 = root.element("DFLT");
        Element element3 = element2.element("AIRL");
        List<Element> arpts = element3.elements("ARPT");
        System.out.println(arpts);
        Iterator<Element> iter2 = element3.elementIterator();

        AIRL_Dflt airl_dflt = new AIRL_Dflt();
        AIRL_Arpt airl_arpt = new AIRL_Arpt();
        while (iter.hasNext()) {
            Element linkman = iter.next();
//            Element linkman2 = iter2.next();
//            System.out.println(linkman2);
            if (linkman == element2) {
                String flidStr = StringUtil.trimToNull(linkman.elementText("FLID"));
                Long flid = flidStr == null ? null : Long.parseLong(flidStr);
                airl_dflt.setFlid(flid);
                airl_dflt.setFide(linkman.elementText("FIDE"));
                airl_dflt.setFfid(linkman.elementText("FFID"));
                System.out.println(airl_dflt);
                airl_dfltRepository.saveApot(meta.getSeqn(), airl_dflt.getFlid(), airl_dflt.getFide(), airl_dflt.getFfid());
                while (iter2.hasNext()) {
                    Element linkman2 = iter2.next();
                    if (!"ARPT".equals(linkman2.getName())) {
                        continue;
                    }
                    String apnoStr = StringUtil.trimToNull(linkman2.elementText("APNO"));
                    Integer apno = apnoStr == null ? null : Integer.parseInt(apnoStr);
                    airl_arpt.setApno(apno);
                    airl_arpt.setApcd(linkman2.elementText("APCD"));
                    airl_arpt.setFptt(linkman2.elementText("FPTT"));
                    airl_arpt.setFett(linkman2.elementText("FETT"));
                    airl_arpt.setFrtt(linkman2.elementText("FRTT"));
                    airl_arpt.setFplt(linkman2.elementText("FPLT"));
                    airl_arpt.setFelt(linkman2.elementText("FELT"));
                    airl_arpt.setFrlt(linkman2.elementText("FRLT"));
                    airl_arpt.setApat(linkman2.elementText("APAT"));
                    System.out.println(airl_arpt);
                    airl_arptRepository.saveApot(airl_arpt.getApno(), airl_arpt.getApcd(), airl_arpt.getFptt(),
                            airl_arpt.getFett(), airl_arpt.getFrtt(), airl_arpt.getFplt(), airl_arpt.getFelt(),
                            airl_arpt.getFrlt(), airl_arpt.getApat(), airl_dflt.getFlid());
                }
                break;
            } else {
                continue;
            }
        }
    }


    /**
     * DFME_ARRE
     */
    public void getArre(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();
//        System.out.println(root);
        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());
        //APOT
        Element element2 = root.element("DFLT");
        ARRE_Dflt arre_dflt = new ARRE_Dflt();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element2) {
                String flidStr = StringUtil.trimToNull(linkman.elementText("FLID"));
                Long flid = flidStr == null ? null : Long.parseLong(flidStr);
                arre_dflt.setFlid(flid);
                arre_dflt.setFatt(linkman.elementText("FATT"));
                arre_dflt.setFfid(linkman.elementText("FFID"));
                arre_dflt.setFide(linkman.elementText("FIDE"));
                arre_dflt.setStat(linkman.elementText("STAT"));
                arre_dflt.setIsta(linkman.elementText("ISTA"));
                arre_dflt.setMsta(linkman.elementText("MSTA"));
                arre_dflt.setMist(linkman.elementText("MIST"));
                arre_dflt.setFrlt(linkman.elementText("FRLT"));
                System.out.println(arre_dflt);
                break;
            } else {
                continue;
            }
        }
        arre_dfltRepository.saveApot(meta.getSeqn(), arre_dflt.getFlid(), arre_dflt.getFfid(),
                arre_dflt.getFide(), arre_dflt.getFatt(), arre_dflt.getStat(), arre_dflt.getIsta(),
                arre_dflt.getFrlt(), arre_dflt.getMsta(), arre_dflt.getMist());

    }


    /**
     * DFME_BLLS
     */
    public void getBlls(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();


        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        //Dflt
        Element element2 = root.element("DFLT");
        Element element3 = element2.element("BLLS");
        List<Element> elements = element3.elements("BELT");

        Iterator<Element> iter2 = element3.elementIterator();

        BLLS_Dflt blls_dflt = new BLLS_Dflt();
        BLLS_BELT blls_belt = new BLLS_BELT();
        while (iter.hasNext()) {
            Element linkman = iter.next();
//            Element linkman2 = iter2.next();
//            System.out.println(linkman2);
            if (linkman == element2) {
                String flidStr = StringUtil.trimToNull(linkman.elementText("FLID"));
                Long flid = flidStr == null ? null : Long.parseLong(flidStr);
                blls_dflt.setFlid(flid);
                blls_dflt.setFide(linkman.elementText("FIDE"));
                blls_dflt.setFfid(linkman.elementText("FFID"));
                blls_dflt.setFatt(linkman.elementText("FATT"));
                System.out.println(blls_dflt);
                blls_dfltRepository.saveApot(meta.getSeqn(), blls_dflt.getFlid(),
                        blls_dflt.getFfid(), blls_dflt.getFide(), blls_dflt.getFatt());
                while (iter2.hasNext()) {
                    Element linkman2 = iter2.next();
                    System.out.println(linkman2);
                    String btnoStr = StringUtil.trimToNull(linkman2.elementText("BTNO"));
                    Integer btno = btnoStr == null ? null : Integer.parseInt(btnoStr);
                    blls_belt.setBtno(btno);
                    String idStr = StringUtil.trimToNull(linkman2.elementText("ID"));
                    Long id = idStr == null ? null : Long.parseLong(idStr);
                    blls_belt.setId(id);
                    blls_belt.setCode(linkman2.elementText("CODE"));
                    blls_belt.setBtat(linkman2.elementText("BTAT"));
                    blls_belt.setEstr(linkman2.elementText("ESTR"));
                    blls_belt.setEend(linkman2.elementText("EEND"));
                    blls_belt.setRstr(linkman2.elementText("RSTR"));
                    blls_belt.setRend(linkman2.elementText("REND"));
                    blls_belt.setBtsc(linkman2.elementText("BTSC"));
                    System.out.println(blls_belt);
                    blls_beltRepository.saveApot(blls_belt.getBtno(), blls_belt.getId(),
                            blls_belt.getCode(), blls_belt.getBtat(), blls_belt.getEstr(), blls_belt.getEend(),
                            blls_belt.getRstr(), blls_belt.getRend(), blls_belt.getBtsc(), blls_dflt.getFlid());
                }
                break;
            } else {
                continue;
            }


        }
//        System.out.println(dflt);

    }

    /**
     * DFME_BORE
     */
    public void getBore(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();


        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        //Dflt
        Element element2 = root.element("DFLT");
        Dflt_Bore dflt = new Dflt_Bore();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            System.out.println(linkman);
            System.out.println(element2);
            if (linkman == element2) {
                dflt.setFlid(linkman.elementText("FLID"));
                dflt.setFfid(linkman.elementText("FFID"));
                dflt.setFide(linkman.elementText("FIDE"));
                dflt.setFatt(linkman.elementText("FATT"));
                dflt.setStat(linkman.elementText("STAT"));
                dflt.setIsta(linkman.elementText("ISTA"));
                dflt.setBort(linkman.elementText("BORT"));
                dflt.setMsta(linkman.elementText("MSTA"));
                dflt.setMist(linkman.elementText("MIST"));
                dflt.setMbor(linkman.elementText("MBOR"));
                System.out.println(dflt);
                break;
            } else {
                continue;
            }
        }
        dflt_boreRepository.saveDflt(meta.getSeqn(), dflt.getFlid(), dflt.getFfid(), dflt.getFide(),
                dflt.getFatt(), dflt.getStat(), dflt.getIsta(), dflt.getBort(), dflt.getMsta(),
                dflt.getMist(), dflt.getMbor());
    }

    /**
     * DFME-CANE
     */
    public void getCANE(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();


        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        //Dflt
        Element element2 = root.element("DFLT");
        Dflt_Cane dflt = new Dflt_Cane();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            System.out.println(linkman);
            System.out.println(element2);
            if (linkman == element2) {
                dflt.setFlid(linkman.elementText("FLID"));
                dflt.setFfid(linkman.elementText("FFID"));
                dflt.setFide(linkman.elementText("FIDE"));
                dflt.setFatt(linkman.elementText("FATT"));
                dflt.setAbst(linkman.elementText("ABST"));
                dflt.setIast(linkman.elementText("IAST"));
                dflt.setAbrs(linkman.elementText("ABRS"));
                dflt.setIars(linkman.elementText("IARS"));
                dflt.setMabs(linkman.elementText("MABS"));
                dflt.setMabr(linkman.elementText("MABR"));
                dflt.setMias(linkman.elementText("MIAS"));
                dflt.setMiar(linkman.elementText("MIAR"));
                System.out.println(dflt);
                break;
            } else {
                continue;
            }
        }
        dflt_caneRepository.saveDflt(meta.getSeqn(), dflt.getFlid(), dflt.getFfid(), dflt.getFide(),
                dflt.getFatt(), dflt.getAbst(), dflt.getIast(), dflt.getAbrs(), dflt.getIars(),
                dflt.getMabs(), dflt.getMabr(), dflt.getMias(), dflt.getMiar());
    }

    /**
     * DFME-CFCE
     */
    public void getCFCE(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();


        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        //Dflt
        Element element2 = root.element("DFLT");
        Dflt_Cfce dflt = new Dflt_Cfce();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            System.out.println(linkman);
            System.out.println(element2);
            if (linkman == element2) {
                dflt.setFlid(linkman.elementText("FLID"));
                dflt.setFfid(linkman.elementText("FFID"));
                dflt.setFide(linkman.elementText("FIDE"));
                dflt.setCftp(linkman.elementText("CFTP"));
                dflt.setCfno(linkman.elementText("CFNO"));
                System.out.println(dflt);
                break;
            } else {
                continue;
            }
        }
        dflt_cfceRepository.saveDflt(meta.getSeqn(), dflt.getFlid(), dflt.getFfid(), dflt.getFide(),
                dflt.getCftp(), dflt.getCfno());
    }

    /**
     * DFME-CKIE
     */
    public void getCKIE(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();


        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        //Dflt
        Element element2 = root.element("DFLT");
        Dflt_Ckie dflt = new Dflt_Ckie();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            System.out.println(linkman);
            System.out.println(element2);
            if (linkman == element2) {
                dflt.setFlid(linkman.elementText("FLID"));
                dflt.setFfid(linkman.elementText("FFID"));
                dflt.setFide(linkman.elementText("FIDE"));
                dflt.setFatt(linkman.elementText("FATT"));
                dflt.setStat(linkman.elementText("STAT"));
                dflt.setIsta(linkman.elementText("ISTA"));
                dflt.setFcrs(linkman.elementText("FCRS"));
                dflt.setMsta(linkman.elementText("MSTA"));
                dflt.setMist(linkman.elementText("MIST"));
                dflt.setMcrs(linkman.elementText("MCRS"));
                System.out.println(dflt);
                break;
            } else {
                continue;
            }
        }
        dflt_ckieRepository.saveDflt(meta.getSeqn(), dflt.getFlid(), dflt.getFfid(), dflt.getFide(),
                dflt.getFatt(), dflt.getStat(), dflt.getIsta(), dflt.getFcrs(), dflt.getMsta(), dflt.getMist(),
                dflt.getMcrs());
    }

    /**
     * DFME-CKLS
     */
    public void getCKLS(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();


        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        Element element2 = root.element("DFLT");
        Element element3 = element2.element("CKLS");
        List<Element> elementList = element2.elements();
        List<Element> elements = element3.elements("CNTR");
        Dflt_Ckls dflt = new Dflt_Ckls();
        Dflt_Ckls_Cntr dflt_ckls_cntr = new Dflt_Ckls_Cntr();
        Iterator<Element> iter2 = element3.elementIterator();
        Iterator<Element> iter3 = element2.elementIterator();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element2) {
                String FLIDStr = linkman.elementText("FLID");
                long FLID = Long.parseLong(FLIDStr);
                dflt.setFlid(FLID);
                dflt.setFfid(linkman.elementText("FFID"));
                dflt.setFide(linkman.elementText("FIDE"));
                dflt.setFatt(linkman.elementText("FATT"));
                while (iter3.hasNext()) {
                    Element linkman3 = iter3.next();
                    for (Element element1 : elementList) {
                        System.out.println(element1);
                        if (linkman3 == element1) {
                            System.out.println(linkman3 + "-----2");
                            dflt.setFces(linkman3.elementText("FCES"));
                            dflt.setFcee(linkman3.elementText("FCEE"));
                            dflt.setFcrs(linkman3.elementText("FCRS"));
                            dflt.setFcre(linkman3.elementText("FCRE"));
                            dflt.setMces(linkman3.elementText("MCES"));
                            dflt.setMcee(linkman3.elementText("MCEE"));
                            dflt.setMcrs(linkman3.elementText("MCRS"));
                            dflt.setMcre(linkman3.elementText("MCRE"));
                            dflt.setFcdp(linkman3.elementText("FCDP"));
                            dflt.setMcdp(linkman3.elementText("MCDP"));
                            System.out.println(dflt);
                        }
                    }
                }
                dflt_cklsRepository.saveDflt(meta.getSeqn(), dflt.getFlid(), dflt.getFfid(), dflt.getFide(),
                        dflt.getFatt(), dflt.getFces(), dflt.getFcee(), dflt.getFcrs(), dflt.getFcre(), dflt.getMces(),
                        dflt.getMcee(), dflt.getMcrs(), dflt.getMcre(), dflt.getFcdp(), dflt.getMcdp());

                while (iter2.hasNext()) {
                    Element linkman2 = iter2.next();
                    for (Element element5 : elements) {
                        if (linkman2 == element5) {
                            dflt_ckls_cntr.setCkno(linkman2.elementText("CKNO"));
                            String idStr = linkman2.elementText("ID");
                            long id = Long.parseLong(idStr);
                            dflt_ckls_cntr.setId(id);
                            dflt_ckls_cntr.setCode(linkman2.elementText("CODE"));
                            dflt_ckls_cntr.setCkat(linkman2.elementText("CKAT"));
                            dflt_ckls_cntr.setType(linkman2.elementText("TYPE"));
                            dflt_ckls_cntr.setCcar(linkman2.elementText("CCAR"));
                            dflt_ckls_cntr.setEstr(linkman2.elementText("ESTR"));
                            dflt_ckls_cntr.setEend(linkman2.elementText("EEND"));
                            dflt_ckls_cntr.setRstr(linkman2.elementText("RSTR"));
                            dflt_ckls_cntr.setRend(linkman2.elementText("REND"));
                            dflt_ckls_cntr.setRstr(linkman2.elementText("BTSC"));
                            dflt_ckls_cntr.setBtsc(linkman2.elementText("BTSC"));

                            System.out.println(dflt_ckls_cntr);
                            dflt_ckls_cntrRepository.saveDflt(dflt_ckls_cntr.getCkno(),
                                    dflt_ckls_cntr.getId(), dflt_ckls_cntr.getCode(), dflt_ckls_cntr.getCkat(),
                                    dflt_ckls_cntr.getType(), dflt_ckls_cntr.getCcar(), dflt_ckls_cntr.getEstr(),
                                    dflt_ckls_cntr.getEend(), dflt_ckls_cntr.getRstr(), dflt_ckls_cntr.getRend(),
                                    dflt_ckls_cntr.getBtsc(), dflt.getFlid());
                        } else {
                            continue;
                        }

                    }


                }
                break;
            }
        }
    }

    /**
     * DFME-CKOE
     */
    public void getCKOE(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();


        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        //Dflt
        Element element2 = root.element("DFLT");
        Dflt_Ckoe dflt = new Dflt_Ckoe();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            System.out.println(linkman);
            System.out.println(element2);
            if (linkman == element2) {
                dflt.setFlid(linkman.elementText("FLID"));
                dflt.setFfid(linkman.elementText("FFID"));
                dflt.setFide(linkman.elementText("FIDE"));
                dflt.setFatt(linkman.elementText("FATT"));
                dflt.setStat(linkman.elementText("STAT"));
                dflt.setIsta(linkman.elementText("ISTA"));
                dflt.setFcre(linkman.elementText("FCRE"));
                dflt.setMsta(linkman.elementText("MSTA"));
                dflt.setMist(linkman.elementText("MIST"));
                dflt.setMcre(linkman.elementText("MCRE"));
                System.out.println(dflt);
                break;
            } else {
                continue;
            }
        }
        dflt_ckoeRepository.saveDflt(meta.getSeqn(), dflt.getFlid(), dflt.getFfid(), dflt.getFide(),
                dflt.getFatt(), dflt.getStat(), dflt.getIsta(), dflt.getFcre(), dflt.getMsta(), dflt.getMist(),
                dflt.getMcre());
    }

    /**
     * DFME-DEPE
     */
    public void getDEPE(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();


        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        //Dflt
        Element element2 = root.element("DFLT");
        Dflt_Depe dflt = new Dflt_Depe();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            System.out.println(linkman);
            System.out.println(element2);
            if (linkman == element2) {
                dflt.setFlid(linkman.elementText("FLID"));
                dflt.setFatt(linkman.elementText("FATT"));
                dflt.setFfid(linkman.elementText("FFID"));
                dflt.setFide(linkman.elementText("FIDE"));
                dflt.setStat(linkman.elementText("STAT"));
                dflt.setIsta(linkman.elementText("ISTA"));
                dflt.setMsta(linkman.elementText("MSTA"));
                dflt.setMist(linkman.elementText("MIST"));
                dflt.setFrtt(linkman.elementText("FRTT"));
                System.out.println(dflt);
                break;
            } else {
                continue;
            }
        }
        dflt_depeRepository.saveDflt(meta.getSeqn(), dflt.getFlid(), dflt.getFatt(), dflt.getFfid(), dflt.getFide(),
                dflt.getStat(), dflt.getIsta(), dflt.getMsta(),
                dflt.getMist(), dflt.getFrtt());
    }

    /**
     * DFME-DLYE
     */
    public void getDLYE(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();


        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        //Dflt
        Element element2 = root.element("DFLT");
        Dflt_Dlye dflt = new Dflt_Dlye();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            System.out.println(linkman);
            System.out.println(element2);
            if (linkman == element2) {
                dflt.setFlid(linkman.elementText("FLID"));
                dflt.setFfid(linkman.elementText("FFID"));
                dflt.setFide(linkman.elementText("FIDE"));
                dflt.setFatt(linkman.elementText("FATT"));
                dflt.setAbst(linkman.elementText("ABST"));
                dflt.setIast(linkman.elementText("IAST"));
                dflt.setAbrs(linkman.elementText("ABRS"));
                dflt.setIars(linkman.elementText("IARS"));
                dflt.setMabs(linkman.elementText("MABS"));
                dflt.setMabr(linkman.elementText("MABR"));
                dflt.setMias(linkman.elementText("MIAS"));
                dflt.setMiar(linkman.elementText("MIAR"));
                dflt.setFett(linkman.elementText("FETT"));
                System.out.println(dflt);
                break;
            } else {
                continue;
            }
        }
        dflt_dlyeRepository.saveDflt(meta.getSeqn(), dflt.getFlid(), dflt.getFfid(), dflt.getFide(),
                dflt.getFatt(), dflt.getAbst(), dflt.getIast(), dflt.getAbrs(), dflt.getIars(),
                dflt.getMabs(), dflt.getMabr(), dflt.getMias(), dflt.getMiar(), dflt.getFett());
    }

    /**
     * DFME-FETT
     */
    public void getFETT(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();


        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        //Dflt
        Element element2 = root.element("DFLT");
        Dflt_Fett dflt = new Dflt_Fett();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            System.out.println(linkman);
            System.out.println(element2);
            if (linkman == element2) {
                dflt.setFlid(linkman.elementText("FLID"));
                dflt.setFfid(linkman.elementText("FFID"));
                dflt.setFide(linkman.elementText("FIDE"));
                dflt.setFett(linkman.elementText("FETT"));
                dflt.setFelt(linkman.elementText("FELT"));
                System.out.println(dflt);
                break;
            } else {
                continue;
            }
        }
        dflt_fettRepository.saveDflt(meta.getSeqn(), dflt.getFlid(), dflt.getFfid(), dflt.getFide(),
                dflt.getFett(), dflt.getFelt());
    }

    /**
     * DFME-FPTT
     */
    public void getFPTT(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();


        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        //Dflt
        Element element2 = root.element("DFLT");
        Dflt_Fptt dflt = new Dflt_Fptt();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            System.out.println(linkman);
            System.out.println(element2);
            if (linkman == element2) {
                dflt.setFlid(linkman.elementText("FLID"));
                dflt.setFfid(linkman.elementText("FFID"));
                dflt.setFide(linkman.elementText("FIDE"));
                dflt.setFptt(linkman.elementText("FPTT"));
                dflt.setFplt(linkman.elementText("FPLT"));
                System.out.println(dflt);
                break;
            } else {
                continue;
            }
        }
        dflt_fpttRepository.saveDflt(meta.getSeqn(), dflt.getFlid(), dflt.getFfid(), dflt.getFide(),
                dflt.getFptt(), dflt.getFplt());
    }

    /**
     * DFME-FRTT
     */
    public void getFRTT(String path) {
        File file = new File(path);

        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();


        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        //Dflt
        Element element2 = root.element("DFLT");
        Dflt_Frtt dflt = new Dflt_Frtt();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            System.out.println(linkman);
            System.out.println(element2);
            if (linkman == element2) {
                dflt.setFlid(linkman.elementText("FLID"));
                dflt.setFfid(linkman.elementText("FFID"));
                dflt.setFide(linkman.elementText("FIDE"));
                dflt.setFrtt(linkman.elementText("FRTT"));
                dflt.setFrlt(linkman.elementText("FRLT"));
                System.out.println(dflt);
                break;
            } else {
                continue;
            }
        }
        dflt_frttRepository.saveDflt(meta.getSeqn(), dflt.getFlid(), dflt.getFfid(), dflt.getFide(),
                dflt.getFrtt(), dflt.getFrlt());
    }

    /**
     * DFME-GTLS
     */
    public void getGTLS(String path) {
        File file = new File(path);
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(file);    //读取文档
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();    //取得根元素
        Iterator<Element> iter = root.elementIterator();


        //META
        Element element = root.element("META");
        Meta meta = new Meta();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element) {
                meta.setSndr(linkman.elementText("SNDR"));
                String rcvrStr = StringUtil.trimToNull(linkman.elementText("RCVR"));
                String rcvr = rcvrStr == null ? null : rcvrStr;
                meta.setRcvr(rcvr);
                String seqnStr = linkman.elementText("SEQN");
                long seqn = Long.parseLong(seqnStr);
                meta.setSeqn(seqn);
                meta.setDdtm(linkman.elementText("DDTM"));
                meta.setType(linkman.elementText("TYPE"));
                meta.setStyp(linkman.elementText("STYP"));
                System.out.println(meta);
                break;
            } else {
                continue;
            }
        }

        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        //Dflt
        Element element2 = root.element("DFLT");
        Element element3 = element2.element("GTLS");
        List<Element> elements = element3.elements("GATE");
        Dflt_Gtls dflt = new Dflt_Gtls();
        Dflt_Gtls_Gate dflt_gtls_gate = new Dflt_Gtls_Gate();
        Iterator<Element> iter2 = element3.elementIterator();

        while (iter.hasNext()) {
            Element linkman = iter.next();
            System.out.println(linkman);
//            System.out.println(element2);
            if (linkman == element2 || linkman == element3) {
                String FLIDStr = linkman.elementText("FLID");
                long FLID = Long.parseLong(FLIDStr);
                dflt.setFlid(FLID);
                dflt.setFfid(linkman.elementText("FFID"));
                dflt.setFide(linkman.elementText("FIDE"));
                dflt.setFatt(linkman.elementText("FATT"));
                System.out.println(linkman + "-----2");
                dflt_gtlsRepository.saveDflt(meta.getSeqn(), dflt.getFlid(), dflt.getFfid(), dflt.getFide(),
                        dflt.getFatt());
                while (iter2.hasNext()) {
                    Element linkman2 = iter2.next();
//                    System.out.println(linkman2);

                    for (Element element5 : elements) {
                        if (linkman2 == element5) {
                            dflt_gtls_gate.setGtno(linkman2.elementText("GTNO"));
                            String idStr = linkman2.elementText("ID");
                            long id = Long.parseLong(idStr);
                            dflt_gtls_gate.setId(id);
                            dflt_gtls_gate.setCode(linkman2.elementText("CODE"));
                            dflt_gtls_gate.setGtat(linkman2.elementText("GTAT"));
                            dflt_gtls_gate.setEstr(linkman2.elementText("ESTR"));
                            dflt_gtls_gate.setEend(linkman2.elementText("EEND"));
                            dflt_gtls_gate.setRstr(linkman2.elementText("RSTR"));
                            dflt_gtls_gate.setRend(linkman2.elementText("REND"));
                            dflt_gtls_gate.setBtsc(linkman2.elementText("BTSC"));
                            System.out.println(dflt_gtls_gate);
                            dflt_gtls_gateRepository.saveDflt(dflt_gtls_gate.getGtno(),
                                    dflt_gtls_gate.getId(), dflt_gtls_gate.getCode(), dflt_gtls_gate.getGtat(),
                                    dflt_gtls_gate.getEstr(), dflt_gtls_gate.getEend(), dflt_gtls_gate.getRstr(),
                                    dflt_gtls_gate.getRend(), dflt_gtls_gate.getBtsc(), dflt.getFlid());
//                break;
                        } else {
                            continue;
                        }
                    }

                }
                break;
            } else {
                continue;
            }

        }
    }
}


