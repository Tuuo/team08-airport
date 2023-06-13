package com.isoft.config;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileListener implements FileAlterationListener {
    static String filename = null;
    static XmlAnaly xmlAnaly = new XmlAnaly();



    @Override
    public void onStart(FileAlterationObserver fileAlterationObserver) {
        System.out.println("开始监听");
    }

    @Override
    public void onDirectoryCreate(File directory) {
        System.out.println("目录[新建]:"+directory.getAbsolutePath());
    }

    @Override
    public void onDirectoryChange(File directory) {
        System.out.println("目录[修改]:"+directory.getAbsolutePath());
    }

    @Override
    public void onDirectoryDelete(File directory) {
        System.out.println("目录[删除]:"+directory.getAbsolutePath());
    }

//    @Override
//    public void onFileCreate(File file) {
//        System.out.println("文件[新建]:"+file.getAbsolutePath());
//    }
@Override
public void onFileCreate(File file) {

    filename = file.getName().substring(0, 9);
    switch (filename) {
        case "BASE-APUE":
            //得到    baseApue  的 信息
            xmlAnaly.getApue(file.getPath());
            System.out.println(file.getPath()+"已经插入了");
            break;
        case "BASE-CFUE":

            xmlAnaly.getCfue(file.getPath());
            System.out.println("BASE-CFUE-"+filename+"已经插入了");

            break;
        case "DFME-AFID":

            xmlAnaly.getAfid(file.getPath());
            System.out.println("DFME-AFID-"+filename+"已经插入了");
            break;
        case "DFME-AIRL":
            xmlAnaly.getAirl(file.getPath());
            System.out.println("DFME-AIRL-"+filename+"已经插入了");
            break;
        case "DFME-ARRE":

            xmlAnaly.getArre(file.getPath());
            System.out.println("DFME-ARRE-"+filename+"已经插入了");
            break;
        case "DFME-BLLS":
            xmlAnaly.getBlls(file.getPath());
            System.out.println("DFME-BLLS-"+filename+"已经插入了");
            break;
        case "DFME-BORE":
            xmlAnaly.getBore(file.getPath());
            System.out.println("DFME-BORE-"+filename+"已经插入了");
            break;
        case "DFME-CANE":
            xmlAnaly.getCANE(file.getPath());
            System.out.println("DFME-CANE-"+filename+"已经插入了");
            break;
        case "DFME-CFCE":
            xmlAnaly.getCFCE(file.getPath());
            System.out.println("DFME-CFCE-"+filename+"已经插入了");
            break;
        case "DFME-CKIE":
            xmlAnaly.getCKIE(file.getPath());
            System.out.println("DFME-CKIE-"+filename+"已经插入了");
            break;
        case "DFME-CKLS":
            xmlAnaly.getCKLS(file.getPath());
            System.out.println("DFME-CKLS-"+filename+"已经插入了");
            break;
        case "DFME-CKOE":
            xmlAnaly.getCKOE(file.getPath());
            System.out.println("DFME-CKOE-"+filename+"已经插入了");
            break;
        case "DFME-DEPE":
            xmlAnaly.getDEPE(file.getPath());
            System.out.println("DFME-DEPE-"+filename+"已经插入了");
            break;
        case "DFME-DLYE":
            xmlAnaly.getDLYE(file.getPath());
            System.out.println("DFME-DLYE-"+filename+"已经插入了");
            break;
        case "DFME-FETT":
            xmlAnaly.getFETT(file.getPath());
            System.out.println("DFME-FETT-"+filename+"已经插入了");
            break;
        case "DFME-FPTT":
            xmlAnaly.getFPTT(file.getPath());
            System.out.println("DFME-FPTT-"+filename+"已经插入了");
            break;
        case "DFME-GTLS":
            xmlAnaly.getGTLS(file.getPath());
            System.out.println("DFME-GTLS-"+filename+"已经插入了");
            break;
        case "DFME-FRTT":
            xmlAnaly.getFRTT(file.getPath());
            System.out.println("DFME-FRTT-"+filename+"已经插入了");
            break;
    }
        System.out.println("创建文件");
}
    @Override
    public void onFileChange(File file) {
        System.out.println("文件[修改]:"+file.getAbsolutePath());
    }

    @Override
    public void onFileDelete(File file) {
        System.out.println("文件[删除]:"+file.getAbsolutePath());
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
        System.out.println("结束监听");
    }
}
