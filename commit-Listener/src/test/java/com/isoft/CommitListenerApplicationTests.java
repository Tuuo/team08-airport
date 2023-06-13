package com.isoft;

import com.isoft.config.StringUtil;
import com.isoft.entity.*;

import com.isoft.repository.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.sql.*;
import java.util.Iterator;
import java.util.List;


@SpringBootTest
class CommonListenerApplicationTests {
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

    /**
     * 吴修清
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws FileNotFoundException
     */
    @Test
    void testA() throws ClassNotFoundException, SQLException, FileNotFoundException {
        File file = new File("E://Temp//wu//BASE-APUE-20170606231907.xml");
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
                meta.setRcvr(linkman.elementText("RCVR"));
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
        Element element2 = root.element("APOT");
        Apot apot = new Apot();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element2) {
                apot.setCode(linkman.elementText("CODE"));
                apot.setFrcd(linkman.elementText("APAT"));
                apot.setApat(linkman.elementText("APAT"));
                apot.setCnnm(linkman.elementText("CNNM"));
                apot.setEnnm(linkman.elementText("ENNM"));
                apot.setAiso(linkman.elementText("AISO"));
                apot.setApsn(linkman.elementText("APSN"));
                System.out.println(apot);
                break;
            } else {
                continue;
            }
        }
        apotRepository.saveApot(meta.getSeqn(), apot.getCode(), apot.getFrcd(),
                apot.getApat(), apot.getCnnm(), apot.getEnnm(),
                apot.getAiso(), apot.getApsn());

    }

    @Test
    void testCFUE() throws ClassNotFoundException, SQLException, FileNotFoundException {
        File file = new File("E://Temp//wu//BASE-CFUE-20170606113521.xml");
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

    @Test
    void testAFID() throws ClassNotFoundException, SQLException, FileNotFoundException {
        File file = new File("E://Temp//wu//DFME-AFID-20170606201129.xml");
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

    @Test
    void testAIRL() throws ClassNotFoundException, SQLException, FileNotFoundException {
        File file = new File("E://Temp//wu//DFME-AIRL-20170606192916.xml");
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
                            airl_arpt.getFrlt(), airl_arpt.getApat(),airl_dflt.getFlid());
                }
                break;
            } else {
                continue;
            }
        }

    }

    @Test
    void testARRE() throws ClassNotFoundException, SQLException, FileNotFoundException {
        File file = new File("E://Temp//wu//DFME-ARRE-20170606234401.xml");
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

    @Test
    void testBLLS() throws ClassNotFoundException, SQLException, FileNotFoundException {

        File file = new File("E://Temp//wu//DFME-BLLS-20170606234007.xml");
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
     * 李希晨
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws FileNotFoundException
     */

    @Test
    void testBORE() throws ClassNotFoundException, SQLException, FileNotFoundException {

        File file = new File("D://Temp//plane//DFME-BORE-20170601055648.xml");
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

    @Test
    void testCANE() throws ClassNotFoundException, SQLException, FileNotFoundException {

        File file = new File("D://Temp//plane//DFME-CANE-20170601105143.xml");
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

    @Test
    void testCFCE() throws ClassNotFoundException, SQLException, FileNotFoundException {

        File file = new File("D://Temp//plane//DFME-CFCE-20170601061944.xml");
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

    @Test
    void testCKIE() throws ClassNotFoundException, SQLException, FileNotFoundException {

        File file = new File("D://Temp//plane//DFME-CKIE-20170601044511.xml");
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

    @Test
    void testCKLS() throws ClassNotFoundException, SQLException, FileNotFoundException {

        File file = new File("E://Temp//wu//DFME-CKLS-20170606221903.xml");
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
//
        metaRepository.saveMeta(meta.getSndr(), meta.getRcvr(), meta.getSeqn(),
                meta.getDdtm(), meta.getType(), meta.getStyp());


        //Dflt
        //Dflt
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

    @Test
    void testCKOE() throws ClassNotFoundException, SQLException, FileNotFoundException {

        File file = new File("D://Temp//plane//DFME-CKOE-20170601060011.xml");
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
     * 赵淑祺
     */
    @Test
    void testDEPE() throws ClassNotFoundException, SQLException, FileNotFoundException {

        File file = new File("C://temp//DEPE//01//DFME-DEPE-20170601001712.xml");
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
        dflt_depeRepository.saveDflt(meta.getSeqn(), dflt.getFlid(),  dflt.getFatt(),dflt.getFfid(), dflt.getFide(),
                dflt.getStat(), dflt.getIsta(),  dflt.getMsta(),
                dflt.getMist(), dflt.getFrtt());
    }

    @Test
    void testDLYE() throws ClassNotFoundException, SQLException, FileNotFoundException {

        File file = new File("C://temp//DLYE//01//DFME-DLYE-20170601065608.xml");
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
                dflt.getMabs(), dflt.getMabr(), dflt.getMias(), dflt.getMiar(),dflt.getFett());
    }

    @Test
    void testFETT() throws ClassNotFoundException, SQLException, FileNotFoundException {

        File file = new File("C://temp//FETT//01//DFME-FETT-20170601010600.xml");
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
                dflt.getFett(),dflt.getFelt());
    }

    @Test
    void testFPTT() throws ClassNotFoundException, SQLException, FileNotFoundException {

        File file = new File("C://temp//FPTT//01//DFME-FPTT-20170601181725.xml");
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
                dflt.getFptt(),dflt.getFplt());
    }

    @Test
    void testFRTT() throws ClassNotFoundException, SQLException, FileNotFoundException {

        File file = new File("C://temp//FRTT//01//DFME-FRTT-20170601000137.xml");
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

    @Test
    void testGTLS() throws ClassNotFoundException, SQLException, FileNotFoundException {

        File file = new File("C://temp//GTLS//01//DFME-GTLS-20170601001716.xml");
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
                System.out.println(linkman+"-----2");
                dflt_gtlsRepository.saveDflt(meta.getSeqn(), dflt.getFlid(), dflt.getFfid(), dflt.getFide(),
                        dflt.getFatt());
                while (iter2.hasNext()){
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
                                    dflt_gtls_gate.getRend(), dflt_gtls_gate.getBtsc(),dflt.getFlid());
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
//        System.out.println(dflt);

    }

    /**
     * 张昊瑞
     */
    @Test
    void testLBDE() throws ClassNotFoundException, SQLException, FileNotFoundException {
        File file = new File("D://xinchuang//zhang//DFME-LBDE-20170606161704.xml");
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
                meta.setRcvr(linkman.elementText("RCVR"));
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
        //LBDE
        Element element2 = root.element("DFLT");
        DFME_LBDE lbde = new DFME_LBDE();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element2) {
                String flidStr = linkman.elementText("FLID");
                long flid = Long.parseLong(flidStr);
                lbde.setFlid(flid);
                lbde.setFfid(linkman.elementText("FFID"));
                lbde.setFide(linkman.elementText("FIDE"));
                lbde.setFatt(linkman.elementText("FATT"));
                lbde.setStat(linkman.elementText("STAT"));
                lbde.setIsta(linkman.elementText("ISTA"));
                lbde.setLbdt(linkman.elementText("LBDT"));
                lbde.setMsta(linkman.elementText("MSTA"));
                lbde.setMist(linkman.elementText("MIST"));
                lbde.setMlbd(linkman.elementText("MLBD"));
                System.out.println(lbde);
                break;
            } else {
                continue;
            }
        }
        dfme_lbdeRepository.saveDFME(meta.getSeqn(), lbde.getFlid(), lbde.getFfid(),
                lbde.getFide(), lbde.getFatt(), lbde.getStat(), lbde.getIsta(),
                lbde.getLbdt(), lbde.getMsta(), lbde.getMist(), lbde.getMlbd());

    }


    @Test
    void testONRE() throws ClassNotFoundException, SQLException, FileNotFoundException {
        File file = new File("D://xinchuang//zhang//DFME-ONRE-20170606234001.xml");
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
                meta.setRcvr(linkman.elementText("RCVR"));
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
        //ONRE
        Element element2 = root.element("DFLT");
        DFME_ONRE onre = new DFME_ONRE();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element2) {
                String flidStr = linkman.elementText("FLID");
                long flid = Long.parseLong(flidStr);
                onre.setFlid(flid);
                onre.setFfid(linkman.elementText("FFID"));
                onre.setFide(linkman.elementText("FIDE"));
                onre.setFatt(linkman.elementText("FATT"));
                onre.setStat(linkman.elementText("STAT"));
                onre.setIsta(linkman.elementText("ISTA"));
                onre.setMsta(linkman.elementText("MSTA"));
                onre.setMist(linkman.elementText("MIST"));
                onre.setPast(linkman.elementText("PAST"));
                onre.setEldt(linkman.elementText("ELDT"));
                System.out.println(onre);
                break;
            } else {
                continue;
            }
        }
        onreRepository.saveDFME(meta.getSeqn(), onre.getFlid(), onre.getFfid(),
                onre.getFide(), onre.getFatt(), onre.getStat(), onre.getIsta(),
                onre.getMsta(), onre.getMist(), onre.getPast(), onre.getEldt());
    }


    @Test
    void testPOKE() throws ClassNotFoundException, SQLException, FileNotFoundException {
        File file = new File("D://xinchuang//zhang//DFME-POKE-20170606230025.xml");
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
                meta.setRcvr(linkman.elementText("RCVR"));
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
        //ONRE
        Element element2 = root.element("DFLT");
        DFME_POKE poke = new DFME_POKE();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element2) {
                String flidStr = linkman.elementText("FLID");
                long flid = Long.parseLong(flidStr);
                poke.setFlid(flid);
                poke.setFfid(linkman.elementText("FFID"));
                poke.setFide(linkman.elementText("FIDE"));
                poke.setFatt(linkman.elementText("FATT"));
                poke.setStat(linkman.elementText("STAT"));
                poke.setIsta(linkman.elementText("ISTA"));
                poke.setPokt(linkman.elementText("POKT"));
                poke.setMsta(linkman.elementText("MSTA"));
                poke.setMist(linkman.elementText("MIST"));
                poke.setMpok(linkman.elementText("MPOK"));

                System.out.println(poke);
                break;
            } else {
                continue;
            }
        }
        pokeRepository.saveDFME(meta.getSeqn(), poke.getFlid(), poke.getFfid(),
                poke.getFide(), poke.getFatt(), poke.getStat(), poke.getIsta(),
                poke.getPokt(), poke.getMsta(), poke.getMist(), poke.getMpok());
    }


    @Test
    void testSTLS() throws ClassNotFoundException, SQLException, FileNotFoundException {
        File file = new File("D://xinchuang//zhang//DFME-STLS-20170606234831.xml");
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
                meta.setRcvr(linkman.elementText("RCVR"));
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
        //STLS
        Element element2 = root.element("DFLT");
        DFME_STLS stls = new DFME_STLS();
        while (iter.hasNext()) {
            Element linkman = iter.next();
            if (linkman == element2) {
                String flidStr = linkman.elementText("FLID");
                long flid = Long.parseLong(flidStr);
                stls.setFlid(flid);
                stls.setFfid(linkman.elementText("FFID"));
                stls.setFide(linkman.elementText("FIDE"));
                stls.setFatt(linkman.elementText("FATT"));

                System.out.println(stls);
                stlsRepository.saveDFME(meta.getSeqn(), stls.getFlid(), stls.getFfid(),
                        stls.getFide(), stls.getFatt());
                break;
            } else {
                continue;
            }
        }


        //STLS_STND
        Element element3 = root.element("DFLT");
        Element element4 = element3.element("STLS");
        List<Element> elements = element4.elements();
        Iterator<Element> iter2 = element4.elementIterator();
        DFME_STLS_STND stnd = new DFME_STLS_STND();
        while (iter2.hasNext()) {
            Element linkman = iter2.next();
//            System.out.println(linkman);
            System.out.println(elements);
            for (Element element1 : elements) {
                System.out.println(element1);
                if (linkman == element1) {
                    stnd.setStno(linkman.elementText("STNO"));
                    stnd.setCode(linkman.elementText("CODE"));
                    stnd.setEstr(linkman.elementText("ESTR"));
                    stnd.setEend(linkman.elementText("EEND"));
                    stnd.setRstr(linkman.elementText("RSTR"));
                    stnd.setRend(linkman.elementText("REND"));
                    stnd.setCssi(linkman.elementText("CSSI"));
                    stnd.setBtsc(linkman.elementText("BTSC"));

                    System.out.println(stnd);
                    stndRepository.saveDFME(stls.getFlid(), stnd.getStno(), stnd.getCode(),
                            stnd.getEstr(), stnd.getEend(), stnd.getRstr(), stnd.getRend(),
                            stnd.getCssi(), stnd.getBtsc());
//                    break;
                } else {
                    continue;
                }
            }
        }
//        stndRepository.saveDFME(stls.getFlid(), stnd.getStno(), stnd.getCode(),
//                stnd.getEstr(), stnd.getEend(), stnd.getRstr(), stnd.getRend(),
//                stnd.getCssi(), stnd.getBtsc());
    }
}





