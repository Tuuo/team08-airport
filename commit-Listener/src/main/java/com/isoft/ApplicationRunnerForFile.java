package com.isoft;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
@Component
@Slf4j
public class ApplicationRunnerForFile implements ApplicationRunner {

    private String filePath = "E://DATA";
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            FileAlterationObserver observer = new FileAlterationObserver(new File(filePath));
            FileListener fileListener = new FileListener();
            observer.addListener(fileListener);

            FileAlterationMonitor monitor = new FileAlterationMonitor(5000,new FileAlterationObserver[]{observer});
            monitor.start();
        }catch (Exception e){
            log.error("文件监听启动失败");
            e.printStackTrace();
        }

    }
}
