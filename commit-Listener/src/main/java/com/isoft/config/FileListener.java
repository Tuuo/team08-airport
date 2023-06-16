package com.isoft.config;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileListener implements FileAlterationListener {
    static String filename = null;
    static XmlAnaly xmlAnaly = new XmlAnaly();


    /**
     * 监听器启动时执行的方法
     * @param fileAlterationObserver 文件变化观察器
     */
    @Override
    public void onStart(FileAlterationObserver fileAlterationObserver) {
        System.out.println("开始监听");
    }

    /**
     * 目录创建时执行的方法
     * @param directory 创建的目录
     */
    @Override
    public void onDirectoryCreate(File directory) {
        System.out.println("目录[新建]:"+directory.getAbsolutePath());
    }

    /**
     * 目录修改时执行的方法
     * @param directory 修改的目录
     */
    @Override
    public void onDirectoryChange(File directory) {
        System.out.println("目录[修改]:"+directory.getAbsolutePath());
    }

    /**
     * 目录删除时执行的方法
     * @param directory 删除的目录
     */
    @Override
    public void onDirectoryDelete(File directory) {
        System.out.println("目录[删除]:"+directory.getAbsolutePath());
    }

//    @Override
//    public void onFileCreate(File file) {
//        System.out.println("文件[新建]:"+file.getAbsolutePath());
//    }

    /**
     * 文件创建时执行的方法
     * @param file 创建的文件
     * 这段代码的作用是根据不同的文件名执行不同的操作
     * 首先提取文件名的前9个字符作为filename。
     * 然后，根据filename的不同取值，执行相应的操作。
     * 每个case分支都调用xmlAnaly对象的不同方法，并传递文件路径作为参数，然后打印出已经插入了该文件的消息
     */
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
            System.out.println("BASE-CFUE-"+file.getPath()+"已经插入了");

            break;
        case "DFME-AFID":

            xmlAnaly.getAfid(file.getPath());
            System.out.println("DFME-AFID-"+file.getPath()+"已经插入了");
            break;
        case "DFME-AIRL":
            xmlAnaly.getAirl(file.getPath());
            System.out.println("DFME-AIRL-"+file.getPath()+"已经插入了");
            break;
        case "DFME-ARRE":

            xmlAnaly.getArre(file.getPath());
            System.out.println("DFME-ARRE-"+file.getPath()+"已经插入了");
            break;
        case "DFME-BLLS":
            xmlAnaly.getBlls(file.getPath());
            System.out.println("DFME-BLLS-"+file.getPath()+"已经插入了");
            break;
        case "DFME-BORE":
            xmlAnaly.getBore(file.getPath());
            System.out.println("DFME-BORE-"+file.getPath()+"已经插入了");
            break;
        case "DFME-CANE":
            xmlAnaly.getCANE(file.getPath());
            System.out.println("DFME-CANE-"+file.getPath()+"已经插入了");
            break;
        case "DFME-CFCE":
            xmlAnaly.getCFCE(file.getPath());
            System.out.println("DFME-CFCE-"+file.getPath()+"已经插入了");
            break;
        case "DFME-CKIE":
            xmlAnaly.getCKIE(file.getPath());
            System.out.println("DFME-CKIE-"+file.getPath()+"已经插入了");
            break;
        case "DFME-CKLS":
            xmlAnaly.getCKLS(file.getPath());
            System.out.println("DFME-CKLS-"+file.getPath()+"已经插入了");
            break;
        case "DFME-CKOE":
            xmlAnaly.getCKOE(file.getPath());
            System.out.println("DFME-CKOE-"+file.getPath()+"已经插入了");
            break;
        case "DFME-DEPE":
            xmlAnaly.getDEPE(file.getPath());
            System.out.println("DFME-DEPE-"+file.getPath()+"已经插入了");
            break;
        case "DFME-DLYE":
            xmlAnaly.getDLYE(file.getPath());
            System.out.println("DFME-DLYE-"+file.getPath()+"已经插入了");
            break;
        case "DFME-FETT":
            xmlAnaly.getFETT(file.getPath());
            System.out.println("DFME-FETT-"+file.getPath()+"已经插入了");
            break;
        case "DFME-FPTT":
            xmlAnaly.getFPTT(file.getPath());
            System.out.println("DFME-FPTT-"+file.getPath()+"已经插入了");
            break;
        case "DFME-GTLS":
            xmlAnaly.getGTLS(file.getPath());
            System.out.println("DFME-GTLS-"+file.getPath()+"已经插入了");
            break;
        case "DFME-FRTT":
            xmlAnaly.getFRTT(file.getPath());
            System.out.println("DFME-FRTT-"+file.getPath()+"已经插入了");
            break;
        case "DFME-ONRE":
            xmlAnaly.getONRE(file.getPath());
            System.out.println("DFME-ONRE-"+file.getPath()+"已经插入了");
            break;
        case "DFME-LBDE":
            xmlAnaly.getLBDE(file.getPath());
            System.out.println("DFME-LBDE-"+file.getPath()+"已经插入了");
            break;
        case "DFME-POKE":
            xmlAnaly.getPOKE(file.getPath());
            System.out.println("DFME-POKE-"+file.getPath()+"已经插入了");
            break;
        case "DFME-STLS":
            xmlAnaly.getSTLS(file.getPath());
            System.out.println("DFME-STLS-"+file.getPath()+"已经插入了");
            break;
        case "DFOE-DFIE":
            xmlAnaly.getDFIE(file.getPath());
            System.out.println("DFOE-DFIE-"+file.getPath()+"已经插入了");
            break;
        case "DFOE-DFDL":
            xmlAnaly.getDFDL(file.getPath());
            System.out.println("DFOE-DFDL-"+file.getPath()+"已经插入了");
            break;
    }
        System.out.println("创建文件");
}

    /**
     * 文件修改时执行的方法
     * @param file 修改的文件
     */
    @Override
    public void onFileChange(File file) {
        System.out.println("文件[修改]:"+file.getAbsolutePath());
    }

    /**
     * 文件删除时执行的方法
     * @param file 删除的文件
     */
    @Override
    public void onFileDelete(File file) {
        System.out.println("文件[删除]:"+file.getAbsolutePath());
    }


    /**
     * 监听器停止时执行的方法
     * @param observer 文件变化观察器
     */
    @Override
    public void onStop(FileAlterationObserver observer) {
        System.out.println("结束监听");
    }
}
