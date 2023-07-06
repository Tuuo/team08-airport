package com.isoft;

import com.isoft.config.FileListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;

/*在应用程序启动时启动文件监听器，以便在指定目录中的文件发生变化时执行相应的操作*/
@Component
@Slf4j
public class ApplicationRunnerForFile implements ApplicationRunner {

    //定义了要监视文件变化的目录路径
    private String filePath = "D://DATA";

    /*在应用程序启动时执行任务的入口点。它由Spring Boot在应用程序上下文初始化后调用*/
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            //创建一个FileAlterationObserver对象，指定要监视的文件路径。filePath变量包含要监视的目录路径
            FileAlterationObserver observer = new FileAlterationObserver(new File(filePath));
            //创建一个FileListener对象，用于处理文件事件。这个对象需要根据实际需求自定义，它将在文件发生变化时被调用
            FileListener fileListener = new FileListener();
            //将FileListener对象添加到FileAlterationObserver中，以便在文件发生变化时触发相应的事件
            observer.addListener(fileListener);
            //创建一个FileAlterationMonitor对象，并设置监视的间隔时间为5000毫秒（即5秒）。
            // 将之前创建的FileAlterationObserver对象传递给监视器
            FileAlterationMonitor monitor = new FileAlterationMonitor(5000,new FileAlterationObserver[]{observer});
            //启动文件监视器，开始监听文件的变化
            monitor.start();
        }catch (Exception e){
            //如果在设置过程中出现任何异常，将记录错误日志并打印异常堆栈信息
            log.error("文件监听启动失败");
            e.printStackTrace();
        }

    }
}
